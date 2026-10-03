package com.backintro.application.diagnosticsystem.usecase;

import java.util.List;
import com.backintro.application.diagnosticsystem.dto.DiagnosticSystemResponse;
import com.backintro.domain.diagnosticsystem.port.repository.DiagnosticSystemRepository;

public class ListDiagnosticSystemUseCase {
    private final DiagnosticSystemRepository repository;

    public ListDiagnosticSystemUseCase(DiagnosticSystemRepository repository) {
        this.repository = repository;
    }

    public List<DiagnosticSystemResponse> execute() {
        return repository.findAll()
                .stream()
                .map(DiagnosticSystemResponse::fromDomain)
                .toList();
    }
}
