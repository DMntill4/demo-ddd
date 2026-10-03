package com.backintro.infrastructure.treatmentplan.adapters.in.rest.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backintro.application.treatmentplan.command.RegisterTreatmentPlanCommand;
import com.backintro.application.treatmentplan.command.UpdateTreatmentPlanCommand;
import com.backintro.application.treatmentplan.dto.TreatmentPlanResponse;
import com.backintro.application.treatmentplan.usecase.*;
import com.backintro.domain.treatmentplan.model.valueobject.TreatmentPlanId;
import com.backintro.infrastructure.treatmentplan.adapters.in.rest.dtos.CreateTreatmentPlanRequest;
import com.backintro.infrastructure.treatmentplan.adapters.in.rest.dtos.UpdateTreatmentPlanRequest;

@RestController
@RequestMapping("/api/v1/treatment-plans")
public class TreatmentPlanController {

    private final RegisterTreatmentPlanUseCase registerUseCase;
    private final GetTreatmentPlanByIdUseCase getByIdUseCase;
    private final ListTreatmentPlanUseCase listUseCase;
    private final UpdateTreatmentPlanUseCase updateUseCase;
    private final DeleteTreatmentPlanUseCase deleteUseCase;

    public TreatmentPlanController(
            RegisterTreatmentPlanUseCase registerUseCase,
            GetTreatmentPlanByIdUseCase getByIdUseCase,
            ListTreatmentPlanUseCase listUseCase,
            UpdateTreatmentPlanUseCase updateUseCase,
            DeleteTreatmentPlanUseCase deleteUseCase
    ) {
        this.registerUseCase = registerUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.listUseCase = listUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    @PostMapping
    public ResponseEntity<TreatmentPlanResponse> create(@RequestBody CreateTreatmentPlanRequest request) {
        var command = new RegisterTreatmentPlanCommand(request.encounterId(), request.professionalId(), request.title(), request.description(), request.startDate(), request.endDate(), request.treatmentStatusId());
        var response = registerUseCase.execute(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<TreatmentPlanResponse>> findAll() {
        return ResponseEntity.ok(listUseCase.execute());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TreatmentPlanResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(getByIdUseCase.execute(new TreatmentPlanId(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TreatmentPlanResponse> update(@PathVariable UUID id, @RequestBody UpdateTreatmentPlanRequest request) {
        var command = new UpdateTreatmentPlanCommand(new TreatmentPlanId(id), request.encounterId(), request.professionalId(), request.title(), request.description(), request.startDate(), request.endDate(), request.treatmentStatusId());
        return ResponseEntity.ok(updateUseCase.execute(command));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(new TreatmentPlanId(id));
        return ResponseEntity.noContent().build();
    }
}
