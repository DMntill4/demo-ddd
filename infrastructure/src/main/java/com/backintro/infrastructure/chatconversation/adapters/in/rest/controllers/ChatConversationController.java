package com.backintro.infrastructure.chatconversation.adapters.in.rest.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backintro.application.chatconversation.command.RegisterChatConversationCommand;
import com.backintro.application.chatconversation.command.UpdateChatConversationCommand;
import com.backintro.application.chatconversation.dto.ChatConversationResponse;
import com.backintro.application.chatconversation.usecase.*;
import com.backintro.domain.chatconversation.model.valueobject.ChatConversationId;
import com.backintro.infrastructure.chatconversation.adapters.in.rest.dtos.CreateChatConversationRequest;
import com.backintro.infrastructure.chatconversation.adapters.in.rest.dtos.UpdateChatConversationRequest;

@RestController
@RequestMapping("/api/v1/chat-conversations")
public class ChatConversationController {

    private final RegisterChatConversationUseCase registerUseCase;
    private final GetChatConversationByIdUseCase getByIdUseCase;
    private final ListChatConversationUseCase listUseCase;
    private final UpdateChatConversationUseCase updateUseCase;
    private final DeleteChatConversationUseCase deleteUseCase;

    public ChatConversationController(
            RegisterChatConversationUseCase registerUseCase,
            GetChatConversationByIdUseCase getByIdUseCase,
            ListChatConversationUseCase listUseCase,
            UpdateChatConversationUseCase updateUseCase,
            DeleteChatConversationUseCase deleteUseCase
    ) {
        this.registerUseCase = registerUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.listUseCase = listUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    @PostMapping
    public ResponseEntity<ChatConversationResponse> create(@RequestBody CreateChatConversationRequest request) {
        var command = new RegisterChatConversationCommand(request.conversationStatusId(), request.priorityId(), request.lastMessageAt(), request.closed(), request.closedAt(), request.closedBy());
        var response = registerUseCase.execute(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<ChatConversationResponse>> findAll() {
        return ResponseEntity.ok(listUseCase.execute());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChatConversationResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(getByIdUseCase.execute(new ChatConversationId(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChatConversationResponse> update(@PathVariable UUID id, @RequestBody UpdateChatConversationRequest request) {
        var command = new UpdateChatConversationCommand(new ChatConversationId(id), request.conversationStatusId(), request.priorityId(), request.lastMessageAt(), request.closed(), request.closedAt(), request.closedBy());
        return ResponseEntity.ok(updateUseCase.execute(command));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(new ChatConversationId(id));
        return ResponseEntity.noContent().build();
    }
}
