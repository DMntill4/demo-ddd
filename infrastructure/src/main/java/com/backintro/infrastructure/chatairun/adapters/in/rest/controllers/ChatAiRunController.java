package com.backintro.infrastructure.chatairun.adapters.in.rest.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backintro.application.chatairun.command.RegisterChatAiRunCommand;
import com.backintro.application.chatairun.command.UpdateChatAiRunCommand;
import com.backintro.application.chatairun.dto.ChatAiRunResponse;
import com.backintro.application.chatairun.usecase.*;
import com.backintro.domain.chatairun.model.valueobject.ChatAiRunId;
import com.backintro.infrastructure.chatairun.adapters.in.rest.dtos.CreateChatAiRunRequest;
import com.backintro.infrastructure.chatairun.adapters.in.rest.dtos.UpdateChatAiRunRequest;

@RestController
@RequestMapping("/api/v1/chat-ai-runs")
public class ChatAiRunController {

    private final RegisterChatAiRunUseCase registerUseCase;
    private final GetChatAiRunByIdUseCase getByIdUseCase;
    private final ListChatAiRunUseCase listUseCase;
    private final UpdateChatAiRunUseCase updateUseCase;
    private final DeleteChatAiRunUseCase deleteUseCase;

    public ChatAiRunController(
            RegisterChatAiRunUseCase registerUseCase,
            GetChatAiRunByIdUseCase getByIdUseCase,
            ListChatAiRunUseCase listUseCase,
            UpdateChatAiRunUseCase updateUseCase,
            DeleteChatAiRunUseCase deleteUseCase
    ) {
        this.registerUseCase = registerUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.listUseCase = listUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    @PostMapping
    public ResponseEntity<ChatAiRunResponse> create(@RequestBody CreateChatAiRunRequest request) {
        var command = new RegisterChatAiRunCommand(request.conversationId(), request.messageId(), request.modelId(), request.aiRunStatusId());
        var response = registerUseCase.execute(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<ChatAiRunResponse>> findAll() {
        return ResponseEntity.ok(listUseCase.execute());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChatAiRunResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(getByIdUseCase.execute(new ChatAiRunId(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChatAiRunResponse> update(@PathVariable UUID id, @RequestBody UpdateChatAiRunRequest request) {
        var command = new UpdateChatAiRunCommand(new ChatAiRunId(id), request.conversationId(), request.messageId(), request.modelId(), request.aiRunStatusId());
        return ResponseEntity.ok(updateUseCase.execute(command));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(new ChatAiRunId(id));
        return ResponseEntity.noContent().build();
    }
}
