package com.backintro.domain.riskassessment.model.aggregate;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.Objects;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.riskassessment.event.RiskAssessmentRegisteredEvent;
import com.backintro.domain.riskassessment.event.RiskAssessmentUpdatedEvent;
import com.backintro.domain.riskassessment.model.valueobject.RiskAssessmentId;

public class RiskAssessment extends AggregateRoot {
    private final RiskAssessmentId id;
    private UUID encounterId;
    private UUID riskLevelId;
    private boolean suicidalIdeation;
    private boolean suicidePlan;
    private boolean suicideIntent;
    private boolean selfHarm;
    private boolean harmToOthers;
    private String protectiveFactors;
    private String riskFactors;
    private String clinicalActions;
    private String observations;
    private LocalDateTime assessedAt;
    private UUID assessedBy;

    private RiskAssessment(
            RiskAssessmentId id, UUID encounterId, UUID riskLevelId, boolean suicidalIdeation, boolean suicidePlan, boolean suicideIntent, boolean selfHarm, boolean harmToOthers, String protectiveFactors, String riskFactors, String clinicalActions, String observations, LocalDateTime assessedAt, UUID assessedBy) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.encounterId = encounterId;
        this.riskLevelId = riskLevelId;
        this.suicidalIdeation = suicidalIdeation;
        this.suicidePlan = suicidePlan;
        this.suicideIntent = suicideIntent;
        this.selfHarm = selfHarm;
        this.harmToOthers = harmToOthers;
        this.protectiveFactors = protectiveFactors;
        this.riskFactors = riskFactors;
        this.clinicalActions = clinicalActions;
        this.observations = observations;
        this.assessedAt = assessedAt;
        this.assessedBy = assessedBy;
    }

    public static RiskAssessment register(UUID encounterId, UUID riskLevelId, boolean suicidalIdeation, boolean suicidePlan, boolean suicideIntent, boolean selfHarm, boolean harmToOthers, String protectiveFactors, String riskFactors, String clinicalActions, String observations, LocalDateTime assessedAt, UUID assessedBy) {
        RiskAssessmentId id = RiskAssessmentId.generate();
        LocalDateTime now = LocalDateTime.now();
        RiskAssessment aggregate = new RiskAssessment(id, encounterId, riskLevelId, suicidalIdeation, suicidePlan, suicideIntent, selfHarm, harmToOthers, protectiveFactors, riskFactors, clinicalActions, observations, assessedAt, assessedBy);
        aggregate.recordEvent(new RiskAssessmentRegisteredEvent(id, now));
        return aggregate;
    }

    public static RiskAssessment restore(
            RiskAssessmentId id, UUID encounterId, UUID riskLevelId, boolean suicidalIdeation, boolean suicidePlan, boolean suicideIntent, boolean selfHarm, boolean harmToOthers, String protectiveFactors, String riskFactors, String clinicalActions, String observations, LocalDateTime assessedAt, UUID assessedBy) {
        return new RiskAssessment(id, encounterId, riskLevelId, suicidalIdeation, suicidePlan, suicideIntent, selfHarm, harmToOthers, protectiveFactors, riskFactors, clinicalActions, observations, assessedAt, assessedBy);
    }

    public void update(UUID encounterId, UUID riskLevelId, boolean suicidalIdeation, boolean suicidePlan, boolean suicideIntent, boolean selfHarm, boolean harmToOthers, String protectiveFactors, String riskFactors, String clinicalActions, String observations, LocalDateTime assessedAt, UUID assessedBy) {
        this.encounterId = encounterId;
        this.riskLevelId = riskLevelId;
        this.suicidalIdeation = suicidalIdeation;
        this.suicidePlan = suicidePlan;
        this.suicideIntent = suicideIntent;
        this.selfHarm = selfHarm;
        this.harmToOthers = harmToOthers;
        this.protectiveFactors = protectiveFactors;
        this.riskFactors = riskFactors;
        this.clinicalActions = clinicalActions;
        this.observations = observations;
        this.assessedAt = assessedAt;
        this.assessedBy = assessedBy;
        recordEvent(new RiskAssessmentUpdatedEvent(this.id, LocalDateTime.now()));
    }

    public RiskAssessmentId id() { return id; }
    public UUID encounterId() { return encounterId; }
    public UUID riskLevelId() { return riskLevelId; }
    public boolean suicidalIdeation() { return suicidalIdeation; }
    public boolean suicidePlan() { return suicidePlan; }
    public boolean suicideIntent() { return suicideIntent; }
    public boolean selfHarm() { return selfHarm; }
    public boolean harmToOthers() { return harmToOthers; }
    public String protectiveFactors() { return protectiveFactors; }
    public String riskFactors() { return riskFactors; }
    public String clinicalActions() { return clinicalActions; }
    public String observations() { return observations; }
    public LocalDateTime assessedAt() { return assessedAt; }
    public UUID assessedBy() { return assessedBy; }
}
