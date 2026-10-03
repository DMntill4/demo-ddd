package com.backintro.application.study.usecase;

import com.backintro.application.study.exception.StudyNotFoundApplicationException;
import com.backintro.domain.study.model.aggregate.Study;
import com.backintro.domain.study.model.valueobject.StudyId;
import com.backintro.domain.study.port.repository.StudyRepository;

public class DeleteStudyUseCase {
    private final StudyRepository repository;

    public DeleteStudyUseCase(StudyRepository repository) {
        this.repository = repository;
    }

    public void execute(StudyId id) {
        Study aggregate = repository.findById(id)
                .orElseThrow(() -> new StudyNotFoundApplicationException(id));
        repository.delete(aggregate);
    }
}
