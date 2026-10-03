package com.backintro.infrastructure.country.adapters.in.rest.dtos;

public record UpdateCountryRequest(String nameCountry, String codeCountry, String description, String telephonePrefix) {
}
