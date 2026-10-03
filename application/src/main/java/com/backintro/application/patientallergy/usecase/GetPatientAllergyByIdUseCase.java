package com.backintro.application.patientallergy.usecase;

import com.backintro.application.patientallergy.dto.PatientAllergyResponse;
import com.backintro.application.patientallergy.exception.PatientAllergyNotFoundApplicationException;
import com.backintro.domain.patientallergy.model.valueobject.PatientAllergyId;
import com.backintro.domain.patientallergy.port.repository.PatientAllergyRepository;

public class GetPatientAllergyByIdUseCase {
    private final PatientAllergyRepository repository;

    public GetPatientAllergyByIdUseCase(PatientAllergyRepository repository) {
        this.repository = repository;
    }

    public PatientAllergyResponse execute(PatientAllergyId id) {
        return repository.findById(id)
                .map(PatientAllergyResponse::fromDomain)
                .orElseThrow(() -> new PatientAllergyNotFoundApplicationException(id));
    }
}
