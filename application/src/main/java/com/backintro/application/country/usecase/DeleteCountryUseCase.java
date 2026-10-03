package com.backintro.application.country.usecase;

import com.backintro.application.country.exception.CountryNotFoundApplicationException;
import com.backintro.domain.country.model.aggregate.Country;
import com.backintro.domain.country.model.valueobject.CountryId;
import com.backintro.domain.country.port.repository.CountryRepository;

public class DeleteCountryUseCase {
    private final CountryRepository repository;

    public DeleteCountryUseCase(CountryRepository repository) {
        this.repository = repository;
    }

    public void execute(CountryId id) {
        Country aggregate = repository.findById(id)
                .orElseThrow(() -> new CountryNotFoundApplicationException(id));
        repository.delete(aggregate);
    }
}
