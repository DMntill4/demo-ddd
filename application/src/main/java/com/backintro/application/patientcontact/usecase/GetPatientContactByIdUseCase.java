package com.backintro.application.patientcontact.usecase;

import com.backintro.application.patientcontact.dto.PatientContactResponse;
import com.backintro.application.patientcontact.exception.PatientContactNotFoundApplicationException;
import com.backintro.domain.patientcontact.model.valueobject.PatientContactId;
import com.backintro.domain.patientcontact.port.repository.PatientContactRepository;

public class GetPatientContactByIdUseCase {
    private final PatientContactRepository repository;

    public GetPatientContactByIdUseCase(PatientContactRepository repository) {
        this.repository = repository;
    }

    public PatientContactResponse execute(PatientContactId id) {
        return repository.findById(id)
                .map(PatientContactResponse::fromDomain)
                .orElseThrow(() -> new PatientContactNotFoundApplicationException(id));
    }
}
