package com.backintro.application.clinicalrecordstatus.usecase;

import com.backintro.application.clinicalrecordstatus.exception.ClinicalRecordStatusNotFoundApplicationException;
import com.backintro.domain.clinicalrecordstatus.model.aggregate.ClinicalRecordStatus;
import com.backintro.domain.clinicalrecordstatus.model.valueobject.ClinicalRecordStatusId;
import com.backintro.domain.clinicalrecordstatus.port.repository.ClinicalRecordStatusRepository;

public class DeleteClinicalRecordStatusUseCase {
    private final ClinicalRecordStatusRepository repository;

    public DeleteClinicalRecordStatusUseCase(ClinicalRecordStatusRepository repository) {
        this.repository = repository;
    }

    public void execute(ClinicalRecordStatusId id) {
        ClinicalRecordStatus aggregate = repository.findById(id)
                .orElseThrow(() -> new ClinicalRecordStatusNotFoundApplicationException(id));
        repository.delete(aggregate);
    }
}
