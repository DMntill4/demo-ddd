package com.backintro.application.clinicalrecord.usecase;

import com.backintro.application.clinicalrecord.exception.ClinicalRecordNotFoundApplicationException;
import com.backintro.domain.clinicalrecord.model.aggregate.ClinicalRecord;
import com.backintro.domain.clinicalrecord.model.valueobject.ClinicalRecordId;
import com.backintro.domain.clinicalrecord.port.repository.ClinicalRecordRepository;

public class DeleteClinicalRecordUseCase {
    private final ClinicalRecordRepository repository;

    public DeleteClinicalRecordUseCase(ClinicalRecordRepository repository) {
        this.repository = repository;
    }

    public void execute(ClinicalRecordId id) {
        ClinicalRecord aggregate = repository.findById(id)
                .orElseThrow(() -> new ClinicalRecordNotFoundApplicationException(id));
        repository.delete(aggregate);
    }
}
