package com.backintro.infrastructure.treatmentgoalstatuss.adapters.in.rest.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backintro.application.treatmentgoalstatuss.command.RegisterTreatmentGoalStatusCommand;
import com.backintro.application.treatmentgoalstatuss.command.UpdateTreatmentGoalStatusCommand;
import com.backintro.application.treatmentgoalstatuss.dto.TreatmentGoalStatusResponse;
import com.backintro.application.treatmentgoalstatuss.usecase.*;
import com.backintro.domain.treatmentgoalstatuss.model.valueobject.TreatmentGoalStatusId;
import com.backintro.infrastructure.treatmentgoalstatuss.adapters.in.rest.dtos.CreateTreatmentGoalStatusRequest;
import com.backintro.infrastructure.treatmentgoalstatuss.adapters.in.rest.dtos.UpdateTreatmentGoalStatusRequest;

@RestController
@RequestMapping("/api/v1/treatment-goal-statusses")
public class TreatmentGoalStatusController {

    private final RegisterTreatmentGoalStatusUseCase registerUseCase;
    private final GetTreatmentGoalStatusByIdUseCase getByIdUseCase;
    private final ListTreatmentGoalStatusUseCase listUseCase;
    private final UpdateTreatmentGoalStatusUseCase updateUseCase;
    private final DeleteTreatmentGoalStatusUseCase deleteUseCase;

    public TreatmentGoalStatusController(
            RegisterTreatmentGoalStatusUseCase registerUseCase,
            GetTreatmentGoalStatusByIdUseCase getByIdUseCase,
            ListTreatmentGoalStatusUseCase listUseCase,
            UpdateTreatmentGoalStatusUseCase updateUseCase,
            DeleteTreatmentGoalStatusUseCase deleteUseCase
    ) {
        this.registerUseCase = registerUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.listUseCase = listUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    @PostMapping
    public ResponseEntity<TreatmentGoalStatusResponse> create(@RequestBody CreateTreatmentGoalStatusRequest request) {
        var command = new RegisterTreatmentGoalStatusCommand(request.code(), request.name());
        var response = registerUseCase.execute(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<TreatmentGoalStatusResponse>> findAll() {
        return ResponseEntity.ok(listUseCase.execute());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TreatmentGoalStatusResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(getByIdUseCase.execute(new TreatmentGoalStatusId(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TreatmentGoalStatusResponse> update(@PathVariable UUID id, @RequestBody UpdateTreatmentGoalStatusRequest request) {
        var command = new UpdateTreatmentGoalStatusCommand(new TreatmentGoalStatusId(id), request.code(), request.name());
        return ResponseEntity.ok(updateUseCase.execute(command));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(new TreatmentGoalStatusId(id));
        return ResponseEntity.noContent().build();
    }
}
