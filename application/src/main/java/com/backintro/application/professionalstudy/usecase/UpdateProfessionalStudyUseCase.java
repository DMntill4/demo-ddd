package com.backintro.application.professionalstudy.usecase;

import com.backintro.application.professionalstudy.command.UpdateProfessionalStudyCommand;
import com.backintro.application.professionalstudy.dto.ProfessionalStudyResponse;
import com.backintro.application.professionalstudy.exception.ProfessionalStudyNotFoundApplicationException;
import com.backintro.domain.professionalstudy.model.aggregate.ProfessionalStudy;
import com.backintro.domain.professionalstudy.port.repository.ProfessionalStudyRepository;

public class UpdateProfessionalStudyUseCase {
    private final ProfessionalStudyRepository repository;

    public UpdateProfessionalStudyUseCase(ProfessionalStudyRepository repository) {
        this.repository = repository;
    }

    public ProfessionalStudyResponse execute(UpdateProfessionalStudyCommand command) {
        ProfessionalStudy aggregate = repository.findById(command.id())
                .orElseThrow(() -> new ProfessionalStudyNotFoundApplicationException(command.id()));
        aggregate.update(command.studyId(), command.professionalId(), command.title(), command.university(), command.isValid(), command.resolutionNumber(), command.countryId());
        ProfessionalStudy saved = repository.save(aggregate);
        return ProfessionalStudyResponse.fromDomain(saved);
    }
}
