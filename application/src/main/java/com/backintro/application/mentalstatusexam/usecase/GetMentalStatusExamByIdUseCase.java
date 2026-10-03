package com.backintro.application.mentalstatusexam.usecase;

import com.backintro.application.mentalstatusexam.dto.MentalStatusExamResponse;
import com.backintro.application.mentalstatusexam.exception.MentalStatusExamNotFoundApplicationException;
import com.backintro.domain.mentalstatusexam.model.valueobject.MentalStatusExamId;
import com.backintro.domain.mentalstatusexam.port.repository.MentalStatusExamRepository;

public class GetMentalStatusExamByIdUseCase {
    private final MentalStatusExamRepository repository;

    public GetMentalStatusExamByIdUseCase(MentalStatusExamRepository repository) {
        this.repository = repository;
    }

    public MentalStatusExamResponse execute(MentalStatusExamId id) {
        return repository.findById(id)
                .map(MentalStatusExamResponse::fromDomain)
                .orElseThrow(() -> new MentalStatusExamNotFoundApplicationException(id));
    }
}
