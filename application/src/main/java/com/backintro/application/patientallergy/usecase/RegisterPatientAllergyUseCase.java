package com.backintro.application.patientallergy.usecase;

import com.backintro.application.patientallergy.command.RegisterPatientAllergyCommand;
import com.backintro.application.patientallergy.dto.PatientAllergyResponse;
import com.backintro.domain.patientallergy.model.aggregate.PatientAllergy;
import com.backintro.domain.patientallergy.port.repository.PatientAllergyRepository;

public class RegisterPatientAllergyUseCase {
    private final PatientAllergyRepository repository;

    public RegisterPatientAllergyUseCase(PatientAllergyRepository repository) {
        this.repository = repository;
    }

    public PatientAllergyResponse execute(RegisterPatientAllergyCommand command) {
        PatientAllergy aggregate = PatientAllergy.register(command.patientId(), command.substance(), command.reaction(), command.severity(), command.recordedAt(), command.recordedBy());
        PatientAllergy saved = repository.save(aggregate);
        return PatientAllergyResponse.fromDomain(saved);
    }
}
