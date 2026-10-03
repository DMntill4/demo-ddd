package com.backintro.infrastructure.messagetype.adapters.in.rest.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backintro.application.messagetype.command.RegisterMessageTypeCommand;
import com.backintro.application.messagetype.command.UpdateMessageTypeCommand;
import com.backintro.application.messagetype.dto.MessageTypeResponse;
import com.backintro.application.messagetype.usecase.*;
import com.backintro.domain.messagetype.model.valueobject.MessageTypeId;
import com.backintro.infrastructure.messagetype.adapters.in.rest.dtos.CreateMessageTypeRequest;
import com.backintro.infrastructure.messagetype.adapters.in.rest.dtos.UpdateMessageTypeRequest;

@RestController
@RequestMapping("/api/v1/message-types")
public class MessageTypeController {

    private final RegisterMessageTypeUseCase registerUseCase;
    private final GetMessageTypeByIdUseCase getByIdUseCase;
    private final ListMessageTypeUseCase listUseCase;
    private final UpdateMessageTypeUseCase updateUseCase;
    private final DeleteMessageTypeUseCase deleteUseCase;

    public MessageTypeController(
            RegisterMessageTypeUseCase registerUseCase,
            GetMessageTypeByIdUseCase getByIdUseCase,
            ListMessageTypeUseCase listUseCase,
            UpdateMessageTypeUseCase updateUseCase,
            DeleteMessageTypeUseCase deleteUseCase
    ) {
        this.registerUseCase = registerUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.listUseCase = listUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    @PostMapping
    public ResponseEntity<MessageTypeResponse> create(@RequestBody CreateMessageTypeRequest request) {
        var command = new RegisterMessageTypeCommand(request.nameType());
        var response = registerUseCase.execute(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<MessageTypeResponse>> findAll() {
        return ResponseEntity.ok(listUseCase.execute());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MessageTypeResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(getByIdUseCase.execute(new MessageTypeId(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MessageTypeResponse> update(@PathVariable UUID id, @RequestBody UpdateMessageTypeRequest request) {
        var command = new UpdateMessageTypeCommand(new MessageTypeId(id), request.nameType());
        return ResponseEntity.ok(updateUseCase.execute(command));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(new MessageTypeId(id));
        return ResponseEntity.noContent().build();
    }
}
