package com.backintro.infrastructure.emailcontact.adapters.in.rest.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backintro.application.emailcontact.command.RegisterEmailContactCommand;
import com.backintro.application.emailcontact.command.UpdateEmailContactCommand;
import com.backintro.application.emailcontact.dto.EmailContactResponse;
import com.backintro.application.emailcontact.usecase.*;
import com.backintro.domain.emailcontact.model.valueobject.EmailContactId;
import com.backintro.infrastructure.emailcontact.adapters.in.rest.dtos.CreateEmailContactRequest;
import com.backintro.infrastructure.emailcontact.adapters.in.rest.dtos.UpdateEmailContactRequest;

@RestController
@RequestMapping("/api/v1/email-contacts")
public class EmailContactController {

    private final RegisterEmailContactUseCase registerUseCase;
    private final GetEmailContactByIdUseCase getByIdUseCase;
    private final ListEmailContactUseCase listUseCase;
    private final UpdateEmailContactUseCase updateUseCase;
    private final DeleteEmailContactUseCase deleteUseCase;

    public EmailContactController(
            RegisterEmailContactUseCase registerUseCase,
            GetEmailContactByIdUseCase getByIdUseCase,
            ListEmailContactUseCase listUseCase,
            UpdateEmailContactUseCase updateUseCase,
            DeleteEmailContactUseCase deleteUseCase
    ) {
        this.registerUseCase = registerUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.listUseCase = listUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    @PostMapping
    public ResponseEntity<EmailContactResponse> create(@RequestBody CreateEmailContactRequest request) {
        var command = new RegisterEmailContactCommand(request.contactId(), request.email(), request.notes());
        var response = registerUseCase.execute(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<EmailContactResponse>> findAll() {
        return ResponseEntity.ok(listUseCase.execute());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmailContactResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(getByIdUseCase.execute(new EmailContactId(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmailContactResponse> update(@PathVariable UUID id, @RequestBody UpdateEmailContactRequest request) {
        var command = new UpdateEmailContactCommand(new EmailContactId(id), request.contactId(), request.email(), request.notes());
        return ResponseEntity.ok(updateUseCase.execute(command));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(new EmailContactId(id));
        return ResponseEntity.noContent().build();
    }
}
