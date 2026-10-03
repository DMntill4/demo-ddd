package com.backintro.application.country.command;

import com.backintro.domain.country.model.valueobject.CountryId;

public record UpdateCountryCommand(CountryId id, String nameCountry, String codeCountry, String description, String telephonePrefix) {
}
