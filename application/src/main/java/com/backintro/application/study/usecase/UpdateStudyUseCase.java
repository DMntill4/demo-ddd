package com.backintro.application.study.usecase;

import com.backintro.application.study.command.UpdateStudyCommand;
import com.backintro.application.study.dto.StudyResponse;
import com.backintro.application.study.exception.StudyNotFoundApplicationException;
import com.backintro.domain.study.model.aggregate.Study;
import com.backintro.domain.study.port.repository.StudyRepository;

public class UpdateStudyUseCase {
    private final StudyRepository repository;

    public UpdateStudyUseCase(StudyRepository repository) {
        this.repository = repository;
    }

    public StudyResponse execute(UpdateStudyCommand command) {
        Study aggregate = repository.findById(command.id())
                .orElseThrow(() -> new StudyNotFoundApplicationException(command.id()));
        aggregate.update(command.name());
        Study saved = repository.save(aggregate);
        return StudyResponse.fromDomain(saved);
    }
}
