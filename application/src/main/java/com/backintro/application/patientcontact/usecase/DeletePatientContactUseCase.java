package com.backintro.application.patientcontact.usecase;

import com.backintro.application.patientcontact.exception.PatientContactNotFoundApplicationException;
import com.backintro.domain.patientcontact.model.aggregate.PatientContact;
import com.backintro.domain.patientcontact.model.valueobject.PatientContactId;
import com.backintro.domain.patientcontact.port.repository.PatientContactRepository;

public class DeletePatientContactUseCase {
    private final PatientContactRepository repository;

    public DeletePatientContactUseCase(PatientContactRepository repository) {
        this.repository = repository;
    }

    public void execute(PatientContactId id) {
        PatientContact aggregate = repository.findById(id)
                .orElseThrow(() -> new PatientContactNotFoundApplicationException(id));
        repository.delete(aggregate);
    }
}
