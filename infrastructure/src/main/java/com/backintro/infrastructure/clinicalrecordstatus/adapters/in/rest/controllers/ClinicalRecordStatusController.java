package com.backintro.infrastructure.clinicalrecordstatus.adapters.in.rest.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backintro.application.clinicalrecordstatus.command.RegisterClinicalRecordStatusCommand;
import com.backintro.application.clinicalrecordstatus.command.UpdateClinicalRecordStatusCommand;
import com.backintro.application.clinicalrecordstatus.dto.ClinicalRecordStatusResponse;
import com.backintro.application.clinicalrecordstatus.usecase.*;
import com.backintro.domain.clinicalrecordstatus.model.valueobject.ClinicalRecordStatusId;
import com.backintro.infrastructure.clinicalrecordstatus.adapters.in.rest.dtos.CreateClinicalRecordStatusRequest;
import com.backintro.infrastructure.clinicalrecordstatus.adapters.in.rest.dtos.UpdateClinicalRecordStatusRequest;

@RestController
@RequestMapping("/api/v1/clinical-record-statuses")
public class ClinicalRecordStatusController {

    private final RegisterClinicalRecordStatusUseCase registerUseCase;
    private final GetClinicalRecordStatusByIdUseCase getByIdUseCase;
    private final ListClinicalRecordStatusUseCase listUseCase;
    private final UpdateClinicalRecordStatusUseCase updateUseCase;
    private final DeleteClinicalRecordStatusUseCase deleteUseCase;

    public ClinicalRecordStatusController(
            RegisterClinicalRecordStatusUseCase registerUseCase,
            GetClinicalRecordStatusByIdUseCase getByIdUseCase,
            ListClinicalRecordStatusUseCase listUseCase,
            UpdateClinicalRecordStatusUseCase updateUseCase,
            DeleteClinicalRecordStatusUseCase deleteUseCase
    ) {
        this.registerUseCase = registerUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.listUseCase = listUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    @PostMapping
    public ResponseEntity<ClinicalRecordStatusResponse> create(@RequestBody CreateClinicalRecordStatusRequest request) {
        var command = new RegisterClinicalRecordStatusCommand(request.code(), request.name());
        var response = registerUseCase.execute(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<ClinicalRecordStatusResponse>> findAll() {
        return ResponseEntity.ok(listUseCase.execute());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClinicalRecordStatusResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(getByIdUseCase.execute(new ClinicalRecordStatusId(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClinicalRecordStatusResponse> update(@PathVariable UUID id, @RequestBody UpdateClinicalRecordStatusRequest request) {
        var command = new UpdateClinicalRecordStatusCommand(new ClinicalRecordStatusId(id), request.code(), request.name());
        return ResponseEntity.ok(updateUseCase.execute(command));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(new ClinicalRecordStatusId(id));
        return ResponseEntity.noContent().build();
    }
}
