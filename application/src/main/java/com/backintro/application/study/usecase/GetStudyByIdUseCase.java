package com.backintro.application.study.usecase;

import com.backintro.application.study.dto.StudyResponse;
import com.backintro.application.study.exception.StudyNotFoundApplicationException;
import com.backintro.domain.study.model.valueobject.StudyId;
import com.backintro.domain.study.port.repository.StudyRepository;

public class GetStudyByIdUseCase {
    private final StudyRepository repository;

    public GetStudyByIdUseCase(StudyRepository repository) {
        this.repository = repository;
    }

    public StudyResponse execute(StudyId id) {
        return repository.findById(id)
                .map(StudyResponse::fromDomain)
                .orElseThrow(() -> new StudyNotFoundApplicationException(id));
    }
}
