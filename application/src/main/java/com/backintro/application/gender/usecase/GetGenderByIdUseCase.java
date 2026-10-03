package com.backintro.application.gender.usecase;

import com.backintro.application.gender.dto.GenderResponse;
import com.backintro.application.gender.exception.GenderNotFoundApplicationException;
import com.backintro.domain.gender.model.valueobject.GenderId;
import com.backintro.domain.gender.port.repository.GenderRepository;

public class GetGenderByIdUseCase {
    private final GenderRepository repository;

    public GetGenderByIdUseCase(GenderRepository repository) {
        this.repository = repository;
    }

    public GenderResponse execute(GenderId id) {
        return repository.findById(id)
                .map(GenderResponse::fromDomain)
                .orElseThrow(() -> new GenderNotFoundApplicationException(id));
    }
}
