package com.backintro.infrastructure.gender.adapters.in.rest.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backintro.application.gender.command.RegisterGenderCommand;
import com.backintro.application.gender.command.UpdateGenderCommand;
import com.backintro.application.gender.dto.GenderResponse;
import com.backintro.application.gender.usecase.*;
import com.backintro.domain.gender.model.valueobject.GenderId;
import com.backintro.infrastructure.gender.adapters.in.rest.dtos.CreateGenderRequest;
import com.backintro.infrastructure.gender.adapters.in.rest.dtos.UpdateGenderRequest;

@RestController
@RequestMapping("/api/v1/genders")
public class GenderController {

    private final RegisterGenderUseCase registerUseCase;
    private final GetGenderByIdUseCase getByIdUseCase;
    private final ListGenderUseCase listUseCase;
    private final UpdateGenderUseCase updateUseCase;
    private final DeleteGenderUseCase deleteUseCase;

    public GenderController(
            RegisterGenderUseCase registerUseCase,
            GetGenderByIdUseCase getByIdUseCase,
            ListGenderUseCase listUseCase,
            UpdateGenderUseCase updateUseCase,
            DeleteGenderUseCase deleteUseCase
    ) {
        this.registerUseCase = registerUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.listUseCase = listUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    @PostMapping
    public ResponseEntity<GenderResponse> create(@RequestBody CreateGenderRequest request) {
        var command = new RegisterGenderCommand(request.description());
        var response = registerUseCase.execute(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<GenderResponse>> findAll() {
        return ResponseEntity.ok(listUseCase.execute());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenderResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(getByIdUseCase.execute(new GenderId(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenderResponse> update(@PathVariable UUID id, @RequestBody UpdateGenderRequest request) {
        var command = new UpdateGenderCommand(new GenderId(id), request.description());
        return ResponseEntity.ok(updateUseCase.execute(command));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(new GenderId(id));
        return ResponseEntity.noContent().build();
    }
}
