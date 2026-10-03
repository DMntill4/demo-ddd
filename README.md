# Demo DDD - Back-Intro Architecture

Sistema backend desarrollado bajo los principios de **Domain-Driven Design (DDD)**, **Arquitectura Hexagonal (Puertos y Adaptadores)** y **Clean Architecture**. El proyecto implementa una arquitectura basada en **53 Bounded Contexts independientes**, mapeados de forma exacta a partir de esquemas relacionales de base de datos PostgreSQL mediante migraciones de Flyway.

---

## Tecnologias Utilizadas

- **Lenguaje**: Java 21 / Java 25
- **Framework Principal**: Spring Boot 3.3.x (Spring Web, Spring Data JPA)
- **Base de Datos**: PostgreSQL 17
- **Gestor de Migraciones**: Flyway Migration (Migraciones V1 a V9)
- **Contenedorizacion**: Docker & Docker Compose
- **Herramienta de Construccion**: Apache Maven (Proyecto Multimodulo)

---

## Estructura de Arquitectura Multimodulo

El proyecto se divide en tres modulos principales con estricta separacion de responsabilidades:

```
back-intro/
├── domain/            # Capa de Dominio (Logica pura de negocio sin dependencias externas)
├── application/       # Capa de Aplicacion (Casos de uso, Comandos y DTOs)
└── infrastructure/    # Capa de Infraestructura (Spring Boot, JPA, Controladores REST, Config)
```

### 1. Modulo Domain
Contiene el modelo de dominio puro sin ninguna dependencia de frameworks de persistencia o controladores HTTP:
- **Aggregate Root**: Entidades principales del dominio que encapsulan el estado y registran eventos.
- **Value Objects**: Encapsulamiento inmutable de identificadores (`UUID`) y atributos con validaciones.
- **Domain Events**: Eventos de dominio emitidos ante cambios de estado (`RegisteredEvent`, `UpdatedEvent`, `DeletedEvent`).
- **Ports (Repository Interfaces)**: Interfaces que definen los contratos de persistencia que la infraestructura debe implementar.

### 2. Modulo Application
Coordina la ejecucion de la logica de negocio a traves de casos de uso:
- **Use Cases**: Clases encargadas de ejecutar operaciones individuales (`Register`, `GetById`, `List`, `Update`, `Delete`).
- **Commands**: Java Records inmutables para transferir datos de entrada hacia el caso de uso.
- **DTOs / Responses**: Records para retornar informacion hacia las capas exteriores.

### 3. Modulo Infrastructure
Implementa los detalles tecnologicos y adaptadores de la arquitectura hexagonal:
- **Adapters In (REST Controllers)**: Controladores REST que exponen endpoints HTTP (`POST`, `GET`, `PUT`, `DELETE`).
- **Adapters Out (Persistence)**: Entidades JPA (`@Entity`), interfaces `JpaRepository`, mappers de persistencia y adaptadores de repositorio.
- **Config (BeansConfig)**: Clases `@Configuration` de Spring que registran Use Cases y Mappers sin contaminar el dominio con anotaciones del framework.

---

## Bounded Contexts (1 Tabla = 1 Modulo)

Cada tabla de la base de datos funciona como un Bounded Context independiente compuesto por sus propias tres capas (`domain`, `application`, `infrastructure`).

Principales dominios incluidos:
- **Geografico y Catalogos**: `Country`, `StateRegion`, `CityMunicipality`, `DocumentType`, `Gender`, `RelationshipType`.
- **Profesionales y Estudios**: `Professional`, `ProfessionalType`, `Study`, `ProfessionalStudy`.
- **Pacientes y Contactos**: `Patient`, `PatientAllergy`, `Contact`, `PhoneContact`, `EmailContact`, `PatientContact`.
- **Historias Clinicas y Consultas**: `ClinicalRecord`, `ClinicalRecordStatus`, `Encounter`, `EncounterType`, `EncounterModality`, `EncounterStatus`, `ClinicalNote`, `MentalStatusExam`, `RiskAssessment`, `RiskLevel`.
- **Tratamientos y Diagnosticos**: `TreatmentPlan`, `TreatmentGoal`, `TreatmentStatus`, `TreatmentGoalStatus`, `MedicationRoute`, `AssessmentType`, `ConsentType`, `DiagnosticSystem`.
- **Chat, Escalaciones e IA**: `ChatConversation`, `ChatParticipant`, `ChatMessage`, `ChatAiSettings`, `ChatAiRun`, `ChatAiRunMetric`, `ChatAiRunError`, `ChatEscalation`, `ChatEscalationAssignment`, `ChatEscalationStatusHistory`, `AiModel`, `ProviderModelAi`, `SenderType`, `MessageType`, `Priority`, `ConversationStatus`, `AiRunStatus`, `EscalationStatus`.
- **Empresas**: `Empresa`.

---

## Requisitos Previos

- **JDK 21** o superior instalado.
- **Docker Desktop** / **Docker Engine** en ejecucion.
- **Apache Maven 3.8+** (opcional si se utiliza el wrapper de Maven).

---

## Guia de Instalacion y Ejecucion

### 1. Clonar el Repositorio

```bash
git clone https://github.com/DMntill4/demo-ddd.git
cd demo-ddd
```

### 2. Iniciar Base de Datos PostgreSQL con Docker

Ejecutar el siguiente comando para levantar el contenedor de PostgreSQL con las credenciales necesarias:

```bash
docker-compose up -d
```

Verificar que el contenedor `mindconnect-db` se encuentre en ejecucion:

```bash
docker ps
```

### 3. Compilar y Ejecutar la Aplicacion

Para compilar todos los modulos y ejecutar la aplicacion Spring Boot en perfil de desarrollo (`dev`):

```bash
mvn clean spring-boot:run -Dspring-boot.run.profiles=dev
```

Durante el arranque, **Flyway** creara automaticamente el esquema `mindconnect_schema` y aplicara todas las migraciones SQL (`V1` a `V9`).

---

## Endpoints de la API REST

La aplicacion expone servicios RESTful organizados bajo la ruta base `/api/v1/`:

- `POST /api/v1/{recurso}`: Registrar un nuevo elemento.
- `GET /api/v1/{recurso}`: Listar todos los elementos.
- `GET /api/v1/{recurso}/{id}`: Consultar un elemento por UUID.
- `PUT /api/v1/{recurso}/{id}`: Actualizar un elemento existente.
- `DELETE /api/v1/{recurso}/{id}`: Eliminar un elemento por UUID.

---

## Licencia

Este proyecto esta bajo la licencia MIT.
