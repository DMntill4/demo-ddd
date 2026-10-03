package com.backintro.infrastructure.priority.adapters.in.rest.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backintro.application.priority.command.RegisterPriorityCommand;
import com.backintro.application.priority.command.UpdatePriorityCommand;
import com.backintro.application.priority.dto.PriorityResponse;
import com.backintro.application.priority.usecase.*;
import com.backintro.domain.priority.model.valueobject.PriorityId;
import com.backintro.infrastructure.priority.adapters.in.rest.dtos.CreatePriorityRequest;
import com.backintro.infrastructure.priority.adapters.in.rest.dtos.UpdatePriorityRequest;

@RestController
@RequestMapping("/api/v1/priorities")
public class PriorityController {

    private final RegisterPriorityUseCase registerUseCase;
    private final GetPriorityByIdUseCase getByIdUseCase;
    private final ListPriorityUseCase listUseCase;
    private final UpdatePriorityUseCase updateUseCase;
    private final DeletePriorityUseCase deleteUseCase;

    public PriorityController(
            RegisterPriorityUseCase registerUseCase,
            GetPriorityByIdUseCase getByIdUseCase,
            ListPriorityUseCase listUseCase,
            UpdatePriorityUseCase updateUseCase,
            DeletePriorityUseCase deleteUseCase
    ) {
        this.registerUseCase = registerUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.listUseCase = listUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    @PostMapping
    public ResponseEntity<PriorityResponse> create(@RequestBody CreatePriorityRequest request) {
        var command = new RegisterPriorityCommand(request.namePriority());
        var response = registerUseCase.execute(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<PriorityResponse>> findAll() {
        return ResponseEntity.ok(listUseCase.execute());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PriorityResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(getByIdUseCase.execute(new PriorityId(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PriorityResponse> update(@PathVariable UUID id, @RequestBody UpdatePriorityRequest request) {
        var command = new UpdatePriorityCommand(new PriorityId(id), request.namePriority());
        return ResponseEntity.ok(updateUseCase.execute(command));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(new PriorityId(id));
        return ResponseEntity.noContent().build();
    }
}
