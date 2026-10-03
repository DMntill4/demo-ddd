package com.backintro.application.citymunicipality.exception;

import com.backintro.application.common.exception.ApplicationException;
import com.backintro.domain.citymunicipality.model.valueobject.CityMunicipalityId;

public class CityMunicipalityNotFoundApplicationException extends ApplicationException {
    public CityMunicipalityNotFoundApplicationException(CityMunicipalityId id) {
        super("CityMunicipality with id " + id.value() + " was not found.");
    }
}
