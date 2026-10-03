package com.backintro.application.citymunicipality.usecase;

import com.backintro.application.citymunicipality.command.UpdateCityMunicipalityCommand;
import com.backintro.application.citymunicipality.dto.CityMunicipalityResponse;
import com.backintro.application.citymunicipality.exception.CityMunicipalityNotFoundApplicationException;
import com.backintro.domain.citymunicipality.model.aggregate.CityMunicipality;
import com.backintro.domain.citymunicipality.port.repository.CityMunicipalityRepository;

public class UpdateCityMunicipalityUseCase {
    private final CityMunicipalityRepository repository;

    public UpdateCityMunicipalityUseCase(CityMunicipalityRepository repository) {
        this.repository = repository;
    }

    public CityMunicipalityResponse execute(UpdateCityMunicipalityCommand command) {
        CityMunicipality aggregate = repository.findById(command.id())
                .orElseThrow(() -> new CityMunicipalityNotFoundApplicationException(command.id()));
        aggregate.update(command.nameCity(), command.codeCiti(), command.description(), command.regionId());
        CityMunicipality saved = repository.save(aggregate);
        return CityMunicipalityResponse.fromDomain(saved);
    }
}
