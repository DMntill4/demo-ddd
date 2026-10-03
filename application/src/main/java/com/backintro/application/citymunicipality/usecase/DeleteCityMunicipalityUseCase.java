package com.backintro.application.citymunicipality.usecase;

import com.backintro.application.citymunicipality.exception.CityMunicipalityNotFoundApplicationException;
import com.backintro.domain.citymunicipality.model.aggregate.CityMunicipality;
import com.backintro.domain.citymunicipality.model.valueobject.CityMunicipalityId;
import com.backintro.domain.citymunicipality.port.repository.CityMunicipalityRepository;

public class DeleteCityMunicipalityUseCase {
    private final CityMunicipalityRepository repository;

    public DeleteCityMunicipalityUseCase(CityMunicipalityRepository repository) {
        this.repository = repository;
    }

    public void execute(CityMunicipalityId id) {
        CityMunicipality aggregate = repository.findById(id)
                .orElseThrow(() -> new CityMunicipalityNotFoundApplicationException(id));
        repository.delete(aggregate);
    }
}
