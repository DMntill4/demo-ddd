package com.backintro.infrastructure.citymunicipality.adapters.in.rest.dtos;

import java.util.UUID;

public record CreateCityMunicipalityRequest(String nameCity, String codeCiti, String description, UUID regionId) {
}
