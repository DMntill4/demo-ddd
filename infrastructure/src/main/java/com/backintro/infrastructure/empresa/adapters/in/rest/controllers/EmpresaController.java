package com.backintro.infrastructure.empresa.adapters.in.rest.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backintro.application.empresa.command.RegisterEmpresaCommand;
import com.backintro.application.empresa.command.UpdateEmpresaCommand;
import com.backintro.application.empresa.dto.EmpresaResponse;
import com.backintro.application.empresa.usecase.*;
import com.backintro.domain.empresa.model.valueobject.EmpresaId;
import com.backintro.infrastructure.empresa.adapters.in.rest.dtos.CreateEmpresaRequest;
import com.backintro.infrastructure.empresa.adapters.in.rest.dtos.UpdateEmpresaRequest;

@RestController
@RequestMapping("/api/v1/empresas")
public class EmpresaController {

    private final RegisterEmpresaUseCase registerUseCase;
    private final GetEmpresaByIdUseCase getByIdUseCase;
    private final ListEmpresaUseCase listUseCase;
    private final UpdateEmpresaUseCase updateUseCase;
    private final DeleteEmpresaUseCase deleteUseCase;

    public EmpresaController(
            RegisterEmpresaUseCase registerUseCase,
            GetEmpresaByIdUseCase getByIdUseCase,
            ListEmpresaUseCase listUseCase,
            UpdateEmpresaUseCase updateUseCase,
            DeleteEmpresaUseCase deleteUseCase
    ) {
        this.registerUseCase = registerUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.listUseCase = listUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    @PostMapping
    public ResponseEntity<EmpresaResponse> create(@RequestBody CreateEmpresaRequest request) {
        var command = new RegisterEmpresaCommand(request.name(), request.nit(), request.email(), request.phone(), request.address());
        var response = registerUseCase.execute(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<EmpresaResponse>> findAll() {
        return ResponseEntity.ok(listUseCase.execute());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpresaResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(getByIdUseCase.execute(new EmpresaId(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpresaResponse> update(@PathVariable UUID id, @RequestBody UpdateEmpresaRequest request) {
        var command = new UpdateEmpresaCommand(new EmpresaId(id), request.name(), request.nit(), request.email(), request.phone(), request.address());
        return ResponseEntity.ok(updateUseCase.execute(command));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(new EmpresaId(id));
        return ResponseEntity.noContent().build();
    }
}
