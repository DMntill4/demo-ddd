package com.backintro.infrastructure.stateregion.adapters.in.rest.dtos;

import java.util.UUID;

public record CreateStateRegionRequest(String nameRegion, String codeRegion, String description, UUID countryId) {
}
