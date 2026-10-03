package com.backintro.application.gender.usecase;

import com.backintro.application.gender.command.RegisterGenderCommand;
import com.backintro.application.gender.dto.GenderResponse;
import com.backintro.domain.gender.model.aggregate.Gender;
import com.backintro.domain.gender.port.repository.GenderRepository;

public class RegisterGenderUseCase {
    private final GenderRepository repository;

    public RegisterGenderUseCase(GenderRepository repository) {
        this.repository = repository;
    }

    public GenderResponse execute(RegisterGenderCommand command) {
        Gender aggregate = Gender.register(command.description());
        Gender saved = repository.save(aggregate);
        return GenderResponse.fromDomain(saved);
    }
}
