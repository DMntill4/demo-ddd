package com.backintro.infrastructure.riskassessment.adapters.in.rest.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

public record CreateRiskAssessmentRequest(UUID encounterId, UUID riskLevelId, boolean suicidalIdeation, boolean suicidePlan, boolean suicideIntent, boolean selfHarm, boolean harmToOthers, String protectiveFactors, String riskFactors, String clinicalActions, String observations, LocalDateTime assessedAt, UUID assessedBy) {
}
