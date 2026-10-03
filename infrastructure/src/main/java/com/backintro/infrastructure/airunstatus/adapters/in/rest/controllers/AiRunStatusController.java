package com.backintro.infrastructure.airunstatus.adapters.in.rest.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backintro.application.airunstatus.command.RegisterAiRunStatusCommand;
import com.backintro.application.airunstatus.command.UpdateAiRunStatusCommand;
import com.backintro.application.airunstatus.dto.AiRunStatusResponse;
import com.backintro.application.airunstatus.usecase.*;
import com.backintro.domain.airunstatus.model.valueobject.AiRunStatusId;
import com.backintro.infrastructure.airunstatus.adapters.in.rest.dtos.CreateAiRunStatusRequest;
import com.backintro.infrastructure.airunstatus.adapters.in.rest.dtos.UpdateAiRunStatusRequest;

@RestController
@RequestMapping("/api/ai-runs-statuses")
public class AiRunStatusController {

    private final RegisterAiRunStatusUseCase registerUseCase;
    private final GetAiRunStatusByIdUseCase getByIdUseCase;
    private final ListAiRunStatusUseCase listUseCase;
    private final UpdateAiRunStatusUseCase updateUseCase;
    private final DeleteAiRunStatusUseCase deleteUseCase;

    public AiRunStatusController(
            RegisterAiRunStatusUseCase registerUseCase,
            GetAiRunStatusByIdUseCase getByIdUseCase,
            ListAiRunStatusUseCase listUseCase,
            UpdateAiRunStatusUseCase updateUseCase,
            DeleteAiRunStatusUseCase deleteUseCase
    ) {
        this.registerUseCase = registerUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.listUseCase = listUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    @PostMapping
    public ResponseEntity<AiRunStatusResponse> create(@RequestBody CreateAiRunStatusRequest request) {
        var command = new RegisterAiRunStatusCommand(request.name(), request.code());
        var response = registerUseCase.execute(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<AiRunStatusResponse>> findAll() {
        return ResponseEntity.ok(listUseCase.execute());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AiRunStatusResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(getByIdUseCase.execute(new AiRunStatusId(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AiRunStatusResponse> update(@PathVariable UUID id, @RequestBody UpdateAiRunStatusRequest request) {
        var command = new UpdateAiRunStatusCommand(new AiRunStatusId(id), request.name(), request.code());
        return ResponseEntity.ok(updateUseCase.execute(command));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(new AiRunStatusId(id));
        return ResponseEntity.noContent().build();
    }
}
