package com.backintro.infrastructure.chatairunmetric.adapters.in.rest.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backintro.application.chatairunmetric.command.RegisterChatAiRunMetricCommand;
import com.backintro.application.chatairunmetric.command.UpdateChatAiRunMetricCommand;
import com.backintro.application.chatairunmetric.dto.ChatAiRunMetricResponse;
import com.backintro.application.chatairunmetric.usecase.*;
import com.backintro.domain.chatairunmetric.model.valueobject.ChatAiRunMetricId;
import com.backintro.infrastructure.chatairunmetric.adapters.in.rest.dtos.CreateChatAiRunMetricRequest;
import com.backintro.infrastructure.chatairunmetric.adapters.in.rest.dtos.UpdateChatAiRunMetricRequest;

@RestController
@RequestMapping("/api/v1/chat-ai-run-metrics")
public class ChatAiRunMetricController {

    private final RegisterChatAiRunMetricUseCase registerUseCase;
    private final GetChatAiRunMetricByIdUseCase getByIdUseCase;
    private final ListChatAiRunMetricUseCase listUseCase;
    private final UpdateChatAiRunMetricUseCase updateUseCase;
    private final DeleteChatAiRunMetricUseCase deleteUseCase;

    public ChatAiRunMetricController(
            RegisterChatAiRunMetricUseCase registerUseCase,
            GetChatAiRunMetricByIdUseCase getByIdUseCase,
            ListChatAiRunMetricUseCase listUseCase,
            UpdateChatAiRunMetricUseCase updateUseCase,
            DeleteChatAiRunMetricUseCase deleteUseCase
    ) {
        this.registerUseCase = registerUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.listUseCase = listUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    @PostMapping
    public ResponseEntity<ChatAiRunMetricResponse> create(@RequestBody CreateChatAiRunMetricRequest request) {
        var command = new RegisterChatAiRunMetricCommand(request.aiRunId(), request.promptTokens(), request.completionTokens(), request.totalTokens(), request.cost());
        var response = registerUseCase.execute(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<ChatAiRunMetricResponse>> findAll() {
        return ResponseEntity.ok(listUseCase.execute());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChatAiRunMetricResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(getByIdUseCase.execute(new ChatAiRunMetricId(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChatAiRunMetricResponse> update(@PathVariable UUID id, @RequestBody UpdateChatAiRunMetricRequest request) {
        var command = new UpdateChatAiRunMetricCommand(new ChatAiRunMetricId(id), request.aiRunId(), request.promptTokens(), request.completionTokens(), request.totalTokens(), request.cost());
        return ResponseEntity.ok(updateUseCase.execute(command));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(new ChatAiRunMetricId(id));
        return ResponseEntity.noContent().build();
    }
}
