# Demo DDD - Back-Intro Architecture

Sistema backend desarrollado bajo los principios de **Domain-Driven Design (DDD)**, **Arquitectura Hexagonal (Puertos y Adaptadores)** y **Clean Architecture**. El proyecto implementa una arquitectura basada en **53 Bounded Contexts independientes**, mapeados de forma exacta a partir de esquemas relacionales de base de datos PostgreSQL mediante migraciones de Flyway.

---

## Tecnologias Utilizadas

- **Lenguaje**: Java 21 / Java 25
- **Framework Principal**: Spring Boot 3.3.x (Spring Web, Spring Data JPA)
- **Base de Datos**: PostgreSQL 17
- **Gestor de Migraciones**: Flyway Migration (Migraciones V1 a V10)
- **Seguridad**: Spring Security 6 + JWT (JSON Web Tokens) con BCrypt y RBAC
- **Contenedorizacion**: Docker & Docker Compose
- **Herramienta de Construccion**: Apache Maven (Proyecto Multimodulo)

> **NOTA SOBRE LA RAMA DE SEGURIDAD**:
> Toda la implementacion de **Spring Security 6, JWT, migracion V10 y adaptadores de autenticacion** se encuentra desarrollada en la rama:
> **`activityMigration`**

---

## Estructura de Arquitectura Multimodulo

El proyecto se divide en tres modulos principales con estricta separacion de responsabilidades:

```
back-intro/
├── domain/            # Capa de Dominio (Logica pura de negocio sin dependencias externas)
├── application/       # Capa de Aplicacion (Casos de uso, Comandos y DTOs)
└── infrastructure/    # Capa de Infraestructura (Spring Boot, JPA, Controladores REST, Config, Security)
```

### 1. Modulo Domain
Contiene el modelo de dominio puro sin ninguna dependencia de frameworks de persistencia o controladores HTTP:
- **Aggregate Root**: Entidades principales del dominio que encapsulan el estado y registran eventos.
- **Value Objects**: Encapsulamiento inmutable de identificadores (`UUID`) y atributos con validaciones.
- **Domain Events**: Eventos de dominio emitidos ante cambios de estado (`RegisteredEvent`, `UpdatedEvent`, `DeletedEvent`).
- **Ports (Repository & Security Interfaces)**: Interfaces que definen los contratos de persistencia y seguridad (`UserRepository`, `RoleRepository`, `TokenProviderPort`, `PasswordEncoderPort`).

### 2. Modulo Application
Coordina la ejecucion de la logica de negocio a traves de casos de uso:
- **Use Cases**: Clases encargadas de ejecutar operaciones individuales (`Register`, `GetById`, `List`, `Update`, `Delete`, `LoginUseCase`, `RegisterUserUseCase`).
- **Commands**: Java Records inmutables para transferir datos de entrada hacia el caso de uso.
- **DTOs / Responses**: Records para retornar informacion hacia las capas exteriores.

### 3. Modulo Infrastructure
Implementa los detalles tecnologicos y adaptadores de la arquitectura hexagonal:
- **Adapters In (REST Controllers)**: Controladores REST que exponen endpoints HTTP (`POST`, `GET`, `PUT`, `DELETE`, `AuthController`).
- **Adapters Out (Persistence & Security)**: Entidades JPA (`@Entity`), interfaces `JpaRepository`, mappers, adaptadores de seguridad (`BCryptPasswordHasherAdapter`, `JwtTokenProviderAdapter`).
- **Security & Config**: `SecurityConfig` (SecurityFilterChain stateless con JWT), `JwtAuthenticationFilter`, `JwtAuthenticationEntryPoint`.

---

## Bounded Contexts (1 Tabla = 1 Modulo)

Cada tabla de la base de datos funciona como un Bounded Context independiente compuesto por sus propias tres capas (`domain`, `application`, `infrastructure`).

Principales dominios incluidos:
- **Seguridad y Autenticacion (V10)**: `User`, `Role`, `Permission`, `UserRole`, `RolePermission`.
- **Geografico y Catalogos (V1)**: `Country`, `StateRegion`, `CityMunicipality`, `DocumentType`, `Gender`, `RelationshipType`.
- **Profesionales y Estudios (V2)**: `Professional`, `ProfessionalType`, `Study`, `ProfessionalStudy`.
- **Pacientes y Contactos (V3-V4)**: `Patient`, `PatientAllergy`, `Contact`, `PhoneContact`, `EmailContact`, `PatientContact`.
- **Historias Clinicas y Consultas (V5-V6)**: `ClinicalRecord`, `ClinicalRecordStatus`, `Encounter`, `EncounterType`, `EncounterModality`, `EncounterStatus`, `ClinicalNote`, `MentalStatusExam`, `RiskAssessment`, `RiskLevel`.
- **Tratamientos y Diagnosticos (V7)**: `TreatmentPlan`, `TreatmentGoal`, `TreatmentStatus`, `TreatmentGoalStatus`, `MedicationRoute`, `AssessmentType`, `ConsentType`, `DiagnosticSystem`.
- **Chat, Escalaciones e IA (V8-V9)**: `ChatConversation`, `ChatParticipant`, `ChatMessage`, `ChatAiSettings`, `ChatAiRun`, `ChatAiRunMetric`, `ChatAiRunError`, `ChatEscalation`, `ChatEscalationAssignment`, `ChatEscalationStatusHistory`, `AiModel`, `ProviderModelAi`, `SenderType`, `MessageType`, `Priority`, `ConversationStatus`, `AiRunStatus`, `EscalationStatus`.

---

## Requisitos Previos

- **JDK 21** o superior instalado.
- **Docker Desktop** / **Docker Engine** en ejecucion.
- **Apache Maven 3.8+** (o el wrapper si aplica).

---

## Guia de Instalacion, Ejecucion y Pruebas

### 1. Ubicarse en la rama correcta

Asegurate de estar en la rama donde esta implementada la seguridad:

```bash
git checkout activityMigration
```

### 2. Iniciar Base de Datos PostgreSQL con Docker

Levantar el contenedor de PostgreSQL con Docker Compose:

```bash
docker compose up -d
```

Verificar que el contenedor `mindconnect-db` este saludable:

```bash
docker ps
```

### 3. Compilar y Ejecutar la Aplicacion

Ejecutar la aplicacion con el perfil de desarrollo (`dev`):

```bash
mvn clean spring-boot:run -Dspring-boot.run.profiles=dev
```

Al iniciar, **Flyway** creara automaticamente el esquema `mindconnect_schema` y ejecutara las 10 migraciones (`V1` a `V10`), sembrando los roles `ROLE_ADMIN`, `ROLE_PROFESSIONAL` y `ROLE_PATIENT`.

---

## Como Probar el Flujo Completo de Seguridad JWT

### Prueba 1: Acceso Bloqueado sin Token (Esperado: 401 Unauthorized)
Intenta consultar cualquier recurso protegido (por ejemplo, pacientes):

```bash
curl -i -X GET http://localhost:8080/api/v1/patients
```
> **Respuesta esperada:** `HTTP/1.1 401 Unauthorized`

---

### Prueba 2: Registro de Usuario
Registra un nuevo usuario con rol `ROLE_ADMIN`:

```bash
curl -i -X POST http://localhost:8080/api/v1/auth/register \
  -H "Content-Type: application/json" \
  -d '{
    "email": "admin@mindconnect.com",
    "password": "Password123!",
    "roles": ["ROLE_ADMIN"]
  }'
```
> **Respuesta esperada:** `HTTP/1.1 201 Created` con el ID del usuario y correo.

---

### Prueba 3: Inicio de Sesion y Obtencion del Token JWT
Inicia sesion para obtener el token Bearer:

```bash
curl -i -X POST http://localhost:8080/api/v1/auth/login \
  -H "Content-Type: application/json" \
  -d '{
    "email": "admin@mindconnect.com",
    "password": "Password123!"
  }'
```
> **Respuesta esperada:** `HTTP/1.1 200 OK` retornando JSON con:
> ```json
> {
>   "accessToken": "eyJhbGciOiJIUzI1NiIsInR5cCI6...",
>   "tokenType": "Bearer",
>   "expiresIn": 3600000
> }
> ```

---

### Prueba 4: Acceso Autorizado con Token JWT
Copia el `accessToken` obtenido y envialo en el header `Authorization`:

```bash
curl -i -X GET http://localhost:8080/api/v1/patients \
  -H "Authorization: Bearer <TU_TOKEN_AQUI>"
```
> **Respuesta esperada:** `HTTP/1.1 200 OK` con la lista de registros de la tabla.

---

## Licencia

Este proyecto esta bajo la licencia MIT.
