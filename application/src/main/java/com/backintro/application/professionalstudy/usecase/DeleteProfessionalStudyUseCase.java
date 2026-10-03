package com.backintro.application.professionalstudy.usecase;

import com.backintro.application.professionalstudy.exception.ProfessionalStudyNotFoundApplicationException;
import com.backintro.domain.professionalstudy.model.aggregate.ProfessionalStudy;
import com.backintro.domain.professionalstudy.model.valueobject.ProfessionalStudyId;
import com.backintro.domain.professionalstudy.port.repository.ProfessionalStudyRepository;

public class DeleteProfessionalStudyUseCase {
    private final ProfessionalStudyRepository repository;

    public DeleteProfessionalStudyUseCase(ProfessionalStudyRepository repository) {
        this.repository = repository;
    }

    public void execute(ProfessionalStudyId id) {
        ProfessionalStudy aggregate = repository.findById(id)
                .orElseThrow(() -> new ProfessionalStudyNotFoundApplicationException(id));
        repository.delete(aggregate);
    }
}
