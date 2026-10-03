package com.backintro.infrastructure.chatescalationstatushistory.adapters.in.rest.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backintro.application.chatescalationstatushistory.command.RegisterChatEscalationStatusHistoryCommand;
import com.backintro.application.chatescalationstatushistory.command.UpdateChatEscalationStatusHistoryCommand;
import com.backintro.application.chatescalationstatushistory.dto.ChatEscalationStatusHistoryResponse;
import com.backintro.application.chatescalationstatushistory.usecase.*;
import com.backintro.domain.chatescalationstatushistory.model.valueobject.ChatEscalationStatusHistoryId;
import com.backintro.infrastructure.chatescalationstatushistory.adapters.in.rest.dtos.CreateChatEscalationStatusHistoryRequest;
import com.backintro.infrastructure.chatescalationstatushistory.adapters.in.rest.dtos.UpdateChatEscalationStatusHistoryRequest;

@RestController
@RequestMapping("/api/v1/chat-escalation-status-history")
public class ChatEscalationStatusHistoryController {

    private final RegisterChatEscalationStatusHistoryUseCase registerUseCase;
    private final GetChatEscalationStatusHistoryByIdUseCase getByIdUseCase;
    private final ListChatEscalationStatusHistoryUseCase listUseCase;
    private final UpdateChatEscalationStatusHistoryUseCase updateUseCase;
    private final DeleteChatEscalationStatusHistoryUseCase deleteUseCase;

    public ChatEscalationStatusHistoryController(
            RegisterChatEscalationStatusHistoryUseCase registerUseCase,
            GetChatEscalationStatusHistoryByIdUseCase getByIdUseCase,
            ListChatEscalationStatusHistoryUseCase listUseCase,
            UpdateChatEscalationStatusHistoryUseCase updateUseCase,
            DeleteChatEscalationStatusHistoryUseCase deleteUseCase
    ) {
        this.registerUseCase = registerUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.listUseCase = listUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    @PostMapping
    public ResponseEntity<ChatEscalationStatusHistoryResponse> create(@RequestBody CreateChatEscalationStatusHistoryRequest request) {
        var command = new RegisterChatEscalationStatusHistoryCommand(request.escalationId(), request.escalationStatusId(), request.changedAt());
        var response = registerUseCase.execute(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<ChatEscalationStatusHistoryResponse>> findAll() {
        return ResponseEntity.ok(listUseCase.execute());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChatEscalationStatusHistoryResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(getByIdUseCase.execute(new ChatEscalationStatusHistoryId(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChatEscalationStatusHistoryResponse> update(@PathVariable UUID id, @RequestBody UpdateChatEscalationStatusHistoryRequest request) {
        var command = new UpdateChatEscalationStatusHistoryCommand(new ChatEscalationStatusHistoryId(id), request.escalationId(), request.escalationStatusId(), request.changedAt());
        return ResponseEntity.ok(updateUseCase.execute(command));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(new ChatEscalationStatusHistoryId(id));
        return ResponseEntity.noContent().build();
    }
}
