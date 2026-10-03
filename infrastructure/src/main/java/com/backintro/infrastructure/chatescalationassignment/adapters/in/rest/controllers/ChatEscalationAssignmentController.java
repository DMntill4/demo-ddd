package com.backintro.infrastructure.chatescalationassignment.adapters.in.rest.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backintro.application.chatescalationassignment.command.RegisterChatEscalationAssignmentCommand;
import com.backintro.application.chatescalationassignment.command.UpdateChatEscalationAssignmentCommand;
import com.backintro.application.chatescalationassignment.dto.ChatEscalationAssignmentResponse;
import com.backintro.application.chatescalationassignment.usecase.*;
import com.backintro.domain.chatescalationassignment.model.valueobject.ChatEscalationAssignmentId;
import com.backintro.infrastructure.chatescalationassignment.adapters.in.rest.dtos.CreateChatEscalationAssignmentRequest;
import com.backintro.infrastructure.chatescalationassignment.adapters.in.rest.dtos.UpdateChatEscalationAssignmentRequest;

@RestController
@RequestMapping("/api/v1/chat-escalation-assignments")
public class ChatEscalationAssignmentController {

    private final RegisterChatEscalationAssignmentUseCase registerUseCase;
    private final GetChatEscalationAssignmentByIdUseCase getByIdUseCase;
    private final ListChatEscalationAssignmentUseCase listUseCase;
    private final UpdateChatEscalationAssignmentUseCase updateUseCase;
    private final DeleteChatEscalationAssignmentUseCase deleteUseCase;

    public ChatEscalationAssignmentController(
            RegisterChatEscalationAssignmentUseCase registerUseCase,
            GetChatEscalationAssignmentByIdUseCase getByIdUseCase,
            ListChatEscalationAssignmentUseCase listUseCase,
            UpdateChatEscalationAssignmentUseCase updateUseCase,
            DeleteChatEscalationAssignmentUseCase deleteUseCase
    ) {
        this.registerUseCase = registerUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.listUseCase = listUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    @PostMapping
    public ResponseEntity<ChatEscalationAssignmentResponse> create(@RequestBody CreateChatEscalationAssignmentRequest request) {
        var command = new RegisterChatEscalationAssignmentCommand(request.escalationId(), request.professionalId(), request.assignedAt());
        var response = registerUseCase.execute(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<ChatEscalationAssignmentResponse>> findAll() {
        return ResponseEntity.ok(listUseCase.execute());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChatEscalationAssignmentResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(getByIdUseCase.execute(new ChatEscalationAssignmentId(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChatEscalationAssignmentResponse> update(@PathVariable UUID id, @RequestBody UpdateChatEscalationAssignmentRequest request) {
        var command = new UpdateChatEscalationAssignmentCommand(new ChatEscalationAssignmentId(id), request.escalationId(), request.professionalId(), request.assignedAt());
        return ResponseEntity.ok(updateUseCase.execute(command));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(new ChatEscalationAssignmentId(id));
        return ResponseEntity.noContent().build();
    }
}
