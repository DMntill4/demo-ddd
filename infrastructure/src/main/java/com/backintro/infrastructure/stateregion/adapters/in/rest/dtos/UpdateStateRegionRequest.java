package com.backintro.infrastructure.stateregion.adapters.in.rest.dtos;

import java.util.UUID;

public record UpdateStateRegionRequest(String nameRegion, String codeRegion, String description, UUID countryId) {
}
