package com.backintro.infrastructure.chatairunerror.adapters.in.rest.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backintro.application.chatairunerror.command.RegisterChatAiRunErrorCommand;
import com.backintro.application.chatairunerror.command.UpdateChatAiRunErrorCommand;
import com.backintro.application.chatairunerror.dto.ChatAiRunErrorResponse;
import com.backintro.application.chatairunerror.usecase.*;
import com.backintro.domain.chatairunerror.model.valueobject.ChatAiRunErrorId;
import com.backintro.infrastructure.chatairunerror.adapters.in.rest.dtos.CreateChatAiRunErrorRequest;
import com.backintro.infrastructure.chatairunerror.adapters.in.rest.dtos.UpdateChatAiRunErrorRequest;

@RestController
@RequestMapping("/api/v1/chat-ai-run-errors")
public class ChatAiRunErrorController {

    private final RegisterChatAiRunErrorUseCase registerUseCase;
    private final GetChatAiRunErrorByIdUseCase getByIdUseCase;
    private final ListChatAiRunErrorUseCase listUseCase;
    private final UpdateChatAiRunErrorUseCase updateUseCase;
    private final DeleteChatAiRunErrorUseCase deleteUseCase;

    public ChatAiRunErrorController(
            RegisterChatAiRunErrorUseCase registerUseCase,
            GetChatAiRunErrorByIdUseCase getByIdUseCase,
            ListChatAiRunErrorUseCase listUseCase,
            UpdateChatAiRunErrorUseCase updateUseCase,
            DeleteChatAiRunErrorUseCase deleteUseCase
    ) {
        this.registerUseCase = registerUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.listUseCase = listUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    @PostMapping
    public ResponseEntity<ChatAiRunErrorResponse> create(@RequestBody CreateChatAiRunErrorRequest request) {
        var command = new RegisterChatAiRunErrorCommand(request.aiRunId(), request.errorMessage(), request.errorCode(), request.providerErrorId());
        var response = registerUseCase.execute(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<ChatAiRunErrorResponse>> findAll() {
        return ResponseEntity.ok(listUseCase.execute());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChatAiRunErrorResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(getByIdUseCase.execute(new ChatAiRunErrorId(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChatAiRunErrorResponse> update(@PathVariable UUID id, @RequestBody UpdateChatAiRunErrorRequest request) {
        var command = new UpdateChatAiRunErrorCommand(new ChatAiRunErrorId(id), request.aiRunId(), request.errorMessage(), request.errorCode(), request.providerErrorId());
        return ResponseEntity.ok(updateUseCase.execute(command));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(new ChatAiRunErrorId(id));
        return ResponseEntity.noContent().build();
    }
}
