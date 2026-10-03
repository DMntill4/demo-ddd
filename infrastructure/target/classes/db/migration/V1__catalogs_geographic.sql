-- =====================================================================
-- V1 - Geographic Catalogs & General Catalogs
-- Tables: countries, state_regions, city_municipalities,
--         document_types, genders, relationship_types,
--         professional_types, studies
-- =====================================================================

CREATE EXTENSION IF NOT EXISTS "pgcrypto";

-- -----------------------------------------------------------------------
-- 1.1 countries
-- -----------------------------------------------------------------------
CREATE TABLE countries (
    id               UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name_country     VARCHAR(50)  NOT NULL,
    code_country     VARCHAR(10)  NOT NULL,
    description      VARCHAR(100),
    is_active        BOOLEAN      NOT NULL DEFAULT TRUE,
    telephone_prefix VARCHAR(5),
    created_at       TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at       TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- -----------------------------------------------------------------------
-- 1.2 state_regions
-- -----------------------------------------------------------------------
CREATE TABLE state_regions (
    id          UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name_region VARCHAR(50)  NOT NULL,
    code_region VARCHAR(10)  NOT NULL,
    description VARCHAR(100),
    is_active   BOOLEAN      NOT NULL DEFAULT TRUE,
    country_id  UUID         NOT NULL REFERENCES countries(id),
    created_at  TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at  TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- -----------------------------------------------------------------------
-- 1.3 city_municipalities
-- -----------------------------------------------------------------------
CREATE TABLE city_municipalities (
    id          UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name_city   VARCHAR(50)  NOT NULL,
    code_citi   VARCHAR(10)  NOT NULL,
    description VARCHAR(100),
    is_active   BOOLEAN      NOT NULL DEFAULT TRUE,
    region_id   UUID         NOT NULL REFERENCES state_regions(id),
    created_at  TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at  TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- -----------------------------------------------------------------------
-- 1.4 document_types
-- -----------------------------------------------------------------------
CREATE TABLE document_types (
    id         UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    code       VARCHAR(20) NOT NULL UNIQUE,
    name       VARCHAR(50) NOT NULL,
    active     BOOLEAN     NOT NULL DEFAULT TRUE,
    created_at TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- -----------------------------------------------------------------------
-- 1.5 genders
-- -----------------------------------------------------------------------
CREATE TABLE genders (
    id          UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    description VARCHAR(50) NOT NULL UNIQUE,
    created_at  TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at  TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- -----------------------------------------------------------------------
-- 1.6 relationship_types
-- -----------------------------------------------------------------------
CREATE TABLE relationship_types (
    id          UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    description VARCHAR(50) NOT NULL UNIQUE
);

-- -----------------------------------------------------------------------
-- 1.7 professional_types
-- -----------------------------------------------------------------------
CREATE TABLE professional_types (
    id         UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name       VARCHAR(40) NOT NULL UNIQUE,
    created_at TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- -----------------------------------------------------------------------
-- 1.8 studies
-- -----------------------------------------------------------------------
CREATE TABLE studies (
    id         UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name       VARCHAR(40) NOT NULL,
    created_at TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP
);
