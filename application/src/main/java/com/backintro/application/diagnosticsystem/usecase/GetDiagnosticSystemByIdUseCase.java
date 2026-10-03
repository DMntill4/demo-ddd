package com.backintro.application.diagnosticsystem.usecase;

import com.backintro.application.diagnosticsystem.dto.DiagnosticSystemResponse;
import com.backintro.application.diagnosticsystem.exception.DiagnosticSystemNotFoundApplicationException;
import com.backintro.domain.diagnosticsystem.model.valueobject.DiagnosticSystemId;
import com.backintro.domain.diagnosticsystem.port.repository.DiagnosticSystemRepository;

public class GetDiagnosticSystemByIdUseCase {
    private final DiagnosticSystemRepository repository;

    public GetDiagnosticSystemByIdUseCase(DiagnosticSystemRepository repository) {
        this.repository = repository;
    }

    public DiagnosticSystemResponse execute(DiagnosticSystemId id) {
        return repository.findById(id)
                .map(DiagnosticSystemResponse::fromDomain)
                .orElseThrow(() -> new DiagnosticSystemNotFoundApplicationException(id));
    }
}
