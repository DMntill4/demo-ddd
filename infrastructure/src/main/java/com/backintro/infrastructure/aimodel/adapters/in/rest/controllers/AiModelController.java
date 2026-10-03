package com.backintro.infrastructure.aimodel.adapters.in.rest.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backintro.application.aimodel.command.RegisterAiModelCommand;
import com.backintro.application.aimodel.command.UpdateAiModelCommand;
import com.backintro.application.aimodel.dto.AiModelResponse;
import com.backintro.application.aimodel.usecase.*;
import com.backintro.domain.aimodel.model.valueobject.AiModelId;
import com.backintro.infrastructure.aimodel.adapters.in.rest.dtos.CreateAiModelRequest;
import com.backintro.infrastructure.aimodel.adapters.in.rest.dtos.UpdateAiModelRequest;

@RestController
@RequestMapping("/api/v1/ai-models")
public class AiModelController {

    private final RegisterAiModelUseCase registerUseCase;
    private final GetAiModelByIdUseCase getByIdUseCase;
    private final ListAiModelUseCase listUseCase;
    private final UpdateAiModelUseCase updateUseCase;
    private final DeleteAiModelUseCase deleteUseCase;

    public AiModelController(
            RegisterAiModelUseCase registerUseCase,
            GetAiModelByIdUseCase getByIdUseCase,
            ListAiModelUseCase listUseCase,
            UpdateAiModelUseCase updateUseCase,
            DeleteAiModelUseCase deleteUseCase
    ) {
        this.registerUseCase = registerUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.listUseCase = listUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    @PostMapping
    public ResponseEntity<AiModelResponse> create(@RequestBody CreateAiModelRequest request) {
        var command = new RegisterAiModelCommand(request.providerModelId(), request.nameModel(), request.modelKey(), request.inputTokenPrice(), request.outputTokenPrice(), request.maxTokens(), request.contextWindow());
        var response = registerUseCase.execute(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<AiModelResponse>> findAll() {
        return ResponseEntity.ok(listUseCase.execute());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AiModelResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(getByIdUseCase.execute(new AiModelId(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AiModelResponse> update(@PathVariable UUID id, @RequestBody UpdateAiModelRequest request) {
        var command = new UpdateAiModelCommand(new AiModelId(id), request.providerModelId(), request.nameModel(), request.modelKey(), request.inputTokenPrice(), request.outputTokenPrice(), request.maxTokens(), request.contextWindow());
        return ResponseEntity.ok(updateUseCase.execute(command));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(new AiModelId(id));
        return ResponseEntity.noContent().build();
    }
}
