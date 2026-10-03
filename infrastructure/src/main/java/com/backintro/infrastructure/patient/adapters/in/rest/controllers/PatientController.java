package com.backintro.infrastructure.patient.adapters.in.rest.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backintro.application.patient.command.RegisterPatientCommand;
import com.backintro.application.patient.command.UpdatePatientCommand;
import com.backintro.application.patient.dto.PatientResponse;
import com.backintro.application.patient.usecase.*;
import com.backintro.domain.patient.model.valueobject.PatientId;
import com.backintro.infrastructure.patient.adapters.in.rest.dtos.CreatePatientRequest;
import com.backintro.infrastructure.patient.adapters.in.rest.dtos.UpdatePatientRequest;

@RestController
@RequestMapping("/api/v1/patients")
public class PatientController {

    private final RegisterPatientUseCase registerUseCase;
    private final GetPatientByIdUseCase getByIdUseCase;
    private final ListPatientUseCase listUseCase;
    private final UpdatePatientUseCase updateUseCase;
    private final DeletePatientUseCase deleteUseCase;

    public PatientController(
            RegisterPatientUseCase registerUseCase,
            GetPatientByIdUseCase getByIdUseCase,
            ListPatientUseCase listUseCase,
            UpdatePatientUseCase updateUseCase,
            DeletePatientUseCase deleteUseCase
    ) {
        this.registerUseCase = registerUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.listUseCase = listUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    @PostMapping
    public ResponseEntity<PatientResponse> create(@RequestBody CreatePatientRequest request) {
        var command = new RegisterPatientCommand(request.documentTypeId(), request.documentNumber(), request.firstName(), request.middleName(), request.lastName(), request.secondLastName(), request.birthDate(), request.biologicalSexId(), request.genderIdentity(), request.email(), request.phone(), request.address(), request.createdBy(), request.updatedBy(), request.cityId());
        var response = registerUseCase.execute(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<PatientResponse>> findAll() {
        return ResponseEntity.ok(listUseCase.execute());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(getByIdUseCase.execute(new PatientId(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientResponse> update(@PathVariable UUID id, @RequestBody UpdatePatientRequest request) {
        var command = new UpdatePatientCommand(new PatientId(id), request.documentTypeId(), request.documentNumber(), request.firstName(), request.middleName(), request.lastName(), request.secondLastName(), request.birthDate(), request.biologicalSexId(), request.genderIdentity(), request.email(), request.phone(), request.address(), request.createdBy(), request.updatedBy(), request.cityId());
        return ResponseEntity.ok(updateUseCase.execute(command));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(new PatientId(id));
        return ResponseEntity.noContent().build();
    }
}
