package com.backintro.infrastructure.documenttype.adapters.in.rest.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backintro.application.documenttype.command.RegisterDocumentTypeCommand;
import com.backintro.application.documenttype.command.UpdateDocumentTypeCommand;
import com.backintro.application.documenttype.dto.DocumentTypeResponse;
import com.backintro.application.documenttype.usecase.*;
import com.backintro.domain.documenttype.model.valueobject.DocumentTypeId;
import com.backintro.infrastructure.documenttype.adapters.in.rest.dtos.CreateDocumentTypeRequest;
import com.backintro.infrastructure.documenttype.adapters.in.rest.dtos.UpdateDocumentTypeRequest;

@RestController
@RequestMapping("/api/v1/document-types")
public class DocumentTypeController {

    private final RegisterDocumentTypeUseCase registerUseCase;
    private final GetDocumentTypeByIdUseCase getByIdUseCase;
    private final ListDocumentTypeUseCase listUseCase;
    private final UpdateDocumentTypeUseCase updateUseCase;
    private final DeleteDocumentTypeUseCase deleteUseCase;

    public DocumentTypeController(
            RegisterDocumentTypeUseCase registerUseCase,
            GetDocumentTypeByIdUseCase getByIdUseCase,
            ListDocumentTypeUseCase listUseCase,
            UpdateDocumentTypeUseCase updateUseCase,
            DeleteDocumentTypeUseCase deleteUseCase
    ) {
        this.registerUseCase = registerUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.listUseCase = listUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    @PostMapping
    public ResponseEntity<DocumentTypeResponse> create(@RequestBody CreateDocumentTypeRequest request) {
        var command = new RegisterDocumentTypeCommand(request.code(), request.name());
        var response = registerUseCase.execute(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<DocumentTypeResponse>> findAll() {
        return ResponseEntity.ok(listUseCase.execute());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DocumentTypeResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(getByIdUseCase.execute(new DocumentTypeId(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DocumentTypeResponse> update(@PathVariable UUID id, @RequestBody UpdateDocumentTypeRequest request) {
        var command = new UpdateDocumentTypeCommand(new DocumentTypeId(id), request.code(), request.name());
        return ResponseEntity.ok(updateUseCase.execute(command));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(new DocumentTypeId(id));
        return ResponseEntity.noContent().build();
    }
}
