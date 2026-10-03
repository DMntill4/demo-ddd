package com.backintro.application.patient.usecase;

import com.backintro.application.patient.dto.PatientResponse;
import com.backintro.application.patient.exception.PatientNotFoundApplicationException;
import com.backintro.domain.patient.model.valueobject.PatientId;
import com.backintro.domain.patient.port.repository.PatientRepository;

public class GetPatientByIdUseCase {
    private final PatientRepository repository;

    public GetPatientByIdUseCase(PatientRepository repository) {
        this.repository = repository;
    }

    public PatientResponse execute(PatientId id) {
        return repository.findById(id)
                .map(PatientResponse::fromDomain)
                .orElseThrow(() -> new PatientNotFoundApplicationException(id));
    }
}
