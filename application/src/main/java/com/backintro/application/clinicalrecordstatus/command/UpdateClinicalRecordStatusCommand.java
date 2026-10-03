package com.backintro.application.clinicalrecordstatus.command;

import com.backintro.domain.clinicalrecordstatus.model.valueobject.ClinicalRecordStatusId;

public record UpdateClinicalRecordStatusCommand(ClinicalRecordStatusId id, String code, String name) {
}
