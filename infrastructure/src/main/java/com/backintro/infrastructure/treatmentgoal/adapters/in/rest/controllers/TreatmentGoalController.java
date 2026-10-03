package com.backintro.infrastructure.treatmentgoal.adapters.in.rest.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backintro.application.treatmentgoal.command.RegisterTreatmentGoalCommand;
import com.backintro.application.treatmentgoal.command.UpdateTreatmentGoalCommand;
import com.backintro.application.treatmentgoal.dto.TreatmentGoalResponse;
import com.backintro.application.treatmentgoal.usecase.*;
import com.backintro.domain.treatmentgoal.model.valueobject.TreatmentGoalId;
import com.backintro.infrastructure.treatmentgoal.adapters.in.rest.dtos.CreateTreatmentGoalRequest;
import com.backintro.infrastructure.treatmentgoal.adapters.in.rest.dtos.UpdateTreatmentGoalRequest;

@RestController
@RequestMapping("/api/v1/treatment-goals")
public class TreatmentGoalController {

    private final RegisterTreatmentGoalUseCase registerUseCase;
    private final GetTreatmentGoalByIdUseCase getByIdUseCase;
    private final ListTreatmentGoalUseCase listUseCase;
    private final UpdateTreatmentGoalUseCase updateUseCase;
    private final DeleteTreatmentGoalUseCase deleteUseCase;

    public TreatmentGoalController(
            RegisterTreatmentGoalUseCase registerUseCase,
            GetTreatmentGoalByIdUseCase getByIdUseCase,
            ListTreatmentGoalUseCase listUseCase,
            UpdateTreatmentGoalUseCase updateUseCase,
            DeleteTreatmentGoalUseCase deleteUseCase
    ) {
        this.registerUseCase = registerUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.listUseCase = listUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    @PostMapping
    public ResponseEntity<TreatmentGoalResponse> create(@RequestBody CreateTreatmentGoalRequest request) {
        var command = new RegisterTreatmentGoalCommand(request.treatmentPlanId(), request.description(), request.targetDate(), request.completedAt(), request.notes(), request.treatmentGoalStatusId());
        var response = registerUseCase.execute(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<TreatmentGoalResponse>> findAll() {
        return ResponseEntity.ok(listUseCase.execute());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TreatmentGoalResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(getByIdUseCase.execute(new TreatmentGoalId(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TreatmentGoalResponse> update(@PathVariable UUID id, @RequestBody UpdateTreatmentGoalRequest request) {
        var command = new UpdateTreatmentGoalCommand(new TreatmentGoalId(id), request.treatmentPlanId(), request.description(), request.targetDate(), request.completedAt(), request.notes(), request.treatmentGoalStatusId());
        return ResponseEntity.ok(updateUseCase.execute(command));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(new TreatmentGoalId(id));
        return ResponseEntity.noContent().build();
    }
}
