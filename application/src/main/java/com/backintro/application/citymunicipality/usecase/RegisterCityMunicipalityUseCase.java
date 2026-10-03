package com.backintro.application.citymunicipality.usecase;

import com.backintro.application.citymunicipality.command.RegisterCityMunicipalityCommand;
import com.backintro.application.citymunicipality.dto.CityMunicipalityResponse;
import com.backintro.domain.citymunicipality.model.aggregate.CityMunicipality;
import com.backintro.domain.citymunicipality.port.repository.CityMunicipalityRepository;

public class RegisterCityMunicipalityUseCase {
    private final CityMunicipalityRepository repository;

    public RegisterCityMunicipalityUseCase(CityMunicipalityRepository repository) {
        this.repository = repository;
    }

    public CityMunicipalityResponse execute(RegisterCityMunicipalityCommand command) {
        CityMunicipality aggregate = CityMunicipality.register(command.nameCity(), command.codeCiti(), command.description(), command.regionId());
        CityMunicipality saved = repository.save(aggregate);
        return CityMunicipalityResponse.fromDomain(saved);
    }
}
