package com.backintro.application.clinicalnote.usecase;

import com.backintro.application.clinicalnote.command.UpdateClinicalNoteCommand;
import com.backintro.application.clinicalnote.dto.ClinicalNoteResponse;
import com.backintro.application.clinicalnote.exception.ClinicalNoteNotFoundApplicationException;
import com.backintro.domain.clinicalnote.model.aggregate.ClinicalNote;
import com.backintro.domain.clinicalnote.port.repository.ClinicalNoteRepository;

public class UpdateClinicalNoteUseCase {
    private final ClinicalNoteRepository repository;

    public UpdateClinicalNoteUseCase(ClinicalNoteRepository repository) {
        this.repository = repository;
    }

    public ClinicalNoteResponse execute(UpdateClinicalNoteCommand command) {
        ClinicalNote aggregate = repository.findById(command.id())
                .orElseThrow(() -> new ClinicalNoteNotFoundApplicationException(command.id()));
        aggregate.update(command.encounterId(), command.professionalId(), command.subjective(), command.objective(), command.assessment(), command.plan(), command.additionalNotes(), command.signedAt());
        ClinicalNote saved = repository.save(aggregate);
        return ClinicalNoteResponse.fromDomain(saved);
    }
}
