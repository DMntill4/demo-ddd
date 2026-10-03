package com.backintro.application.diagnosticsystem.usecase;

import com.backintro.application.diagnosticsystem.exception.DiagnosticSystemNotFoundApplicationException;
import com.backintro.domain.diagnosticsystem.model.aggregate.DiagnosticSystem;
import com.backintro.domain.diagnosticsystem.model.valueobject.DiagnosticSystemId;
import com.backintro.domain.diagnosticsystem.port.repository.DiagnosticSystemRepository;

public class DeleteDiagnosticSystemUseCase {
    private final DiagnosticSystemRepository repository;

    public DeleteDiagnosticSystemUseCase(DiagnosticSystemRepository repository) {
        this.repository = repository;
    }

    public void execute(DiagnosticSystemId id) {
        DiagnosticSystem aggregate = repository.findById(id)
                .orElseThrow(() -> new DiagnosticSystemNotFoundApplicationException(id));
        repository.delete(aggregate);
    }
}
