-- =====================================================================
-- V8 - Chat: Catalogs & AI Providers
-- Tables: sender_types, message_types, priorities,
--         conversations_statuses, ai_runs_statuses, escalations_statuses,
--         provider_models_ai, ai_models
-- =====================================================================

-- -----------------------------------------------------------------------
-- 8.1 sender_types
-- -----------------------------------------------------------------------
CREATE TABLE sender_types (
    id         UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name_type  VARCHAR(50) NOT NULL,
    created_at TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- -----------------------------------------------------------------------
-- 8.2 message_types
-- -----------------------------------------------------------------------
CREATE TABLE message_types (
    id         UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name_type  VARCHAR(50) NOT NULL,
    created_at TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- -----------------------------------------------------------------------
-- 8.3 priorities
-- -----------------------------------------------------------------------
CREATE TABLE priorities (
    id            UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name_priority VARCHAR(50) NOT NULL,
    created_at    TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at    TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- -----------------------------------------------------------------------
-- 8.4 conversations_statuses
-- -----------------------------------------------------------------------
CREATE TABLE conversations_statuses (
    id          UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name_status VARCHAR(50) NOT NULL,
    created_at  TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at  TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- -----------------------------------------------------------------------
-- 8.5 ai_runs_statuses
-- -----------------------------------------------------------------------
CREATE TABLE ai_runs_statuses (
    id          UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name_status VARCHAR(50) NOT NULL,
    created_at  TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at  TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- -----------------------------------------------------------------------
-- 8.6 escalations_statuses
-- -----------------------------------------------------------------------
CREATE TABLE escalations_statuses (
    id          UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name_status VARCHAR(50) NOT NULL,
    created_at  TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at  TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- -----------------------------------------------------------------------
-- 8.7 provider_models_ai
-- -----------------------------------------------------------------------
CREATE TABLE provider_models_ai (
    id               UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name_provider_ai VARCHAR(100) NOT NULL,
    razon_social     VARCHAR(150),
    sitio_web        TEXT,
    is_active        BOOLEAN      NOT NULL DEFAULT TRUE,
    created_at       TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at       TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- -----------------------------------------------------------------------
-- 8.8 ai_models
-- -----------------------------------------------------------------------
CREATE TABLE ai_models (
    id                 UUID           PRIMARY KEY DEFAULT gen_random_uuid(),
    provider_model_id  UUID           NOT NULL REFERENCES provider_models_ai(id),
    name_model         VARCHAR(100)   NOT NULL,
    model_key          VARCHAR(120)   NOT NULL,
    input_token_price  DECIMAL(12,8),
    output_token_price DECIMAL(12,8),
    max_tokens         INTEGER,
    context_window     INTEGER,
    is_active          BOOLEAN        NOT NULL DEFAULT TRUE,
    created_at         TIMESTAMP      NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at         TIMESTAMP      NOT NULL DEFAULT CURRENT_TIMESTAMP
);
