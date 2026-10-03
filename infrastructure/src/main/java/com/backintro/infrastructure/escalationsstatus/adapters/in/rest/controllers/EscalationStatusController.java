package com.backintro.infrastructure.escalationsstatus.adapters.in.rest.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backintro.application.escalationsstatus.command.RegisterEscalationStatusCommand;
import com.backintro.application.escalationsstatus.command.UpdateEscalationStatusCommand;
import com.backintro.application.escalationsstatus.dto.EscalationStatusResponse;
import com.backintro.application.escalationsstatus.usecase.*;
import com.backintro.domain.escalationsstatus.model.valueobject.EscalationStatusId;
import com.backintro.infrastructure.escalationsstatus.adapters.in.rest.dtos.CreateEscalationStatusRequest;
import com.backintro.infrastructure.escalationsstatus.adapters.in.rest.dtos.UpdateEscalationStatusRequest;

@RestController
@RequestMapping("/api/v1/escalations-statuses")
public class EscalationStatusController {

    private final RegisterEscalationStatusUseCase registerUseCase;
    private final GetEscalationStatusByIdUseCase getByIdUseCase;
    private final ListEscalationStatusUseCase listUseCase;
    private final UpdateEscalationStatusUseCase updateUseCase;
    private final DeleteEscalationStatusUseCase deleteUseCase;

    public EscalationStatusController(
            RegisterEscalationStatusUseCase registerUseCase,
            GetEscalationStatusByIdUseCase getByIdUseCase,
            ListEscalationStatusUseCase listUseCase,
            UpdateEscalationStatusUseCase updateUseCase,
            DeleteEscalationStatusUseCase deleteUseCase
    ) {
        this.registerUseCase = registerUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.listUseCase = listUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    @PostMapping
    public ResponseEntity<EscalationStatusResponse> create(@RequestBody CreateEscalationStatusRequest request) {
        var command = new RegisterEscalationStatusCommand(request.nameStatus());
        var response = registerUseCase.execute(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<EscalationStatusResponse>> findAll() {
        return ResponseEntity.ok(listUseCase.execute());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EscalationStatusResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(getByIdUseCase.execute(new EscalationStatusId(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EscalationStatusResponse> update(@PathVariable UUID id, @RequestBody UpdateEscalationStatusRequest request) {
        var command = new UpdateEscalationStatusCommand(new EscalationStatusId(id), request.nameStatus());
        return ResponseEntity.ok(updateUseCase.execute(command));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(new EscalationStatusId(id));
        return ResponseEntity.noContent().build();
    }
}
