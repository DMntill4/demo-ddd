package com.backintro.application.professionalstudy.usecase;

import java.util.List;
import com.backintro.application.professionalstudy.dto.ProfessionalStudyResponse;
import com.backintro.domain.professionalstudy.port.repository.ProfessionalStudyRepository;

public class ListProfessionalStudyUseCase {
    private final ProfessionalStudyRepository repository;

    public ListProfessionalStudyUseCase(ProfessionalStudyRepository repository) {
        this.repository = repository;
    }

    public List<ProfessionalStudyResponse> execute() {
        return repository.findAll()
                .stream()
                .map(ProfessionalStudyResponse::fromDomain)
                .toList();
    }
}
