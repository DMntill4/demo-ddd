package com.backintro.application.treatmentstatuss.command;

import com.backintro.domain.treatmentstatuss.model.valueobject.TreatmentStatusId;

public record UpdateTreatmentStatusCommand(TreatmentStatusId id, String code, String name) {
}
