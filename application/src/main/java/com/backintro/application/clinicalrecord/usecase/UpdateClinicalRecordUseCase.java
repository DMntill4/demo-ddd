package com.backintro.application.clinicalrecord.usecase;

import com.backintro.application.clinicalrecord.command.UpdateClinicalRecordCommand;
import com.backintro.application.clinicalrecord.dto.ClinicalRecordResponse;
import com.backintro.application.clinicalrecord.exception.ClinicalRecordNotFoundApplicationException;
import com.backintro.domain.clinicalrecord.model.aggregate.ClinicalRecord;
import com.backintro.domain.clinicalrecord.port.repository.ClinicalRecordRepository;

public class UpdateClinicalRecordUseCase {
    private final ClinicalRecordRepository repository;

    public UpdateClinicalRecordUseCase(ClinicalRecordRepository repository) {
        this.repository = repository;
    }

    public ClinicalRecordResponse execute(UpdateClinicalRecordCommand command) {
        ClinicalRecord aggregate = repository.findById(command.id())
                .orElseThrow(() -> new ClinicalRecordNotFoundApplicationException(command.id()));
        aggregate.update(command.patientId(), command.creationDate(), command.recordNumber(), command.openedAt(), command.closedAt(), command.statusId(), command.createdBy());
        ClinicalRecord saved = repository.save(aggregate);
        return ClinicalRecordResponse.fromDomain(saved);
    }
}
