-- =====================================================================
-- V4 - Contacts
-- Tables: contacts, phone_contacts, email_contacts, patient_contacts
-- =====================================================================

-- -----------------------------------------------------------------------
-- 4.1 contacts
-- -----------------------------------------------------------------------
CREATE TABLE contacts (
    id         UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    full_name  VARCHAR(200) NOT NULL,
    email      VARCHAR(150),
    notes      TEXT,
    city_id    UUID         REFERENCES city_municipalities(id),
    created_at TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by UUID         REFERENCES professionals(id),
    updated_at TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_by UUID         REFERENCES professionals(id)
);

-- -----------------------------------------------------------------------
-- 4.2 phone_contacts
-- -----------------------------------------------------------------------
CREATE TABLE phone_contacts (
    id         UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    contact_id UUID        NOT NULL REFERENCES contacts(id),
    phone      VARCHAR(30) NOT NULL,
    notes      TEXT
);

-- -----------------------------------------------------------------------
-- 4.3 email_contacts
-- -----------------------------------------------------------------------
CREATE TABLE email_contacts (
    id         UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    contact_id UUID         NOT NULL REFERENCES contacts(id),
    email      VARCHAR(150) NOT NULL,
    notes      TEXT,
    created_at TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- -----------------------------------------------------------------------
-- 4.4 patient_contacts
-- -----------------------------------------------------------------------
CREATE TABLE patient_contacts (
    id                   UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    contact_id           UUID    NOT NULL REFERENCES contacts(id),
    patient_id           UUID    NOT NULL REFERENCES patients(id),
    is_primary_contact   BOOLEAN NOT NULL DEFAULT FALSE,
    is_emergency_contact BOOLEAN NOT NULL DEFAULT FALSE,
    relationship_type_id UUID    REFERENCES relationship_types(id)
);
