-- =====================================================================
-- V3 - Patients
-- Tables: patients, patient_allergies
-- =====================================================================

-- -----------------------------------------------------------------------
-- 3.1 patients
-- -----------------------------------------------------------------------
CREATE TABLE patients (
    id                UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    document_type_id  UUID         NOT NULL REFERENCES document_types(id),
    document_number   VARCHAR(30)  NOT NULL,
    first_name        VARCHAR(50)  NOT NULL,
    middle_name       VARCHAR(50),
    last_name         VARCHAR(50)  NOT NULL,
    second_last_name  VARCHAR(50),
    birth_date        DATE         NOT NULL,
    biological_sex_id UUID         REFERENCES genders(id),
    gender_identity   UUID         REFERENCES genders(id),
    email             VARCHAR(150) UNIQUE,
    phone             VARCHAR(30),
    address           VARCHAR(250),
    active            BOOLEAN      NOT NULL DEFAULT TRUE,
    created_at        TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by        UUID         REFERENCES professionals(id),
    updated_at        TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_by        UUID         REFERENCES professionals(id),
    city_id           UUID         REFERENCES city_municipalities(id),
    UNIQUE (document_type_id, document_number)
);

-- -----------------------------------------------------------------------
-- 3.2 patient_allergies
-- -----------------------------------------------------------------------
CREATE TABLE patient_allergies (
    id          UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    patient_id  UUID         NOT NULL REFERENCES patients(id),
    substance   VARCHAR(200) NOT NULL,
    reaction    TEXT,
    severity    VARCHAR(20),
    active      BOOLEAN      NOT NULL DEFAULT TRUE,
    recorded_at TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    recorded_by UUID         REFERENCES professionals(id),
    created_at  TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at  TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP
);
