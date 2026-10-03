package com.backintro.infrastructure.encountermodality.adapters.in.rest.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backintro.application.encountermodality.command.RegisterEncounterModalityCommand;
import com.backintro.application.encountermodality.command.UpdateEncounterModalityCommand;
import com.backintro.application.encountermodality.dto.EncounterModalityResponse;
import com.backintro.application.encountermodality.usecase.*;
import com.backintro.domain.encountermodality.model.valueobject.EncounterModalityId;
import com.backintro.infrastructure.encountermodality.adapters.in.rest.dtos.CreateEncounterModalityRequest;
import com.backintro.infrastructure.encountermodality.adapters.in.rest.dtos.UpdateEncounterModalityRequest;

@RestController
@RequestMapping("/api/v1/encounter-modalities")
public class EncounterModalityController {

    private final RegisterEncounterModalityUseCase registerUseCase;
    private final GetEncounterModalityByIdUseCase getByIdUseCase;
    private final ListEncounterModalityUseCase listUseCase;
    private final UpdateEncounterModalityUseCase updateUseCase;
    private final DeleteEncounterModalityUseCase deleteUseCase;

    public EncounterModalityController(
            RegisterEncounterModalityUseCase registerUseCase,
            GetEncounterModalityByIdUseCase getByIdUseCase,
            ListEncounterModalityUseCase listUseCase,
            UpdateEncounterModalityUseCase updateUseCase,
            DeleteEncounterModalityUseCase deleteUseCase
    ) {
        this.registerUseCase = registerUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.listUseCase = listUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    @PostMapping
    public ResponseEntity<EncounterModalityResponse> create(@RequestBody CreateEncounterModalityRequest request) {
        var command = new RegisterEncounterModalityCommand(request.code(), request.name());
        var response = registerUseCase.execute(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<EncounterModalityResponse>> findAll() {
        return ResponseEntity.ok(listUseCase.execute());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EncounterModalityResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(getByIdUseCase.execute(new EncounterModalityId(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EncounterModalityResponse> update(@PathVariable UUID id, @RequestBody UpdateEncounterModalityRequest request) {
        var command = new UpdateEncounterModalityCommand(new EncounterModalityId(id), request.code(), request.name());
        return ResponseEntity.ok(updateUseCase.execute(command));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(new EncounterModalityId(id));
        return ResponseEntity.noContent().build();
    }
}
