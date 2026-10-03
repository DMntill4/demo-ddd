package com.backintro.application.professional.usecase;

import java.util.List;
import com.backintro.application.professional.dto.ProfessionalResponse;
import com.backintro.domain.professional.port.repository.ProfessionalRepository;

public class ListProfessionalUseCase {
    private final ProfessionalRepository repository;

    public ListProfessionalUseCase(ProfessionalRepository repository) {
        this.repository = repository;
    }

    public List<ProfessionalResponse> execute() {
        return repository.findAll()
                .stream()
                .map(ProfessionalResponse::fromDomain)
                .toList();
    }
}
