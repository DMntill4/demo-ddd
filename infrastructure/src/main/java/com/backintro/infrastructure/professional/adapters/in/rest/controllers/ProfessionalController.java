package com.backintro.infrastructure.professional.adapters.in.rest.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backintro.application.professional.command.RegisterProfessionalCommand;
import com.backintro.application.professional.command.UpdateProfessionalCommand;
import com.backintro.application.professional.dto.ProfessionalResponse;
import com.backintro.application.professional.usecase.*;
import com.backintro.domain.professional.model.valueobject.ProfessionalId;
import com.backintro.infrastructure.professional.adapters.in.rest.dtos.CreateProfessionalRequest;
import com.backintro.infrastructure.professional.adapters.in.rest.dtos.UpdateProfessionalRequest;

@RestController
@RequestMapping("/api/v1/professionals")
public class ProfessionalController {

    private final RegisterProfessionalUseCase registerUseCase;
    private final GetProfessionalByIdUseCase getByIdUseCase;
    private final ListProfessionalUseCase listUseCase;
    private final UpdateProfessionalUseCase updateUseCase;
    private final DeleteProfessionalUseCase deleteUseCase;

    public ProfessionalController(
            RegisterProfessionalUseCase registerUseCase,
            GetProfessionalByIdUseCase getByIdUseCase,
            ListProfessionalUseCase listUseCase,
            UpdateProfessionalUseCase updateUseCase,
            DeleteProfessionalUseCase deleteUseCase
    ) {
        this.registerUseCase = registerUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.listUseCase = listUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    @PostMapping
    public ResponseEntity<ProfessionalResponse> create(@RequestBody CreateProfessionalRequest request) {
        var command = new RegisterProfessionalCommand(request.documentTypeId(), request.documentNumber(), request.firstName(), request.lastName(), request.professionalTypeId(), request.licenseNumber(), request.cityId());
        var response = registerUseCase.execute(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<ProfessionalResponse>> findAll() {
        return ResponseEntity.ok(listUseCase.execute());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfessionalResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(getByIdUseCase.execute(new ProfessionalId(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfessionalResponse> update(@PathVariable UUID id, @RequestBody UpdateProfessionalRequest request) {
        var command = new UpdateProfessionalCommand(new ProfessionalId(id), request.documentTypeId(), request.documentNumber(), request.firstName(), request.lastName(), request.professionalTypeId(), request.licenseNumber(), request.cityId());
        return ResponseEntity.ok(updateUseCase.execute(command));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(new ProfessionalId(id));
        return ResponseEntity.noContent().build();
    }
}
