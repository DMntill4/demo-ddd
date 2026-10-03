-- =====================================================================
-- V7 - Treatment Plans
-- Tables: treatment_plans, treatment_goals
-- =====================================================================

-- -----------------------------------------------------------------------
-- 7.1 treatment_plans
-- -----------------------------------------------------------------------
CREATE TABLE treatment_plans (
    id                  UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    encounter_id        UUID         NOT NULL REFERENCES encounters(id),
    professional_id     UUID         NOT NULL REFERENCES professionals(id),
    title               VARCHAR(200) NOT NULL,
    description         TEXT,
    start_date          DATE,
    end_date            DATE,
    treatment_status_id UUID         NOT NULL REFERENCES treatment_statusses(id),
    created_at          TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at          TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- -----------------------------------------------------------------------
-- 7.2 treatment_goals
-- -----------------------------------------------------------------------
CREATE TABLE treatment_goals (
    id                       UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    treatment_plan_id        UUID      NOT NULL REFERENCES treatment_plans(id),
    description              TEXT      NOT NULL,
    target_date              DATE,
    completed_at             TIMESTAMP,
    notes                    TEXT,
    treatment_goal_status_id UUID      NOT NULL REFERENCES treatment_goal_statusses(id),
    created_at               TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at               TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
