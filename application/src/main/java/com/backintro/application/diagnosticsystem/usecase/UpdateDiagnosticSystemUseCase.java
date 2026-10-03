package com.backintro.application.diagnosticsystem.usecase;

import com.backintro.application.diagnosticsystem.command.UpdateDiagnosticSystemCommand;
import com.backintro.application.diagnosticsystem.dto.DiagnosticSystemResponse;
import com.backintro.application.diagnosticsystem.exception.DiagnosticSystemNotFoundApplicationException;
import com.backintro.domain.diagnosticsystem.model.aggregate.DiagnosticSystem;
import com.backintro.domain.diagnosticsystem.port.repository.DiagnosticSystemRepository;

public class UpdateDiagnosticSystemUseCase {
    private final DiagnosticSystemRepository repository;

    public UpdateDiagnosticSystemUseCase(DiagnosticSystemRepository repository) {
        this.repository = repository;
    }

    public DiagnosticSystemResponse execute(UpdateDiagnosticSystemCommand command) {
        DiagnosticSystem aggregate = repository.findById(command.id())
                .orElseThrow(() -> new DiagnosticSystemNotFoundApplicationException(command.id()));
        aggregate.update(command.code(), command.name(), command.version());
        DiagnosticSystem saved = repository.save(aggregate);
        return DiagnosticSystemResponse.fromDomain(saved);
    }
}
