package com.backintro.infrastructure.encounterstatus.adapters.in.rest.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backintro.application.encounterstatus.command.RegisterEncounterStatusCommand;
import com.backintro.application.encounterstatus.command.UpdateEncounterStatusCommand;
import com.backintro.application.encounterstatus.dto.EncounterStatusResponse;
import com.backintro.application.encounterstatus.usecase.*;
import com.backintro.domain.encounterstatus.model.valueobject.EncounterStatusId;
import com.backintro.infrastructure.encounterstatus.adapters.in.rest.dtos.CreateEncounterStatusRequest;
import com.backintro.infrastructure.encounterstatus.adapters.in.rest.dtos.UpdateEncounterStatusRequest;

@RestController
@RequestMapping("/api/encounter-statusses")
public class EncounterStatusController {

    private final RegisterEncounterStatusUseCase registerUseCase;
    private final GetEncounterStatusByIdUseCase getByIdUseCase;
    private final ListEncounterStatusUseCase listUseCase;
    private final UpdateEncounterStatusUseCase updateUseCase;
    private final DeleteEncounterStatusUseCase deleteUseCase;

    public EncounterStatusController(
            RegisterEncounterStatusUseCase registerUseCase,
            GetEncounterStatusByIdUseCase getByIdUseCase,
            ListEncounterStatusUseCase listUseCase,
            UpdateEncounterStatusUseCase updateUseCase,
            DeleteEncounterStatusUseCase deleteUseCase
    ) {
        this.registerUseCase = registerUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.listUseCase = listUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    @PostMapping
    public ResponseEntity<EncounterStatusResponse> create(@RequestBody CreateEncounterStatusRequest request) {
        var command = new RegisterEncounterStatusCommand(request.name(), request.code());
        var response = registerUseCase.execute(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<EncounterStatusResponse>> findAll() {
        return ResponseEntity.ok(listUseCase.execute());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EncounterStatusResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(getByIdUseCase.execute(new EncounterStatusId(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EncounterStatusResponse> update(@PathVariable UUID id, @RequestBody UpdateEncounterStatusRequest request) {
        var command = new UpdateEncounterStatusCommand(new EncounterStatusId(id), request.name(), request.code());
        return ResponseEntity.ok(updateUseCase.execute(command));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(new EncounterStatusId(id));
        return ResponseEntity.noContent().build();
    }
}
