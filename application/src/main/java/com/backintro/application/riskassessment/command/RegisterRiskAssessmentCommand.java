package com.backintro.application.riskassessment.command;

import java.time.LocalDateTime;
import java.util.UUID;

public record RegisterRiskAssessmentCommand(UUID encounterId, UUID riskLevelId, boolean suicidalIdeation, boolean suicidePlan, boolean suicideIntent, boolean selfHarm, boolean harmToOthers, String protectiveFactors, String riskFactors, String clinicalActions, String observations, LocalDateTime assessedAt, UUID assessedBy) {
}
