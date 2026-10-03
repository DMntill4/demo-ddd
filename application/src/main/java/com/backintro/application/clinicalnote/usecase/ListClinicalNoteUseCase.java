package com.backintro.application.clinicalnote.usecase;

import java.util.List;
import com.backintro.application.clinicalnote.dto.ClinicalNoteResponse;
import com.backintro.domain.clinicalnote.port.repository.ClinicalNoteRepository;

public class ListClinicalNoteUseCase {
    private final ClinicalNoteRepository repository;

    public ListClinicalNoteUseCase(ClinicalNoteRepository repository) {
        this.repository = repository;
    }

    public List<ClinicalNoteResponse> execute() {
        return repository.findAll()
                .stream()
                .map(ClinicalNoteResponse::fromDomain)
                .toList();
    }
}
