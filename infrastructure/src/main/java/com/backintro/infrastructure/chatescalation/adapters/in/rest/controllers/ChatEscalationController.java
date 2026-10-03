package com.backintro.infrastructure.chatescalation.adapters.in.rest.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backintro.application.chatescalation.command.RegisterChatEscalationCommand;
import com.backintro.application.chatescalation.command.UpdateChatEscalationCommand;
import com.backintro.application.chatescalation.dto.ChatEscalationResponse;
import com.backintro.application.chatescalation.usecase.*;
import com.backintro.domain.chatescalation.model.valueobject.ChatEscalationId;
import com.backintro.infrastructure.chatescalation.adapters.in.rest.dtos.CreateChatEscalationRequest;
import com.backintro.infrastructure.chatescalation.adapters.in.rest.dtos.UpdateChatEscalationRequest;

@RestController
@RequestMapping("/api/v1/chat-escalations")
public class ChatEscalationController {

    private final RegisterChatEscalationUseCase registerUseCase;
    private final GetChatEscalationByIdUseCase getByIdUseCase;
    private final ListChatEscalationUseCase listUseCase;
    private final UpdateChatEscalationUseCase updateUseCase;
    private final DeleteChatEscalationUseCase deleteUseCase;

    public ChatEscalationController(
            RegisterChatEscalationUseCase registerUseCase,
            GetChatEscalationByIdUseCase getByIdUseCase,
            ListChatEscalationUseCase listUseCase,
            UpdateChatEscalationUseCase updateUseCase,
            DeleteChatEscalationUseCase deleteUseCase
    ) {
        this.registerUseCase = registerUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.listUseCase = listUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    @PostMapping
    public ResponseEntity<ChatEscalationResponse> create(@RequestBody CreateChatEscalationRequest request) {
        var command = new RegisterChatEscalationCommand(request.conversationId(), request.statusId(), request.fromAi(), request.reason());
        var response = registerUseCase.execute(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<ChatEscalationResponse>> findAll() {
        return ResponseEntity.ok(listUseCase.execute());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChatEscalationResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(getByIdUseCase.execute(new ChatEscalationId(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChatEscalationResponse> update(@PathVariable UUID id, @RequestBody UpdateChatEscalationRequest request) {
        var command = new UpdateChatEscalationCommand(new ChatEscalationId(id), request.conversationId(), request.statusId(), request.fromAi(), request.reason());
        return ResponseEntity.ok(updateUseCase.execute(command));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(new ChatEscalationId(id));
        return ResponseEntity.noContent().build();
    }
}
