package com.backintro.application.professional.usecase;

import com.backintro.application.professional.command.RegisterProfessionalCommand;
import com.backintro.application.professional.dto.ProfessionalResponse;
import com.backintro.domain.professional.model.aggregate.Professional;
import com.backintro.domain.professional.port.repository.ProfessionalRepository;

public class RegisterProfessionalUseCase {
    private final ProfessionalRepository repository;

    public RegisterProfessionalUseCase(ProfessionalRepository repository) {
        this.repository = repository;
    }

    public ProfessionalResponse execute(RegisterProfessionalCommand command) {
        Professional aggregate = Professional.register(command.documentTypeId(), command.documentNumber(), command.firstName(), command.lastName(), command.professionalTypeId(), command.licenseNumber(), command.cityId());
        Professional saved = repository.save(aggregate);
        return ProfessionalResponse.fromDomain(saved);
    }
}
