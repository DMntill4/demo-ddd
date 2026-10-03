package com.backintro.infrastructure.professionalstudy.adapters.in.rest.dtos;

import java.util.UUID;

public record UpdateProfessionalStudyRequest(UUID studyId, UUID professionalId, String title, String university, boolean isValid, String resolutionNumber, UUID countryId) {
}
