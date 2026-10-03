package com.backintro.application.gender.usecase;

import java.util.List;
import com.backintro.application.gender.dto.GenderResponse;
import com.backintro.domain.gender.port.repository.GenderRepository;

public class ListGenderUseCase {
    private final GenderRepository repository;

    public ListGenderUseCase(GenderRepository repository) {
        this.repository = repository;
    }

    public List<GenderResponse> execute() {
        return repository.findAll()
                .stream()
                .map(GenderResponse::fromDomain)
                .toList();
    }
}
