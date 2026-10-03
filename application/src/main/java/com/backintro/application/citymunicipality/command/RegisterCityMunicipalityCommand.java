package com.backintro.application.citymunicipality.command;

import java.util.UUID;

public record RegisterCityMunicipalityCommand(String nameCity, String codeCiti, String description, UUID regionId) {
}
