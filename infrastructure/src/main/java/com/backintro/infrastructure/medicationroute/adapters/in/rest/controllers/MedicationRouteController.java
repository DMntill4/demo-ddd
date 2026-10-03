package com.backintro.infrastructure.medicationroute.adapters.in.rest.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backintro.application.medicationroute.command.RegisterMedicationRouteCommand;
import com.backintro.application.medicationroute.command.UpdateMedicationRouteCommand;
import com.backintro.application.medicationroute.dto.MedicationRouteResponse;
import com.backintro.application.medicationroute.usecase.*;
import com.backintro.domain.medicationroute.model.valueobject.MedicationRouteId;
import com.backintro.infrastructure.medicationroute.adapters.in.rest.dtos.CreateMedicationRouteRequest;
import com.backintro.infrastructure.medicationroute.adapters.in.rest.dtos.UpdateMedicationRouteRequest;

@RestController
@RequestMapping("/api/v1/medication-routes")
public class MedicationRouteController {

    private final RegisterMedicationRouteUseCase registerUseCase;
    private final GetMedicationRouteByIdUseCase getByIdUseCase;
    private final ListMedicationRouteUseCase listUseCase;
    private final UpdateMedicationRouteUseCase updateUseCase;
    private final DeleteMedicationRouteUseCase deleteUseCase;

    public MedicationRouteController(
            RegisterMedicationRouteUseCase registerUseCase,
            GetMedicationRouteByIdUseCase getByIdUseCase,
            ListMedicationRouteUseCase listUseCase,
            UpdateMedicationRouteUseCase updateUseCase,
            DeleteMedicationRouteUseCase deleteUseCase
    ) {
        this.registerUseCase = registerUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.listUseCase = listUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    @PostMapping
    public ResponseEntity<MedicationRouteResponse> create(@RequestBody CreateMedicationRouteRequest request) {
        var command = new RegisterMedicationRouteCommand(request.code(), request.name());
        var response = registerUseCase.execute(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<MedicationRouteResponse>> findAll() {
        return ResponseEntity.ok(listUseCase.execute());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicationRouteResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(getByIdUseCase.execute(new MedicationRouteId(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicationRouteResponse> update(@PathVariable UUID id, @RequestBody UpdateMedicationRouteRequest request) {
        var command = new UpdateMedicationRouteCommand(new MedicationRouteId(id), request.code(), request.name());
        return ResponseEntity.ok(updateUseCase.execute(command));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(new MedicationRouteId(id));
        return ResponseEntity.noContent().build();
    }
}
