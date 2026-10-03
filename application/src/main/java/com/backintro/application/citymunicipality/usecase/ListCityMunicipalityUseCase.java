package com.backintro.application.citymunicipality.usecase;

import java.util.List;
import com.backintro.application.citymunicipality.dto.CityMunicipalityResponse;
import com.backintro.domain.citymunicipality.port.repository.CityMunicipalityRepository;

public class ListCityMunicipalityUseCase {
    private final CityMunicipalityRepository repository;

    public ListCityMunicipalityUseCase(CityMunicipalityRepository repository) {
        this.repository = repository;
    }

    public List<CityMunicipalityResponse> execute() {
        return repository.findAll()
                .stream()
                .map(CityMunicipalityResponse::fromDomain)
                .toList();
    }
}
