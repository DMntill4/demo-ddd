package com.backintro.application.professionalstudy.usecase;

import com.backintro.application.professionalstudy.dto.ProfessionalStudyResponse;
import com.backintro.application.professionalstudy.exception.ProfessionalStudyNotFoundApplicationException;
import com.backintro.domain.professionalstudy.model.valueobject.ProfessionalStudyId;
import com.backintro.domain.professionalstudy.port.repository.ProfessionalStudyRepository;

public class GetProfessionalStudyByIdUseCase {
    private final ProfessionalStudyRepository repository;

    public GetProfessionalStudyByIdUseCase(ProfessionalStudyRepository repository) {
        this.repository = repository;
    }

    public ProfessionalStudyResponse execute(ProfessionalStudyId id) {
        return repository.findById(id)
                .map(ProfessionalStudyResponse::fromDomain)
                .orElseThrow(() -> new ProfessionalStudyNotFoundApplicationException(id));
    }
}
