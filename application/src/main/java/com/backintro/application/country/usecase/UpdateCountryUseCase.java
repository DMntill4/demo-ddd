package com.backintro.application.country.usecase;

import com.backintro.application.country.command.UpdateCountryCommand;
import com.backintro.application.country.dto.CountryResponse;
import com.backintro.application.country.exception.CountryNotFoundApplicationException;
import com.backintro.domain.country.model.aggregate.Country;
import com.backintro.domain.country.port.repository.CountryRepository;

public class UpdateCountryUseCase {
    private final CountryRepository repository;

    public UpdateCountryUseCase(CountryRepository repository) {
        this.repository = repository;
    }

    public CountryResponse execute(UpdateCountryCommand command) {
        Country aggregate = repository.findById(command.id())
                .orElseThrow(() -> new CountryNotFoundApplicationException(command.id()));
        aggregate.update(command.nameCountry(), command.codeCountry(), command.description(), command.telephonePrefix());
        Country saved = repository.save(aggregate);
        return CountryResponse.fromDomain(saved);
    }
}
