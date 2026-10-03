package com.backintro.infrastructure.chataisettings.adapters.in.rest.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backintro.application.chataisettings.command.RegisterChatAiSettingsCommand;
import com.backintro.application.chataisettings.command.UpdateChatAiSettingsCommand;
import com.backintro.application.chataisettings.dto.ChatAiSettingsResponse;
import com.backintro.application.chataisettings.usecase.*;
import com.backintro.domain.chataisettings.model.valueobject.ChatAiSettingsId;
import com.backintro.infrastructure.chataisettings.adapters.in.rest.dtos.CreateChatAiSettingsRequest;
import com.backintro.infrastructure.chataisettings.adapters.in.rest.dtos.UpdateChatAiSettingsRequest;

@RestController
@RequestMapping("/api/chat-conversation-ai-settings")
public class ChatAiSettingsController {

    private final RegisterChatAiSettingsUseCase registerUseCase;
    private final GetChatAiSettingsByIdUseCase getByIdUseCase;
    private final ListChatAiSettingsUseCase listUseCase;
    private final UpdateChatAiSettingsUseCase updateUseCase;
    private final DeleteChatAiSettingsUseCase deleteUseCase;

    public ChatAiSettingsController(
            RegisterChatAiSettingsUseCase registerUseCase,
            GetChatAiSettingsByIdUseCase getByIdUseCase,
            ListChatAiSettingsUseCase listUseCase,
            UpdateChatAiSettingsUseCase updateUseCase,
            DeleteChatAiSettingsUseCase deleteUseCase
    ) {
        this.registerUseCase = registerUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.listUseCase = listUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    @PostMapping
    public ResponseEntity<ChatAiSettingsResponse> create(@RequestBody CreateChatAiSettingsRequest request) {
        var command = new RegisterChatAiSettingsCommand(request.name(), request.code());
        var response = registerUseCase.execute(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<ChatAiSettingsResponse>> findAll() {
        return ResponseEntity.ok(listUseCase.execute());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChatAiSettingsResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(getByIdUseCase.execute(new ChatAiSettingsId(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChatAiSettingsResponse> update(@PathVariable UUID id, @RequestBody UpdateChatAiSettingsRequest request) {
        var command = new UpdateChatAiSettingsCommand(new ChatAiSettingsId(id), request.name(), request.code());
        return ResponseEntity.ok(updateUseCase.execute(command));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(new ChatAiSettingsId(id));
        return ResponseEntity.noContent().build();
    }
}
