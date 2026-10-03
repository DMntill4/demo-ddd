package com.backintro.infrastructure.chatmessage.adapters.in.rest.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backintro.application.chatmessage.command.RegisterChatMessageCommand;
import com.backintro.application.chatmessage.command.UpdateChatMessageCommand;
import com.backintro.application.chatmessage.dto.ChatMessageResponse;
import com.backintro.application.chatmessage.usecase.*;
import com.backintro.domain.chatmessage.model.valueobject.ChatMessageId;
import com.backintro.infrastructure.chatmessage.adapters.in.rest.dtos.CreateChatMessageRequest;
import com.backintro.infrastructure.chatmessage.adapters.in.rest.dtos.UpdateChatMessageRequest;

@RestController
@RequestMapping("/api/v1/chat-messages")
public class ChatMessageController {

    private final RegisterChatMessageUseCase registerUseCase;
    private final GetChatMessageByIdUseCase getByIdUseCase;
    private final ListChatMessageUseCase listUseCase;
    private final UpdateChatMessageUseCase updateUseCase;
    private final DeleteChatMessageUseCase deleteUseCase;

    public ChatMessageController(
            RegisterChatMessageUseCase registerUseCase,
            GetChatMessageByIdUseCase getByIdUseCase,
            ListChatMessageUseCase listUseCase,
            UpdateChatMessageUseCase updateUseCase,
            DeleteChatMessageUseCase deleteUseCase
    ) {
        this.registerUseCase = registerUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.listUseCase = listUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    @PostMapping
    public ResponseEntity<ChatMessageResponse> create(@RequestBody CreateChatMessageRequest request) {
        var command = new RegisterChatMessageCommand(request.conversationId(), request.messageTypeId(), request.participantId(), request.content(), request.metadata());
        var response = registerUseCase.execute(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<ChatMessageResponse>> findAll() {
        return ResponseEntity.ok(listUseCase.execute());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChatMessageResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(getByIdUseCase.execute(new ChatMessageId(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChatMessageResponse> update(@PathVariable UUID id, @RequestBody UpdateChatMessageRequest request) {
        var command = new UpdateChatMessageCommand(new ChatMessageId(id), request.conversationId(), request.messageTypeId(), request.participantId(), request.content(), request.metadata());
        return ResponseEntity.ok(updateUseCase.execute(command));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(new ChatMessageId(id));
        return ResponseEntity.noContent().build();
    }
}
