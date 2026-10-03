package com.backintro.infrastructure.providermodelai.adapters.in.rest.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backintro.application.providermodelai.command.RegisterProviderModelAiCommand;
import com.backintro.application.providermodelai.command.UpdateProviderModelAiCommand;
import com.backintro.application.providermodelai.dto.ProviderModelAiResponse;
import com.backintro.application.providermodelai.usecase.*;
import com.backintro.domain.providermodelai.model.valueobject.ProviderModelAiId;
import com.backintro.infrastructure.providermodelai.adapters.in.rest.dtos.CreateProviderModelAiRequest;
import com.backintro.infrastructure.providermodelai.adapters.in.rest.dtos.UpdateProviderModelAiRequest;

@RestController
@RequestMapping("/api/provider-models-ai")
public class ProviderModelAiController {

    private final RegisterProviderModelAiUseCase registerUseCase;
    private final GetProviderModelAiByIdUseCase getByIdUseCase;
    private final ListProviderModelAiUseCase listUseCase;
    private final UpdateProviderModelAiUseCase updateUseCase;
    private final DeleteProviderModelAiUseCase deleteUseCase;

    public ProviderModelAiController(
            RegisterProviderModelAiUseCase registerUseCase,
            GetProviderModelAiByIdUseCase getByIdUseCase,
            ListProviderModelAiUseCase listUseCase,
            UpdateProviderModelAiUseCase updateUseCase,
            DeleteProviderModelAiUseCase deleteUseCase
    ) {
        this.registerUseCase = registerUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.listUseCase = listUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    @PostMapping
    public ResponseEntity<ProviderModelAiResponse> create(@RequestBody CreateProviderModelAiRequest request) {
        var command = new RegisterProviderModelAiCommand(request.name(), request.code());
        var response = registerUseCase.execute(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<ProviderModelAiResponse>> findAll() {
        return ResponseEntity.ok(listUseCase.execute());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProviderModelAiResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(getByIdUseCase.execute(new ProviderModelAiId(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProviderModelAiResponse> update(@PathVariable UUID id, @RequestBody UpdateProviderModelAiRequest request) {
        var command = new UpdateProviderModelAiCommand(new ProviderModelAiId(id), request.name(), request.code());
        return ResponseEntity.ok(updateUseCase.execute(command));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(new ProviderModelAiId(id));
        return ResponseEntity.noContent().build();
    }
}
