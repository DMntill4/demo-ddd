package com.backintro.infrastructure.patientallergy.adapters.in.rest.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backintro.application.patientallergy.command.RegisterPatientAllergyCommand;
import com.backintro.application.patientallergy.command.UpdatePatientAllergyCommand;
import com.backintro.application.patientallergy.dto.PatientAllergyResponse;
import com.backintro.application.patientallergy.usecase.*;
import com.backintro.domain.patientallergy.model.valueobject.PatientAllergyId;
import com.backintro.infrastructure.patientallergy.adapters.in.rest.dtos.CreatePatientAllergyRequest;
import com.backintro.infrastructure.patientallergy.adapters.in.rest.dtos.UpdatePatientAllergyRequest;

@RestController
@RequestMapping("/api/v1/patient-allergies")
public class PatientAllergyController {

    private final RegisterPatientAllergyUseCase registerUseCase;
    private final GetPatientAllergyByIdUseCase getByIdUseCase;
    private final ListPatientAllergyUseCase listUseCase;
    private final UpdatePatientAllergyUseCase updateUseCase;
    private final DeletePatientAllergyUseCase deleteUseCase;

    public PatientAllergyController(
            RegisterPatientAllergyUseCase registerUseCase,
            GetPatientAllergyByIdUseCase getByIdUseCase,
            ListPatientAllergyUseCase listUseCase,
            UpdatePatientAllergyUseCase updateUseCase,
            DeletePatientAllergyUseCase deleteUseCase
    ) {
        this.registerUseCase = registerUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.listUseCase = listUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    @PostMapping
    public ResponseEntity<PatientAllergyResponse> create(@RequestBody CreatePatientAllergyRequest request) {
        var command = new RegisterPatientAllergyCommand(request.patientId(), request.substance(), request.reaction(), request.severity(), request.recordedAt(), request.recordedBy());
        var response = registerUseCase.execute(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<PatientAllergyResponse>> findAll() {
        return ResponseEntity.ok(listUseCase.execute());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientAllergyResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(getByIdUseCase.execute(new PatientAllergyId(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientAllergyResponse> update(@PathVariable UUID id, @RequestBody UpdatePatientAllergyRequest request) {
        var command = new UpdatePatientAllergyCommand(new PatientAllergyId(id), request.patientId(), request.substance(), request.reaction(), request.severity(), request.recordedAt(), request.recordedBy());
        return ResponseEntity.ok(updateUseCase.execute(command));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(new PatientAllergyId(id));
        return ResponseEntity.noContent().build();
    }
}
