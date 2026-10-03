package com.backintro.application.clinicalnote.usecase;

import com.backintro.application.clinicalnote.exception.ClinicalNoteNotFoundApplicationException;
import com.backintro.domain.clinicalnote.model.aggregate.ClinicalNote;
import com.backintro.domain.clinicalnote.model.valueobject.ClinicalNoteId;
import com.backintro.domain.clinicalnote.port.repository.ClinicalNoteRepository;

public class DeleteClinicalNoteUseCase {
    private final ClinicalNoteRepository repository;

    public DeleteClinicalNoteUseCase(ClinicalNoteRepository repository) {
        this.repository = repository;
    }

    public void execute(ClinicalNoteId id) {
        ClinicalNote aggregate = repository.findById(id)
                .orElseThrow(() -> new ClinicalNoteNotFoundApplicationException(id));
        repository.delete(aggregate);
    }
}
