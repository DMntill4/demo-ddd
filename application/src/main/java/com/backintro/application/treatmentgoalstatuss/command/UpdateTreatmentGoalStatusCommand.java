package com.backintro.application.treatmentgoalstatuss.command;

import com.backintro.domain.treatmentgoalstatuss.model.valueobject.TreatmentGoalStatusId;

public record UpdateTreatmentGoalStatusCommand(TreatmentGoalStatusId id, String code, String name) {
}
