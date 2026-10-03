package com.backintro.infrastructure.riskassessment.adapters.out.persistence.entity;

import java.time.LocalDateTime;
import java.util.UUID;
import jakarta.persistence.*;

@Entity
@Table(name = "risk_assessments")
public class RiskAssessmentJpaEntity {
    @Id
    private UUID id;

    @Column(name = "encounter_id", nullable = false)
    private UUID encounterId;

    @Column(name = "risk_level_id", nullable = false)
    private UUID riskLevelId;

    @Column(name = "suicidal_ideation", nullable = false)
    private boolean suicidalIdeation;

    @Column(name = "suicide_plan", nullable = false)
    private boolean suicidePlan;

    @Column(name = "suicide_intent", nullable = false)
    private boolean suicideIntent;

    @Column(name = "self_harm", nullable = false)
    private boolean selfHarm;

    @Column(name = "harm_to_others", nullable = false)
    private boolean harmToOthers;

    @Column(name = "protective_factors")
    private String protectiveFactors;

    @Column(name = "risk_factors")
    private String riskFactors;

    @Column(name = "clinical_actions")
    private String clinicalActions;

    @Column(name = "observations")
    private String observations;

    @Column(name = "assessed_at", nullable = false)
    private LocalDateTime assessedAt;

    @Column(name = "assessed_by")
    private UUID assessedBy;

    public RiskAssessmentJpaEntity() {
    }

    public RiskAssessmentJpaEntity(UUID id, UUID encounterId, UUID riskLevelId, boolean suicidalIdeation, boolean suicidePlan, boolean suicideIntent, boolean selfHarm, boolean harmToOthers, String protectiveFactors, String riskFactors, String clinicalActions, String observations, LocalDateTime assessedAt, UUID assessedBy) {
        this.id = id;
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

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public UUID getEncounterId() { return encounterId; }
    public void setEncounterId(UUID encounterId) { this.encounterId = encounterId; }

    public UUID getRiskLevelId() { return riskLevelId; }
    public void setRiskLevelId(UUID riskLevelId) { this.riskLevelId = riskLevelId; }

    public boolean getSuicidalIdeation() { return suicidalIdeation; }
    public void setSuicidalIdeation(boolean suicidalIdeation) { this.suicidalIdeation = suicidalIdeation; }

    public boolean getSuicidePlan() { return suicidePlan; }
    public void setSuicidePlan(boolean suicidePlan) { this.suicidePlan = suicidePlan; }

    public boolean getSuicideIntent() { return suicideIntent; }
    public void setSuicideIntent(boolean suicideIntent) { this.suicideIntent = suicideIntent; }

    public boolean getSelfHarm() { return selfHarm; }
    public void setSelfHarm(boolean selfHarm) { this.selfHarm = selfHarm; }

    public boolean getHarmToOthers() { return harmToOthers; }
    public void setHarmToOthers(boolean harmToOthers) { this.harmToOthers = harmToOthers; }

    public String getProtectiveFactors() { return protectiveFactors; }
    public void setProtectiveFactors(String protectiveFactors) { this.protectiveFactors = protectiveFactors; }

    public String getRiskFactors() { return riskFactors; }
    public void setRiskFactors(String riskFactors) { this.riskFactors = riskFactors; }

    public String getClinicalActions() { return clinicalActions; }
    public void setClinicalActions(String clinicalActions) { this.clinicalActions = clinicalActions; }

    public String getObservations() { return observations; }
    public void setObservations(String observations) { this.observations = observations; }

    public LocalDateTime getAssessedAt() { return assessedAt; }
    public void setAssessedAt(LocalDateTime assessedAt) { this.assessedAt = assessedAt; }

    public UUID getAssessedBy() { return assessedBy; }
    public void setAssessedBy(UUID assessedBy) { this.assessedBy = assessedBy; }
}
