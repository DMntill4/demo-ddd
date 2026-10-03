package com.backintro.application.patientcontact.usecase;

import com.backintro.application.patientcontact.command.UpdatePatientContactCommand;
import com.backintro.application.patientcontact.dto.PatientContactResponse;
import com.backintro.application.patientcontact.exception.PatientContactNotFoundApplicationException;
import com.backintro.domain.patientcontact.model.aggregate.PatientContact;
import com.backintro.domain.patientcontact.port.repository.PatientContactRepository;

public class UpdatePatientContactUseCase {
    private final PatientContactRepository repository;

    public UpdatePatientContactUseCase(PatientContactRepository repository) {
        this.repository = repository;
    }

    public PatientContactResponse execute(UpdatePatientContactCommand command) {
        PatientContact aggregate = repository.findById(command.id())
                .orElseThrow(() -> new PatientContactNotFoundApplicationException(command.id()));
        aggregate.update(command.contactId(), command.patientId(), command.isPrimaryContact(), command.isEmergencyContact(), command.relationshipTypeId());
        PatientContact saved = repository.save(aggregate);
        return PatientContactResponse.fromDomain(saved);
    }
}
