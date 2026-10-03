package com.backintro.application.mentalstatusexam.usecase;

import com.backintro.application.mentalstatusexam.exception.MentalStatusExamNotFoundApplicationException;
import com.backintro.domain.mentalstatusexam.model.aggregate.MentalStatusExam;
import com.backintro.domain.mentalstatusexam.model.valueobject.MentalStatusExamId;
import com.backintro.domain.mentalstatusexam.port.repository.MentalStatusExamRepository;

public class DeleteMentalStatusExamUseCase {
    private final MentalStatusExamRepository repository;

    public DeleteMentalStatusExamUseCase(MentalStatusExamRepository repository) {
        this.repository = repository;
    }

    public void execute(MentalStatusExamId id) {
        MentalStatusExam aggregate = repository.findById(id)
                .orElseThrow(() -> new MentalStatusExamNotFoundApplicationException(id));
        repository.delete(aggregate);
    }
}
