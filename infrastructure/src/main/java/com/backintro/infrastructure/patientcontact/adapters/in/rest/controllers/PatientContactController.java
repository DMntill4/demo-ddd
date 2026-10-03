package com.backintro.infrastructure.patientcontact.adapters.in.rest.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backintro.application.patientcontact.command.RegisterPatientContactCommand;
import com.backintro.application.patientcontact.command.UpdatePatientContactCommand;
import com.backintro.application.patientcontact.dto.PatientContactResponse;
import com.backintro.application.patientcontact.usecase.*;
import com.backintro.domain.patientcontact.model.valueobject.PatientContactId;
import com.backintro.infrastructure.patientcontact.adapters.in.rest.dtos.CreatePatientContactRequest;
import com.backintro.infrastructure.patientcontact.adapters.in.rest.dtos.UpdatePatientContactRequest;

@RestController
@RequestMapping("/api/v1/patient-contacts")
public class PatientContactController {

    private final RegisterPatientContactUseCase registerUseCase;
    private final GetPatientContactByIdUseCase getByIdUseCase;
    private final ListPatientContactUseCase listUseCase;
    private final UpdatePatientContactUseCase updateUseCase;
    private final DeletePatientContactUseCase deleteUseCase;

    public PatientContactController(
            RegisterPatientContactUseCase registerUseCase,
            GetPatientContactByIdUseCase getByIdUseCase,
            ListPatientContactUseCase listUseCase,
            UpdatePatientContactUseCase updateUseCase,
            DeletePatientContactUseCase deleteUseCase
    ) {
        this.registerUseCase = registerUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.listUseCase = listUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    @PostMapping
    public ResponseEntity<PatientContactResponse> create(@RequestBody CreatePatientContactRequest request) {
        var command = new RegisterPatientContactCommand(request.contactId(), request.patientId(), request.isPrimaryContact(), request.isEmergencyContact(), request.relationshipTypeId());
        var response = registerUseCase.execute(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<PatientContactResponse>> findAll() {
        return ResponseEntity.ok(listUseCase.execute());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientContactResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(getByIdUseCase.execute(new PatientContactId(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientContactResponse> update(@PathVariable UUID id, @RequestBody UpdatePatientContactRequest request) {
        var command = new UpdatePatientContactCommand(new PatientContactId(id), request.contactId(), request.patientId(), request.isPrimaryContact(), request.isEmergencyContact(), request.relationshipTypeId());
        return ResponseEntity.ok(updateUseCase.execute(command));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(new PatientContactId(id));
        return ResponseEntity.noContent().build();
    }
}
