package com.backintro.application.gender.usecase;

import com.backintro.application.gender.exception.GenderNotFoundApplicationException;
import com.backintro.domain.gender.model.aggregate.Gender;
import com.backintro.domain.gender.model.valueobject.GenderId;
import com.backintro.domain.gender.port.repository.GenderRepository;

public class DeleteGenderUseCase {
    private final GenderRepository repository;

    public DeleteGenderUseCase(GenderRepository repository) {
        this.repository = repository;
    }

    public void execute(GenderId id) {
        Gender aggregate = repository.findById(id)
                .orElseThrow(() -> new GenderNotFoundApplicationException(id));
        repository.delete(aggregate);
    }
}
