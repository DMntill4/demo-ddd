package com.backintro.infrastructure.professionalstudy.adapters.in.rest.dtos;

import java.util.UUID;

public record CreateProfessionalStudyRequest(UUID studyId, UUID professionalId, String title, String university, boolean isValid, String resolutionNumber, UUID countryId) {
}
