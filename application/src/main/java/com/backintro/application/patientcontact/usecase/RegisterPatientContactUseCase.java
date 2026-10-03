package com.backintro.application.patientcontact.usecase;

import com.backintro.application.patientcontact.command.RegisterPatientContactCommand;
import com.backintro.application.patientcontact.dto.PatientContactResponse;
import com.backintro.domain.patientcontact.model.aggregate.PatientContact;
import com.backintro.domain.patientcontact.port.repository.PatientContactRepository;

public class RegisterPatientContactUseCase {
    private final PatientContactRepository repository;

    public RegisterPatientContactUseCase(PatientContactRepository repository) {
        this.repository = repository;
    }

    public PatientContactResponse execute(RegisterPatientContactCommand command) {
        PatientContact aggregate = PatientContact.register(command.contactId(), command.patientId(), command.isPrimaryContact(), command.isEmergencyContact(), command.relationshipTypeId());
        PatientContact saved = repository.save(aggregate);
        return PatientContactResponse.fromDomain(saved);
    }
}
