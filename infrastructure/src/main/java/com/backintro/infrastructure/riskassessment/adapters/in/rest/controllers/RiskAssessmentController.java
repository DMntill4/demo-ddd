package com.backintro.infrastructure.riskassessment.adapters.in.rest.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backintro.application.riskassessment.command.RegisterRiskAssessmentCommand;
import com.backintro.application.riskassessment.command.UpdateRiskAssessmentCommand;
import com.backintro.application.riskassessment.dto.RiskAssessmentResponse;
import com.backintro.application.riskassessment.usecase.*;
import com.backintro.domain.riskassessment.model.valueobject.RiskAssessmentId;
import com.backintro.infrastructure.riskassessment.adapters.in.rest.dtos.CreateRiskAssessmentRequest;
import com.backintro.infrastructure.riskassessment.adapters.in.rest.dtos.UpdateRiskAssessmentRequest;

@RestController
@RequestMapping("/api/v1/risk-assessments")
public class RiskAssessmentController {

    private final RegisterRiskAssessmentUseCase registerUseCase;
    private final GetRiskAssessmentByIdUseCase getByIdUseCase;
    private final ListRiskAssessmentUseCase listUseCase;
    private final UpdateRiskAssessmentUseCase updateUseCase;
    private final DeleteRiskAssessmentUseCase deleteUseCase;

    public RiskAssessmentController(
            RegisterRiskAssessmentUseCase registerUseCase,
            GetRiskAssessmentByIdUseCase getByIdUseCase,
            ListRiskAssessmentUseCase listUseCase,
            UpdateRiskAssessmentUseCase updateUseCase,
            DeleteRiskAssessmentUseCase deleteUseCase
    ) {
        this.registerUseCase = registerUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.listUseCase = listUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    @PostMapping
    public ResponseEntity<RiskAssessmentResponse> create(@RequestBody CreateRiskAssessmentRequest request) {
        var command = new RegisterRiskAssessmentCommand(request.encounterId(), request.riskLevelId(), request.suicidalIdeation(), request.suicidePlan(), request.suicideIntent(), request.selfHarm(), request.harmToOthers(), request.protectiveFactors(), request.riskFactors(), request.clinicalActions(), request.observations(), request.assessedAt(), request.assessedBy());
        var response = registerUseCase.execute(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<RiskAssessmentResponse>> findAll() {
        return ResponseEntity.ok(listUseCase.execute());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RiskAssessmentResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(getByIdUseCase.execute(new RiskAssessmentId(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RiskAssessmentResponse> update(@PathVariable UUID id, @RequestBody UpdateRiskAssessmentRequest request) {
        var command = new UpdateRiskAssessmentCommand(new RiskAssessmentId(id), request.encounterId(), request.riskLevelId(), request.suicidalIdeation(), request.suicidePlan(), request.suicideIntent(), request.selfHarm(), request.harmToOthers(), request.protectiveFactors(), request.riskFactors(), request.clinicalActions(), request.observations(), request.assessedAt(), request.assessedBy());
        return ResponseEntity.ok(updateUseCase.execute(command));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(new RiskAssessmentId(id));
        return ResponseEntity.noContent().build();
    }
}
