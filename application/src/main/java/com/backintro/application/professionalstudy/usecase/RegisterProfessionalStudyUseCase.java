package com.backintro.application.professionalstudy.usecase;

import com.backintro.application.professionalstudy.command.RegisterProfessionalStudyCommand;
import com.backintro.application.professionalstudy.dto.ProfessionalStudyResponse;
import com.backintro.domain.professionalstudy.model.aggregate.ProfessionalStudy;
import com.backintro.domain.professionalstudy.port.repository.ProfessionalStudyRepository;

public class RegisterProfessionalStudyUseCase {
    private final ProfessionalStudyRepository repository;

    public RegisterProfessionalStudyUseCase(ProfessionalStudyRepository repository) {
        this.repository = repository;
    }

    public ProfessionalStudyResponse execute(RegisterProfessionalStudyCommand command) {
        ProfessionalStudy aggregate = ProfessionalStudy.register(command.studyId(), command.professionalId(), command.title(), command.university(), command.isValid(), command.resolutionNumber(), command.countryId());
        ProfessionalStudy saved = repository.save(aggregate);
        return ProfessionalStudyResponse.fromDomain(saved);
    }
}
