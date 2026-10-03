package com.backintro.infrastructure.encounter.adapters.in.rest.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backintro.application.encounter.command.RegisterEncounterCommand;
import com.backintro.application.encounter.command.UpdateEncounterCommand;
import com.backintro.application.encounter.dto.EncounterResponse;
import com.backintro.application.encounter.usecase.*;
import com.backintro.domain.encounter.model.valueobject.EncounterId;
import com.backintro.infrastructure.encounter.adapters.in.rest.dtos.CreateEncounterRequest;
import com.backintro.infrastructure.encounter.adapters.in.rest.dtos.UpdateEncounterRequest;

@RestController
@RequestMapping("/api/v1/encounters")
public class EncounterController {

    private final RegisterEncounterUseCase registerUseCase;
    private final GetEncounterByIdUseCase getByIdUseCase;
    private final ListEncounterUseCase listUseCase;
    private final UpdateEncounterUseCase updateUseCase;
    private final DeleteEncounterUseCase deleteUseCase;

    public EncounterController(
            RegisterEncounterUseCase registerUseCase,
            GetEncounterByIdUseCase getByIdUseCase,
            ListEncounterUseCase listUseCase,
            UpdateEncounterUseCase updateUseCase,
            DeleteEncounterUseCase deleteUseCase
    ) {
        this.registerUseCase = registerUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.listUseCase = listUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    @PostMapping
    public ResponseEntity<EncounterResponse> create(@RequestBody CreateEncounterRequest request) {
        var command = new RegisterEncounterCommand(request.clinicalRecordId(), request.professionalId(), request.encounterTypeId(), request.startedAt(), request.endedAt(), request.reasonForVisit(), request.currentCondition(), request.modalityId(), request.statusId(), request.createdBy(), request.updatedBy());
        var response = registerUseCase.execute(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<EncounterResponse>> findAll() {
        return ResponseEntity.ok(listUseCase.execute());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EncounterResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(getByIdUseCase.execute(new EncounterId(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EncounterResponse> update(@PathVariable UUID id, @RequestBody UpdateEncounterRequest request) {
        var command = new UpdateEncounterCommand(new EncounterId(id), request.clinicalRecordId(), request.professionalId(), request.encounterTypeId(), request.startedAt(), request.endedAt(), request.reasonForVisit(), request.currentCondition(), request.modalityId(), request.statusId(), request.createdBy(), request.updatedBy());
        return ResponseEntity.ok(updateUseCase.execute(command));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(new EncounterId(id));
        return ResponseEntity.noContent().build();
    }
}
