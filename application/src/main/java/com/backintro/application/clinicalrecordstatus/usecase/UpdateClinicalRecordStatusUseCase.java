package com.backintro.application.clinicalrecordstatus.usecase;

import com.backintro.application.clinicalrecordstatus.command.UpdateClinicalRecordStatusCommand;
import com.backintro.application.clinicalrecordstatus.dto.ClinicalRecordStatusResponse;
import com.backintro.application.clinicalrecordstatus.exception.ClinicalRecordStatusNotFoundApplicationException;
import com.backintro.domain.clinicalrecordstatus.model.aggregate.ClinicalRecordStatus;
import com.backintro.domain.clinicalrecordstatus.port.repository.ClinicalRecordStatusRepository;

public class UpdateClinicalRecordStatusUseCase {
    private final ClinicalRecordStatusRepository repository;

    public UpdateClinicalRecordStatusUseCase(ClinicalRecordStatusRepository repository) {
        this.repository = repository;
    }

    public ClinicalRecordStatusResponse execute(UpdateClinicalRecordStatusCommand command) {
        ClinicalRecordStatus aggregate = repository.findById(command.id())
                .orElseThrow(() -> new ClinicalRecordStatusNotFoundApplicationException(command.id()));
        aggregate.update(command.code(), command.name());
        ClinicalRecordStatus saved = repository.save(aggregate);
        return ClinicalRecordStatusResponse.fromDomain(saved);
    }
}
