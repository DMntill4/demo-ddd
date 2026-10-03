package com.backintro.infrastructure.conversationstatus.adapters.in.rest.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backintro.application.conversationstatus.command.RegisterConversationStatusCommand;
import com.backintro.application.conversationstatus.command.UpdateConversationStatusCommand;
import com.backintro.application.conversationstatus.dto.ConversationStatusResponse;
import com.backintro.application.conversationstatus.usecase.*;
import com.backintro.domain.conversationstatus.model.valueobject.ConversationStatusId;
import com.backintro.infrastructure.conversationstatus.adapters.in.rest.dtos.CreateConversationStatusRequest;
import com.backintro.infrastructure.conversationstatus.adapters.in.rest.dtos.UpdateConversationStatusRequest;

@RestController
@RequestMapping("/api/conversations-statuses")
public class ConversationStatusController {

    private final RegisterConversationStatusUseCase registerUseCase;
    private final GetConversationStatusByIdUseCase getByIdUseCase;
    private final ListConversationStatusUseCase listUseCase;
    private final UpdateConversationStatusUseCase updateUseCase;
    private final DeleteConversationStatusUseCase deleteUseCase;

    public ConversationStatusController(
            RegisterConversationStatusUseCase registerUseCase,
            GetConversationStatusByIdUseCase getByIdUseCase,
            ListConversationStatusUseCase listUseCase,
            UpdateConversationStatusUseCase updateUseCase,
            DeleteConversationStatusUseCase deleteUseCase
    ) {
        this.registerUseCase = registerUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.listUseCase = listUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    @PostMapping
    public ResponseEntity<ConversationStatusResponse> create(@RequestBody CreateConversationStatusRequest request) {
        var command = new RegisterConversationStatusCommand(request.name(), request.code());
        var response = registerUseCase.execute(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<ConversationStatusResponse>> findAll() {
        return ResponseEntity.ok(listUseCase.execute());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConversationStatusResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(getByIdUseCase.execute(new ConversationStatusId(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConversationStatusResponse> update(@PathVariable UUID id, @RequestBody UpdateConversationStatusRequest request) {
        var command = new UpdateConversationStatusCommand(new ConversationStatusId(id), request.name(), request.code());
        return ResponseEntity.ok(updateUseCase.execute(command));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(new ConversationStatusId(id));
        return ResponseEntity.noContent().build();
    }
}
