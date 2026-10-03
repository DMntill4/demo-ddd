package com.backintro.application.gender.usecase;

import com.backintro.application.gender.command.UpdateGenderCommand;
import com.backintro.application.gender.dto.GenderResponse;
import com.backintro.application.gender.exception.GenderNotFoundApplicationException;
import com.backintro.domain.gender.model.aggregate.Gender;
import com.backintro.domain.gender.port.repository.GenderRepository;

public class UpdateGenderUseCase {
    private final GenderRepository repository;

    public UpdateGenderUseCase(GenderRepository repository) {
        this.repository = repository;
    }

    public GenderResponse execute(UpdateGenderCommand command) {
        Gender aggregate = repository.findById(command.id())
                .orElseThrow(() -> new GenderNotFoundApplicationException(command.id()));
        aggregate.update(command.description());
        Gender saved = repository.save(aggregate);
        return GenderResponse.fromDomain(saved);
    }
}
