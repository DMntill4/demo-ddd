package com.backintro.infrastructure.contact.adapters.in.rest.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backintro.application.contact.command.RegisterContactCommand;
import com.backintro.application.contact.command.UpdateContactCommand;
import com.backintro.application.contact.dto.ContactResponse;
import com.backintro.application.contact.usecase.*;
import com.backintro.domain.contact.model.valueobject.ContactId;
import com.backintro.infrastructure.contact.adapters.in.rest.dtos.CreateContactRequest;
import com.backintro.infrastructure.contact.adapters.in.rest.dtos.UpdateContactRequest;

@RestController
@RequestMapping("/api/v1/contacts")
public class ContactController {

    private final RegisterContactUseCase registerUseCase;
    private final GetContactByIdUseCase getByIdUseCase;
    private final ListContactUseCase listUseCase;
    private final UpdateContactUseCase updateUseCase;
    private final DeleteContactUseCase deleteUseCase;

    public ContactController(
            RegisterContactUseCase registerUseCase,
            GetContactByIdUseCase getByIdUseCase,
            ListContactUseCase listUseCase,
            UpdateContactUseCase updateUseCase,
            DeleteContactUseCase deleteUseCase
    ) {
        this.registerUseCase = registerUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.listUseCase = listUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    @PostMapping
    public ResponseEntity<ContactResponse> create(@RequestBody CreateContactRequest request) {
        var command = new RegisterContactCommand(request.fullName(), request.email(), request.notes(), request.cityId(), request.createdBy(), request.updatedBy());
        var response = registerUseCase.execute(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<ContactResponse>> findAll() {
        return ResponseEntity.ok(listUseCase.execute());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(getByIdUseCase.execute(new ContactId(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContactResponse> update(@PathVariable UUID id, @RequestBody UpdateContactRequest request) {
        var command = new UpdateContactCommand(new ContactId(id), request.fullName(), request.email(), request.notes(), request.cityId(), request.createdBy(), request.updatedBy());
        return ResponseEntity.ok(updateUseCase.execute(command));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(new ContactId(id));
        return ResponseEntity.noContent().build();
    }
}
