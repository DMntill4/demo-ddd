package com.backintro.infrastructure.diagnosticsystem.adapters.in.rest.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backintro.application.diagnosticsystem.command.RegisterDiagnosticSystemCommand;
import com.backintro.application.diagnosticsystem.command.UpdateDiagnosticSystemCommand;
import com.backintro.application.diagnosticsystem.dto.DiagnosticSystemResponse;
import com.backintro.application.diagnosticsystem.usecase.*;
import com.backintro.domain.diagnosticsystem.model.valueobject.DiagnosticSystemId;
import com.backintro.infrastructure.diagnosticsystem.adapters.in.rest.dtos.CreateDiagnosticSystemRequest;
import com.backintro.infrastructure.diagnosticsystem.adapters.in.rest.dtos.UpdateDiagnosticSystemRequest;

@RestController
@RequestMapping("/api/v1/diagnostic-systems")
public class DiagnosticSystemController {

    private final RegisterDiagnosticSystemUseCase registerUseCase;
    private final GetDiagnosticSystemByIdUseCase getByIdUseCase;
    private final ListDiagnosticSystemUseCase listUseCase;
    private final UpdateDiagnosticSystemUseCase updateUseCase;
    private final DeleteDiagnosticSystemUseCase deleteUseCase;

    public DiagnosticSystemController(
            RegisterDiagnosticSystemUseCase registerUseCase,
            GetDiagnosticSystemByIdUseCase getByIdUseCase,
            ListDiagnosticSystemUseCase listUseCase,
            UpdateDiagnosticSystemUseCase updateUseCase,
            DeleteDiagnosticSystemUseCase deleteUseCase
    ) {
        this.registerUseCase = registerUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.listUseCase = listUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    @PostMapping
    public ResponseEntity<DiagnosticSystemResponse> create(@RequestBody CreateDiagnosticSystemRequest request) {
        var command = new RegisterDiagnosticSystemCommand(request.code(), request.name(), request.version());
        var response = registerUseCase.execute(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<DiagnosticSystemResponse>> findAll() {
        return ResponseEntity.ok(listUseCase.execute());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DiagnosticSystemResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(getByIdUseCase.execute(new DiagnosticSystemId(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DiagnosticSystemResponse> update(@PathVariable UUID id, @RequestBody UpdateDiagnosticSystemRequest request) {
        var command = new UpdateDiagnosticSystemCommand(new DiagnosticSystemId(id), request.code(), request.name(), request.version());
        return ResponseEntity.ok(updateUseCase.execute(command));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(new DiagnosticSystemId(id));
        return ResponseEntity.noContent().build();
    }
}
