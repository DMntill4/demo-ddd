-- =====================================================================
-- V10 - Security: Users, Roles, Permissions & User Credentials
-- Schema: mindconnect_schema
-- Tables: roles, permissions, role_permissions, users, user_roles
-- =====================================================================

-- -----------------------------------------------------------------------
-- 10.1 roles
-- -----------------------------------------------------------------------
CREATE TABLE roles (
    id          UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name        VARCHAR(50)  NOT NULL UNIQUE,
    description VARCHAR(255),
    created_at  TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- -----------------------------------------------------------------------
-- 10.2 permissions
-- -----------------------------------------------------------------------
CREATE TABLE permissions (
    id          UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name        VARCHAR(100) NOT NULL UNIQUE,
    description VARCHAR(255),
    created_at  TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- -----------------------------------------------------------------------
-- 10.3 role_permissions
-- -----------------------------------------------------------------------
CREATE TABLE role_permissions (
    role_id       UUID NOT NULL REFERENCES roles(id) ON DELETE CASCADE,
    permission_id UUID NOT NULL REFERENCES permissions(id) ON DELETE CASCADE,
    PRIMARY KEY (role_id, permission_id)
);

-- -----------------------------------------------------------------------
-- 10.4 users
-- -----------------------------------------------------------------------
CREATE TABLE users (
    id                    UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    email                 VARCHAR(150) NOT NULL UNIQUE,
    password_hash         VARCHAR(255) NOT NULL,
    active                BOOLEAN      NOT NULL DEFAULT TRUE,
    locked                BOOLEAN      NOT NULL DEFAULT FALSE,
    failed_attempts       INT          NOT NULL DEFAULT 0,
    professional_id       UUID         REFERENCES professionals(id) ON DELETE SET NULL,
    patient_id            UUID         REFERENCES patients(id) ON DELETE SET NULL,
    created_at            TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at            TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- -----------------------------------------------------------------------
-- 10.5 user_roles
-- -----------------------------------------------------------------------
CREATE TABLE user_roles (
    user_id UUID NOT NULL REFERENCES users(id) ON DELETE CASCADE,
    role_id UUID NOT NULL REFERENCES roles(id) ON DELETE CASCADE,
    PRIMARY KEY (user_id, role_id)
);

-- -----------------------------------------------------------------------
-- Indexes
-- -----------------------------------------------------------------------
CREATE INDEX idx_users_email ON users(email);
CREATE INDEX idx_users_professional_id ON users(professional_id);
CREATE INDEX idx_users_patient_id ON users(patient_id);
CREATE INDEX idx_user_roles_user_id ON user_roles(user_id);
CREATE INDEX idx_user_roles_role_id ON user_roles(role_id);

-- -----------------------------------------------------------------------
-- Seed Initial Roles and Permissions
-- -----------------------------------------------------------------------
INSERT INTO roles (name, description) VALUES
    ('ROLE_ADMIN', 'System Administrator with full access'),
    ('ROLE_PROFESSIONAL', 'Healthcare Professional/Clinician'),
    ('ROLE_PATIENT', 'Patient receiving treatment');

INSERT INTO permissions (name, description) VALUES
    ('CLINICAL_NOTE_READ', 'Permission to read clinical notes'),
    ('CLINICAL_NOTE_WRITE', 'Permission to create and update clinical notes'),
    ('PATIENT_READ', 'Permission to read patient records'),
    ('CHAT_READ', 'Permission to participate in and read chats'),
    ('CHAT_WRITE', 'Permission to send chat messages');

-- Grant permissions to ROLE_ADMIN
INSERT INTO role_permissions (role_id, permission_id)
SELECT r.id, p.id FROM roles r, permissions p WHERE r.name = 'ROLE_ADMIN';

-- Grant permissions to ROLE_PROFESSIONAL
INSERT INTO role_permissions (role_id, permission_id)
SELECT r.id, p.id FROM roles r, permissions p 
WHERE r.name = 'ROLE_PROFESSIONAL' AND p.name IN ('CLINICAL_NOTE_READ', 'CLINICAL_NOTE_WRITE', 'PATIENT_READ', 'CHAT_READ', 'CHAT_WRITE');

-- Grant permissions to ROLE_PATIENT
INSERT INTO role_permissions (role_id, permission_id)
SELECT r.id, p.id FROM roles r, permissions p 
WHERE r.name = 'ROLE_PATIENT' AND p.name IN ('CHAT_READ', 'CHAT_WRITE');
