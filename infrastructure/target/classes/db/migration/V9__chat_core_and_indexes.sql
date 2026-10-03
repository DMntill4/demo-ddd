-- =====================================================================
-- V9 - Chat: Core Tables, Escalations & Indexes
-- Tables: chat_conversations, chat_participants, chat_messages,
--         chat_conversation_ai_settings, chat_ai_runs,
--         chat_ai_run_metrics, chat_ai_run_errors,
--         chat_escalations, chat_escalation_assignments,
--         chat_escalation_status_history
-- Indexes: all FK-based indexes
-- =====================================================================

-- -----------------------------------------------------------------------
-- 9.1 chat_conversations
-- -----------------------------------------------------------------------
CREATE TABLE chat_conversations (
    id                     UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    conversation_status_id UUID      NOT NULL REFERENCES conversations_statuses(id),
    priority_id            UUID      REFERENCES priorities(id),
    last_message_at        TIMESTAMP,
    closed                 BOOLEAN   NOT NULL DEFAULT FALSE,
    closed_at              TIMESTAMP,
    closed_by              UUID,
    created_at             TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at             TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- -----------------------------------------------------------------------
-- 9.2 chat_participants
-- -----------------------------------------------------------------------
CREATE TABLE chat_participants (
    id                  UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    conversation_id     UUID      NOT NULL REFERENCES chat_conversations(id),
    participant_type_id UUID      NOT NULL REFERENCES sender_types(id),
    patient_id          UUID      REFERENCES patients(id),
    professional_id     UUID      REFERENCES professionals(id),
    created_at          TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at          TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- -----------------------------------------------------------------------
-- 9.3 chat_messages
-- -----------------------------------------------------------------------
CREATE TABLE chat_messages (
    id              UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    conversation_id UUID      NOT NULL REFERENCES chat_conversations(id),
    message_type_id UUID      NOT NULL REFERENCES message_types(id),
    participant_id  UUID      NOT NULL REFERENCES chat_participants(id),
    content         JSONB     NOT NULL,
    metadata        JSONB,
    created_at      TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- -----------------------------------------------------------------------
-- 9.4 chat_conversation_ai_settings
-- -----------------------------------------------------------------------
CREATE TABLE chat_conversation_ai_settings (
    id               UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    conversation_id  UUID      NOT NULL REFERENCES chat_conversations(id),
    ai_enabled       BOOLEAN   NOT NULL DEFAULT TRUE,
    default_model_id UUID      REFERENCES ai_models(id),
    created_at       TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at       TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- -----------------------------------------------------------------------
-- 9.5 chat_ai_runs
-- -----------------------------------------------------------------------
CREATE TABLE chat_ai_runs (
    id               UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    conversation_id  UUID      NOT NULL REFERENCES chat_conversations(id),
    message_id       UUID      REFERENCES chat_messages(id),
    model_id         UUID      NOT NULL REFERENCES ai_models(id),
    ai_run_status_id UUID      NOT NULL REFERENCES ai_runs_statuses(id),
    created_at       TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at       TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- -----------------------------------------------------------------------
-- 9.6 chat_ai_run_metrics
-- -----------------------------------------------------------------------
CREATE TABLE chat_ai_run_metrics (
    id                UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    ai_run_id         UUID          NOT NULL REFERENCES chat_ai_runs(id),
    prompt_tokens     INTEGER,
    completion_tokens INTEGER,
    total_tokens      INTEGER,
    cost              DECIMAL(10,6),
    created_at        TIMESTAMP     NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- -----------------------------------------------------------------------
-- 9.7 chat_ai_run_errors
-- -----------------------------------------------------------------------
CREATE TABLE chat_ai_run_errors (
    id                UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    ai_run_id         UUID         NOT NULL REFERENCES chat_ai_runs(id),
    error_message     TEXT,
    error_code        VARCHAR(80),
    provider_error_id VARCHAR(120),
    created_at        TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- -----------------------------------------------------------------------
-- 9.8 chat_escalations
-- -----------------------------------------------------------------------
CREATE TABLE chat_escalations (
    id              UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    conversation_id UUID      NOT NULL REFERENCES chat_conversations(id),
    status_id       UUID      NOT NULL REFERENCES escalations_statuses(id),
    from_ai         BOOLEAN   NOT NULL DEFAULT FALSE,
    reason          TEXT,
    created_at      TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- -----------------------------------------------------------------------
-- 9.9 chat_escalation_assignments
-- -----------------------------------------------------------------------
CREATE TABLE chat_escalation_assignments (
    id              UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    escalation_id   UUID      NOT NULL REFERENCES chat_escalations(id),
    professional_id UUID      NOT NULL REFERENCES professionals(id),
    assigned_at     TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- -----------------------------------------------------------------------
-- 9.10 chat_escalation_status_history
-- -----------------------------------------------------------------------
CREATE TABLE chat_escalation_status_history (
    id                   UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    escalation_id        UUID      NOT NULL REFERENCES chat_escalations(id),
    escalation_status_id UUID      NOT NULL REFERENCES escalations_statuses(id),
    created_at           TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    changed_at           TIMESTAMP
);

-- =====================================================================
-- INDEXES ON MOST QUERIED FOREIGN KEYS
-- =====================================================================

CREATE INDEX idx_patients_city              ON patients(city_id);
CREATE INDEX idx_clinical_records_patient   ON clinical_records(patient_id);
CREATE INDEX idx_encounters_record          ON encounters(clinical_record_id);
CREATE INDEX idx_encounters_professional    ON encounters(professional_id);
CREATE INDEX idx_clinical_notes_encounter   ON clinical_notes(encounter_id);
CREATE INDEX idx_risk_assess_encounter      ON risk_assessments(encounter_id);
CREATE INDEX idx_treatment_plans_encounter  ON treatment_plans(encounter_id);
CREATE INDEX idx_chat_messages_conversation ON chat_messages(conversation_id);
CREATE INDEX idx_chat_participants_conv     ON chat_participants(conversation_id);
CREATE INDEX idx_chat_ai_runs_conversation  ON chat_ai_runs(conversation_id);
