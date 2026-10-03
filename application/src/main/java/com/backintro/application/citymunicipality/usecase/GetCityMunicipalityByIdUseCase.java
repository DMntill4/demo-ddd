package com.backintro.application.citymunicipality.usecase;

import com.backintro.application.citymunicipality.dto.CityMunicipalityResponse;
import com.backintro.application.citymunicipality.exception.CityMunicipalityNotFoundApplicationException;
import com.backintro.domain.citymunicipality.model.valueobject.CityMunicipalityId;
import com.backintro.domain.citymunicipality.port.repository.CityMunicipalityRepository;

public class GetCityMunicipalityByIdUseCase {
    private final CityMunicipalityRepository repository;

    public GetCityMunicipalityByIdUseCase(CityMunicipalityRepository repository) {
        this.repository = repository;
    }

    public CityMunicipalityResponse execute(CityMunicipalityId id) {
        return repository.findById(id)
                .map(CityMunicipalityResponse::fromDomain)
                .orElseThrow(() -> new CityMunicipalityNotFoundApplicationException(id));
    }
}
