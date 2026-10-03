package com.backintro.application.patientallergy.usecase;

import com.backintro.application.patientallergy.exception.PatientAllergyNotFoundApplicationException;
import com.backintro.domain.patientallergy.model.aggregate.PatientAllergy;
import com.backintro.domain.patientallergy.model.valueobject.PatientAllergyId;
import com.backintro.domain.patientallergy.port.repository.PatientAllergyRepository;

public class DeletePatientAllergyUseCase {
    private final PatientAllergyRepository repository;

    public DeletePatientAllergyUseCase(PatientAllergyRepository repository) {
        this.repository = repository;
    }

    public void execute(PatientAllergyId id) {
        PatientAllergy aggregate = repository.findById(id)
                .orElseThrow(() -> new PatientAllergyNotFoundApplicationException(id));
        repository.delete(aggregate);
    }
}
