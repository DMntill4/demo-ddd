package com.backintro.application.clinicalrecord.usecase;

import com.backintro.application.clinicalrecord.command.RegisterClinicalRecordCommand;
import com.backintro.application.clinicalrecord.dto.ClinicalRecordResponse;
import com.backintro.domain.clinicalrecord.model.aggregate.ClinicalRecord;
import com.backintro.domain.clinicalrecord.port.repository.ClinicalRecordRepository;

public class RegisterClinicalRecordUseCase {
    private final ClinicalRecordRepository repository;

    public RegisterClinicalRecordUseCase(ClinicalRecordRepository repository) {
        this.repository = repository;
    }

    public ClinicalRecordResponse execute(RegisterClinicalRecordCommand command) {
        ClinicalRecord aggregate = ClinicalRecord.register(command.patientId(), command.creationDate(), command.recordNumber(), command.openedAt(), command.closedAt(), command.statusId(), command.createdBy());
        ClinicalRecord saved = repository.save(aggregate);
        return ClinicalRecordResponse.fromDomain(saved);
    }
}
