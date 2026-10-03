package com.backintro.application.clinicalrecord.usecase;

import com.backintro.application.clinicalrecord.dto.ClinicalRecordResponse;
import com.backintro.application.clinicalrecord.exception.ClinicalRecordNotFoundApplicationException;
import com.backintro.domain.clinicalrecord.model.valueobject.ClinicalRecordId;
import com.backintro.domain.clinicalrecord.port.repository.ClinicalRecordRepository;

public class GetClinicalRecordByIdUseCase {
    private final ClinicalRecordRepository repository;

    public GetClinicalRecordByIdUseCase(ClinicalRecordRepository repository) {
        this.repository = repository;
    }

    public ClinicalRecordResponse execute(ClinicalRecordId id) {
        return repository.findById(id)
                .map(ClinicalRecordResponse::fromDomain)
                .orElseThrow(() -> new ClinicalRecordNotFoundApplicationException(id));
    }
}
