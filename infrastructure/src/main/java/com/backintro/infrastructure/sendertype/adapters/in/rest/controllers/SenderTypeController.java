package com.backintro.infrastructure.sendertype.adapters.in.rest.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backintro.application.sendertype.command.RegisterSenderTypeCommand;
import com.backintro.application.sendertype.command.UpdateSenderTypeCommand;
import com.backintro.application.sendertype.dto.SenderTypeResponse;
import com.backintro.application.sendertype.usecase.*;
import com.backintro.domain.sendertype.model.valueobject.SenderTypeId;
import com.backintro.infrastructure.sendertype.adapters.in.rest.dtos.CreateSenderTypeRequest;
import com.backintro.infrastructure.sendertype.adapters.in.rest.dtos.UpdateSenderTypeRequest;

@RestController
@RequestMapping("/api/v1/sender-types")
public class SenderTypeController {

    private final RegisterSenderTypeUseCase registerUseCase;
    private final GetSenderTypeByIdUseCase getByIdUseCase;
    private final ListSenderTypeUseCase listUseCase;
    private final UpdateSenderTypeUseCase updateUseCase;
    private final DeleteSenderTypeUseCase deleteUseCase;

    public SenderTypeController(
            RegisterSenderTypeUseCase registerUseCase,
            GetSenderTypeByIdUseCase getByIdUseCase,
            ListSenderTypeUseCase listUseCase,
            UpdateSenderTypeUseCase updateUseCase,
            DeleteSenderTypeUseCase deleteUseCase
    ) {
        this.registerUseCase = registerUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.listUseCase = listUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    @PostMapping
    public ResponseEntity<SenderTypeResponse> create(@RequestBody CreateSenderTypeRequest request) {
        var command = new RegisterSenderTypeCommand(request.nameType());
        var response = registerUseCase.execute(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<SenderTypeResponse>> findAll() {
        return ResponseEntity.ok(listUseCase.execute());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SenderTypeResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(getByIdUseCase.execute(new SenderTypeId(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SenderTypeResponse> update(@PathVariable UUID id, @RequestBody UpdateSenderTypeRequest request) {
        var command = new UpdateSenderTypeCommand(new SenderTypeId(id), request.nameType());
        return ResponseEntity.ok(updateUseCase.execute(command));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(new SenderTypeId(id));
        return ResponseEntity.noContent().build();
    }
}
