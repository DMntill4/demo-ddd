package com.backintro.infrastructure.chatparticipant.adapters.in.rest.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backintro.application.chatparticipant.command.RegisterChatParticipantCommand;
import com.backintro.application.chatparticipant.command.UpdateChatParticipantCommand;
import com.backintro.application.chatparticipant.dto.ChatParticipantResponse;
import com.backintro.application.chatparticipant.usecase.*;
import com.backintro.domain.chatparticipant.model.valueobject.ChatParticipantId;
import com.backintro.infrastructure.chatparticipant.adapters.in.rest.dtos.CreateChatParticipantRequest;
import com.backintro.infrastructure.chatparticipant.adapters.in.rest.dtos.UpdateChatParticipantRequest;

@RestController
@RequestMapping("/api/v1/chat-participants")
public class ChatParticipantController {

    private final RegisterChatParticipantUseCase registerUseCase;
    private final GetChatParticipantByIdUseCase getByIdUseCase;
    private final ListChatParticipantUseCase listUseCase;
    private final UpdateChatParticipantUseCase updateUseCase;
    private final DeleteChatParticipantUseCase deleteUseCase;

    public ChatParticipantController(
            RegisterChatParticipantUseCase registerUseCase,
            GetChatParticipantByIdUseCase getByIdUseCase,
            ListChatParticipantUseCase listUseCase,
            UpdateChatParticipantUseCase updateUseCase,
            DeleteChatParticipantUseCase deleteUseCase
    ) {
        this.registerUseCase = registerUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.listUseCase = listUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    @PostMapping
    public ResponseEntity<ChatParticipantResponse> create(@RequestBody CreateChatParticipantRequest request) {
        var command = new RegisterChatParticipantCommand(request.conversationId(), request.participantTypeId(), request.patientId(), request.professionalId());
        var response = registerUseCase.execute(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<ChatParticipantResponse>> findAll() {
        return ResponseEntity.ok(listUseCase.execute());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChatParticipantResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(getByIdUseCase.execute(new ChatParticipantId(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChatParticipantResponse> update(@PathVariable UUID id, @RequestBody UpdateChatParticipantRequest request) {
        var command = new UpdateChatParticipantCommand(new ChatParticipantId(id), request.conversationId(), request.participantTypeId(), request.patientId(), request.professionalId());
        return ResponseEntity.ok(updateUseCase.execute(command));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(new ChatParticipantId(id));
        return ResponseEntity.noContent().build();
    }
}
