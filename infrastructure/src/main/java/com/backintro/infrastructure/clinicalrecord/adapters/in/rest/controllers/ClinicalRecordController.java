package com.backintro.infrastructure.clinicalrecord.adapters.in.rest.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backintro.application.clinicalrecord.command.RegisterClinicalRecordCommand;
import com.backintro.application.clinicalrecord.command.UpdateClinicalRecordCommand;
import com.backintro.application.clinicalrecord.dto.ClinicalRecordResponse;
import com.backintro.application.clinicalrecord.usecase.*;
import com.backintro.domain.clinicalrecord.model.valueobject.ClinicalRecordId;
import com.backintro.infrastructure.clinicalrecord.adapters.in.rest.dtos.CreateClinicalRecordRequest;
import com.backintro.infrastructure.clinicalrecord.adapters.in.rest.dtos.UpdateClinicalRecordRequest;

@RestController
@RequestMapping("/api/v1/clinical-records")
public class ClinicalRecordController {

    private final RegisterClinicalRecordUseCase registerUseCase;
    private final GetClinicalRecordByIdUseCase getByIdUseCase;
    private final ListClinicalRecordUseCase listUseCase;
    private final UpdateClinicalRecordUseCase updateUseCase;
    private final DeleteClinicalRecordUseCase deleteUseCase;

    public ClinicalRecordController(
            RegisterClinicalRecordUseCase registerUseCase,
            GetClinicalRecordByIdUseCase getByIdUseCase,
            ListClinicalRecordUseCase listUseCase,
            UpdateClinicalRecordUseCase updateUseCase,
            DeleteClinicalRecordUseCase deleteUseCase
    ) {
        this.registerUseCase = registerUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.listUseCase = listUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    @PostMapping
    public ResponseEntity<ClinicalRecordResponse> create(@RequestBody CreateClinicalRecordRequest request) {
        var command = new RegisterClinicalRecordCommand(request.patientId(), request.creationDate(), request.recordNumber(), request.openedAt(), request.closedAt(), request.statusId(), request.createdBy());
        var response = registerUseCase.execute(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<ClinicalRecordResponse>> findAll() {
        return ResponseEntity.ok(listUseCase.execute());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClinicalRecordResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(getByIdUseCase.execute(new ClinicalRecordId(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClinicalRecordResponse> update(@PathVariable UUID id, @RequestBody UpdateClinicalRecordRequest request) {
        var command = new UpdateClinicalRecordCommand(new ClinicalRecordId(id), request.patientId(), request.creationDate(), request.recordNumber(), request.openedAt(), request.closedAt(), request.statusId(), request.createdBy());
        return ResponseEntity.ok(updateUseCase.execute(command));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(new ClinicalRecordId(id));
        return ResponseEntity.noContent().build();
    }
}
