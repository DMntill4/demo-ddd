-- =====================================================================
-- V6 - Clinical Records & Encounters
-- Tables: clinical_records, encounters, clinical_notes,
--         mental_status_exams, risk_assessments
-- =====================================================================

-- -----------------------------------------------------------------------
-- 6.1 clinical_records
-- -----------------------------------------------------------------------
CREATE TABLE clinical_records (
    id            UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    patient_id    UUID        NOT NULL REFERENCES patients(id),
    creation_date TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,
    record_number VARCHAR(50) NOT NULL,
    opened_at     TIMESTAMP,
    closed_at     TIMESTAMP,
    status_id     UUID        NOT NULL REFERENCES clinical_record_statuses(id),
    created_at    TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by    UUID        REFERENCES professionals(id)
);

-- -----------------------------------------------------------------------
-- 6.2 encounters
-- -----------------------------------------------------------------------
CREATE TABLE encounters (
    id                 UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    clinical_record_id UUID      NOT NULL REFERENCES clinical_records(id),
    professional_id    UUID      NOT NULL REFERENCES professionals(id),
    encounter_type_id  UUID      NOT NULL REFERENCES encounter_types(id),
    started_at         TIMESTAMP NOT NULL,
    ended_at           TIMESTAMP,
    reason_for_visit   TEXT,
    current_condition  TEXT,
    modality_id        UUID      REFERENCES encounter_modalities(id),
    status_id          UUID      NOT NULL REFERENCES encounter_statusses(id),
    created_at         TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by         UUID      REFERENCES professionals(id),
    updated_at         TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_by         UUID      REFERENCES professionals(id)
);

-- -----------------------------------------------------------------------
-- 6.3 clinical_notes
-- -----------------------------------------------------------------------
CREATE TABLE clinical_notes (
    id               UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    encounter_id     UUID      NOT NULL REFERENCES encounters(id),
    professional_id  UUID      NOT NULL REFERENCES professionals(id),
    subjective       TEXT,
    objective        TEXT,
    assessment       TEXT,
    plan             TEXT,
    additional_notes TEXT,
    signed_at        TIMESTAMP,
    created_at       TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at       TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- -----------------------------------------------------------------------
-- 6.4 mental_status_exams
-- -----------------------------------------------------------------------
CREATE TABLE mental_status_exams (
    id                   UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    encounter_id         UUID      NOT NULL REFERENCES encounters(id),
    appearance           TEXT,
    behavior             TEXT,
    attitude             TEXT,
    consciousness        TEXT,
    orientation          TEXT,
    attention            TEXT,
    memory               TEXT,
    speech               TEXT,
    mood                 TEXT,
    affect               TEXT,
    thought_process      TEXT,
    thought_content      TEXT,
    perception           TEXT,
    judgment             TEXT,
    insight              TEXT,
    psychomotor_activity TEXT,
    observations         TEXT,
    created_at           TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by           UUID      REFERENCES professionals(id)
);

-- -----------------------------------------------------------------------
-- 6.5 risk_assessments
-- -----------------------------------------------------------------------
CREATE TABLE risk_assessments (
    id                UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    encounter_id      UUID      NOT NULL REFERENCES encounters(id),
    risk_level_id     UUID      NOT NULL REFERENCES risk_levels(id),
    suicidal_ideation BOOLEAN   NOT NULL DEFAULT FALSE,
    suicide_plan      BOOLEAN   NOT NULL DEFAULT FALSE,
    suicide_intent    BOOLEAN   NOT NULL DEFAULT FALSE,
    self_harm         BOOLEAN   NOT NULL DEFAULT FALSE,
    harm_to_others    BOOLEAN   NOT NULL DEFAULT FALSE,
    protective_factors TEXT,
    risk_factors      TEXT,
    clinical_actions  TEXT,
    observations      TEXT,
    assessed_at       TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    assessed_by       UUID      REFERENCES professionals(id)
);
