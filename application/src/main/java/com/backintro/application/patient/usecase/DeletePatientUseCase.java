package com.backintro.application.patient.usecase;

import com.backintro.application.patient.exception.PatientNotFoundApplicationException;
import com.backintro.domain.patient.model.aggregate.Patient;
import com.backintro.domain.patient.model.valueobject.PatientId;
import com.backintro.domain.patient.port.repository.PatientRepository;

public class DeletePatientUseCase {
    private final PatientRepository repository;

    public DeletePatientUseCase(PatientRepository repository) {
        this.repository = repository;
    }

    public void execute(PatientId id) {
        Patient aggregate = repository.findById(id)
                .orElseThrow(() -> new PatientNotFoundApplicationException(id));
        repository.delete(aggregate);
    }
}
