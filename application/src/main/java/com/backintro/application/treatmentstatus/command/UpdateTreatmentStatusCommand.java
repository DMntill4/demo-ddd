package com.backintro.application.treatmentstatus.command;

import com.backintro.domain.treatmentstatus.model.valueobject.TreatmentStatusId;

public record UpdateTreatmentStatusCommand(TreatmentStatusId id, String name, String code) {
}
