package com.backintro.application.country.usecase;

import com.backintro.application.country.dto.CountryResponse;
import com.backintro.application.country.exception.CountryNotFoundApplicationException;
import com.backintro.domain.country.model.valueobject.CountryId;
import com.backintro.domain.country.port.repository.CountryRepository;

public class GetCountryByIdUseCase {
    private final CountryRepository repository;

    public GetCountryByIdUseCase(CountryRepository repository) {
        this.repository = repository;
    }

    public CountryResponse execute(CountryId id) {
        return repository.findById(id)
                .map(CountryResponse::fromDomain)
                .orElseThrow(() -> new CountryNotFoundApplicationException(id));
    }
}
