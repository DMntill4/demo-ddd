package com.backintro.application.treatmentgoalstatus.command;

import com.backintro.domain.treatmentgoalstatus.model.valueobject.TreatmentGoalStatusId;

public record UpdateTreatmentGoalStatusCommand(TreatmentGoalStatusId id, String name, String code) {
}
