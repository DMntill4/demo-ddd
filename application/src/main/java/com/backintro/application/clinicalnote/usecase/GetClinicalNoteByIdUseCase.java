package com.backintro.application.clinicalnote.usecase;

import com.backintro.application.clinicalnote.dto.ClinicalNoteResponse;
import com.backintro.application.clinicalnote.exception.ClinicalNoteNotFoundApplicationException;
import com.backintro.domain.clinicalnote.model.valueobject.ClinicalNoteId;
import com.backintro.domain.clinicalnote.port.repository.ClinicalNoteRepository;

public class GetClinicalNoteByIdUseCase {
    private final ClinicalNoteRepository repository;

    public GetClinicalNoteByIdUseCase(ClinicalNoteRepository repository) {
        this.repository = repository;
    }

    public ClinicalNoteResponse execute(ClinicalNoteId id) {
        return repository.findById(id)
                .map(ClinicalNoteResponse::fromDomain)
                .orElseThrow(() -> new ClinicalNoteNotFoundApplicationException(id));
    }
}
