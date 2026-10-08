# Modulo de Seguridad y Autenticacion JWT (Spring Security 6 & PostgreSQL)

Documentacion tecnica y guia de integracion para la implementacion del sistema de seguridad basado en **Spring Security 6**, **JSON Web Tokens (JWT)** y **PostgreSQL** dentro de la rama `activityMigration` del proyecto Back-Intro.

---

## Descripcion General

Esta rama (`activityMigration`) extiende la arquitectura hexagonal y basada en Domain-Driven Design (DDD) del sistema para incorporar un esquema completo de **Autenticacion Stateless, Autorizacion basada en Roles (RBAC) y Encriptacion de Credenciales**, protegiendo el acceso a los endpoints HTTP correspondientes a los 53 Bounded Contexts de la aplicacion.

---

## Tecnologias y Componentes de Seguridad

- **Spring Security 6**: Proteccion y gestion de autenticacion stateless sin manejo de sesiones en servidor.
- **JWT (JSON Web Tokens)**: Algoritmo HMAC-SHA256 para emision, firma y validacion de tokens Bearer.
- **BCrypt Password Encoder**: Algoritmo de hashing salteado para el almacenamiento seguro de contraseñas.
- **Flyway Migration (V10)**: Script SQL `V10__security_users_and_roles.sql` para la creacion del esquema relacional de seguridad y siembra de roles.
- **PostgreSQL 17**: Persistencia de datos en esquema dedicado `mindconnect_schema`.

---

## Modelo de Dominio y Persistencia (Flyway V10)

La seguridad se estructura mediante las siguientes tablas creadas en la migracion V10:

1. **`users`**: Almacena identificador unico (`UUID`), correo electronico, hash de contraseña (`BCrypt`), estado de cuenta (`active`, `locked`), contador de intentos fallidos y referencias opcionales a `professionals` y `patients`.
2. **`roles`**: Contiene la definición de roles del sistema (`ROLE_ADMIN`, `ROLE_PROFESSIONAL`, `ROLE_PATIENT`).
3. **`permissions`**: Permisos granulares de lectura y escritura (`CLINICAL_NOTE_READ`, `PATIENT_READ`, `CHAT_WRITE`, etc.).
4. **`user_roles`**: Tabla de asociacion N:M entre usuarios y roles.
5. **`role_permissions`**: Tabla de asociacion N:M entre roles y permisos.

---

## Arquitectura del Modulo de Autenticacion

Seguimiento estricto de la Arquitectura Hexagonal en tres capas:

```
back-intro/
├── domain/auth/
│   ├── model/
│   │   ├── aggregate/User.java          # Entidad de dominio con regla de negocio de seguridad
│   │   ├── entity/Role.java             # Entidad de rol de dominio
│   │   └── valueobject/                 # UserId, Email, PasswordHash
│   └── port/
│       ├── repository/                  # UserRepository, RoleRepository
│       └── security/                    # PasswordHasherPort, TokenProviderPort
│
├── application/auth/
│   ├── usecase/
│   │   ├── LoginUseCase.java            # Autenticacion, validacion de contraseña y emision de token
│   │   └── RegisterUserUseCase.java     # Registro de usuario, validacion de duplicados y hash
│   ├── command/                         # LoginCommand, RegisterUserCommand
│   └── dto/                             # AuthTokenResponse, UserResponse
│
└── infrastructure/auth/
    ├── config/
    │   ├── SecurityConfig.java          # SecurityFilterChain, reglas CORS/CSRF y autorizaciones
    │   └── AuthBeansConfig.java         # Configuracion de Beans de uso de casos y adaptadores
    ├── security/
    │   ├── JwtAuthenticationFilter.java # Interceptor de peticiones HTTP para extraer y validar Bearer JWT
    │   ├── JwtAuthenticationEntryPoint.java # Manejo de excepciones 401 Unauthorized
    │   └── SecurityUser.java            # Implementacion de UserDetails de Spring Security
    └── adapters/
        ├── in/rest/controllers/AuthController.java # Endpoints /api/v1/auth/login y /register
        └── out/
            ├── persistence/             # Entities JPA, Repositories y Mappers
            └── security/                # BCryptPasswordHasherAdapter, JwtTokenProviderAdapter
```

---

## Reglas de Proteccion HTTP

En `SecurityConfig.java` se define la siguiente directiva de proteccion:

- **Rutas Publicas**:
  - `POST /api/v1/auth/register` (Registro de usuarios)
  - `POST /api/v1/auth/login` (Autenticacion y emision de token)
  - `/swagger-ui/**`, `/v3/api-docs/**` (Documentacion de API)
- **Rutas Restringidas**:
  - `/api/v1/clinical-notes/**`: Requiere rol `ROLE_PROFESSIONAL` o `ROLE_ADMIN`.
  - **Cualquier otra ruta (`anyRequest()`)**: Requiere estar autenticado con un token JWT valido (Header `Authorization: Bearer <TOKEN>`).

---

## Guia de Instalacion y Ejecucion

### 1. Ubicarse en la rama del modulo de seguridad

```bash
git checkout activityMigration
```

### 2. Iniciar PostgreSQL con Docker Compose

```bash
docker compose up -d
```

### 3. Compilar y ejecutar la aplicacion Spring Boot

```bash
mvn clean spring-boot:run -Dspring-boot.run.profiles=dev
```

Durante el despliegue, Flyway ejecutara de forma automatica las migraciones de la `V1` a la `V10`.

---

## Guia de Pruebas de Funcionamiento

### Prueba 1: Peticion sin Token (Acceso Bloqueado)

Intento de acceso a un recurso protegido sin credenciales:

```bash
curl -i -X GET http://localhost:8080/api/v1/patients
```

**Respuesta esperada:**
```http
HTTP/1.1 401 Unauthorized
```

---

### Prueba 2: Registro de Usuario

Creacion de un usuario administrador:

```bash
curl -i -X POST http://localhost:8080/api/v1/auth/register \
  -H "Content-Type: application/json" \
  -d '{
    "email": "admin@mindconnect.com",
    "password": "Password123!",
    "roles": ["ROLE_ADMIN"]
  }'
```

**Respuesta esperada:**
```http
HTTP/1.1 201 Created
```

---

### Prueba 3: Autenticacion e Obtencion de Token JWT

Inicio de sesion para obtener el token de acceso:

```bash
curl -i -X POST http://localhost:8080/api/v1/auth/login \
  -H "Content-Type: application/json" \
  -d '{
    "email": "admin@mindconnect.com",
    "password": "Password123!"
  }'
```

**Respuesta esperada:**
```http
HTTP/1.1 200 OK
Content-Type: application/json

{
  "accessToken": "eyJhbGciOiJIUzI1NiIsInR5cCI6...",
  "tokenType": "Bearer",
  "expiresIn": 3600000
}
```

---

### Prueba 4: Peticion Autenticada con Token JWT

Copiar el valor recibido en `accessToken` y adjuntarlo en la cabecera `Authorization`:

```bash
curl -i -X GET http://localhost:8080/api/v1/patients \
  -H "Authorization: Bearer <TOKEN_OBTENIDO_EN_PRUEBA_3>"
```

**Respuesta esperada:**
```http
HTTP/1.1 200 OK
```

---

## Licencia

Este proyecto se distribuye bajo la licencia MIT.
