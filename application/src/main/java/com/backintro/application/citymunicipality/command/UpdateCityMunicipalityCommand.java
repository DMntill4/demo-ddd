package com.backintro.application.citymunicipality.command;

import java.util.UUID;

import com.backintro.domain.citymunicipality.model.valueobject.CityMunicipalityId;

public record UpdateCityMunicipalityCommand(CityMunicipalityId id, String nameCity, String codeCiti, String description, UUID regionId) {
}
