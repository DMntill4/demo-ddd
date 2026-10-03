package com.backintro.application.mentalstatusexam.usecase;

import java.util.List;
import com.backintro.application.mentalstatusexam.dto.MentalStatusExamResponse;
import com.backintro.domain.mentalstatusexam.port.repository.MentalStatusExamRepository;

public class ListMentalStatusExamUseCase {
    private final MentalStatusExamRepository repository;

    public ListMentalStatusExamUseCase(MentalStatusExamRepository repository) {
        this.repository = repository;
    }

    public List<MentalStatusExamResponse> execute() {
        return repository.findAll()
                .stream()
                .map(MentalStatusExamResponse::fromDomain)
                .toList();
    }
}
