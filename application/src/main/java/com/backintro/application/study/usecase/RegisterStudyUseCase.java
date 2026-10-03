package com.backintro.application.study.usecase;

import com.backintro.application.study.command.RegisterStudyCommand;
import com.backintro.application.study.dto.StudyResponse;
import com.backintro.domain.study.model.aggregate.Study;
import com.backintro.domain.study.port.repository.StudyRepository;

public class RegisterStudyUseCase {
    private final StudyRepository repository;

    public RegisterStudyUseCase(StudyRepository repository) {
        this.repository = repository;
    }

    public StudyResponse execute(RegisterStudyCommand command) {
        Study aggregate = Study.register(command.name());
        Study saved = repository.save(aggregate);
        return StudyResponse.fromDomain(saved);
    }
}
