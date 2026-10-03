package com.backintro.application.riskassessment.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import com.backintro.domain.riskassessment.model.aggregate.RiskAssessment;

public record RiskAssessmentResponse(UUID id, UUID encounterId, UUID riskLevelId, boolean suicidalIdeation, boolean suicidePlan, boolean suicideIntent, boolean selfHarm, boolean harmToOthers, String protectiveFactors, String riskFactors, String clinicalActions, String observations, LocalDateTime assessedAt, UUID assessedBy) {
    public static RiskAssessmentResponse fromDomain(RiskAssessment aggregate) {
        return new RiskAssessmentResponse(aggregate.id().value(), aggregate.encounterId(), aggregate.riskLevelId(), aggregate.suicidalIdeation(), aggregate.suicidePlan(), aggregate.suicideIntent(), aggregate.selfHarm(), aggregate.harmToOthers(), aggregate.protectiveFactors(), aggregate.riskFactors(), aggregate.clinicalActions(), aggregate.observations(), aggregate.assessedAt(), aggregate.assessedBy());
    }
}
