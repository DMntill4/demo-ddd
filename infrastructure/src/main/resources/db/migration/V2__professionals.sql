-- =====================================================================
-- V2 - Professionals
-- Tables: professionals, professional_studies
-- =====================================================================

-- -----------------------------------------------------------------------
-- 2.1 professionals
-- -----------------------------------------------------------------------
CREATE TABLE professionals (
    id                   UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    document_type_id     UUID         NOT NULL REFERENCES document_types(id),
    document_number      VARCHAR(30)  NOT NULL UNIQUE,
    first_name           VARCHAR(60)  NOT NULL,
    last_name            VARCHAR(60)  NOT NULL,
    professional_type_id UUID         NOT NULL REFERENCES professional_types(id),
    license_number       VARCHAR(100) NOT NULL UNIQUE,
    active               BOOLEAN      NOT NULL DEFAULT TRUE,
    city_id              UUID         REFERENCES city_municipalities(id),
    created_at           TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at           TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- -----------------------------------------------------------------------
-- 2.2 professional_studies
-- -----------------------------------------------------------------------
CREATE TABLE professional_studies (
    id                UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    study_id          UUID         NOT NULL REFERENCES studies(id),
    professional_id   UUID         NOT NULL REFERENCES professionals(id),
    title             VARCHAR(100) NOT NULL,
    university        VARCHAR(100) NOT NULL,
    is_valid          BOOLEAN      NOT NULL DEFAULT TRUE,
    resolution_number VARCHAR(60),
    country_id        UUID         REFERENCES countries(id),
    created_at        TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at        TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP
);
