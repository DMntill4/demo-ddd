package com.backintro.domain.citymunicipality.exception;

import com.backintro.domain.common.exception.DomainException;
import com.backintro.domain.citymunicipality.model.valueobject.CityMunicipalityId;

public class CityMunicipalityNotFoundException extends DomainException {
    public CityMunicipalityNotFoundException(CityMunicipalityId id) {
        super("CityMunicipality with id " + id.value() + " was not found.");
    }
}
