package com.backintro.infrastructure.risklevel.adapters.in.rest.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backintro.application.risklevel.command.RegisterRiskLevelCommand;
import com.backintro.application.risklevel.command.UpdateRiskLevelCommand;
import com.backintro.application.risklevel.dto.RiskLevelResponse;
import com.backintro.application.risklevel.usecase.*;
import com.backintro.domain.risklevel.model.valueobject.RiskLevelId;
import com.backintro.infrastructure.risklevel.adapters.in.rest.dtos.CreateRiskLevelRequest;
import com.backintro.infrastructure.risklevel.adapters.in.rest.dtos.UpdateRiskLevelRequest;

@RestController
@RequestMapping("/api/v1/risk-levels")
public class RiskLevelController {

    private final RegisterRiskLevelUseCase registerUseCase;
    private final GetRiskLevelByIdUseCase getByIdUseCase;
    private final ListRiskLevelUseCase listUseCase;
    private final UpdateRiskLevelUseCase updateUseCase;
    private final DeleteRiskLevelUseCase deleteUseCase;

    public RiskLevelController(
            RegisterRiskLevelUseCase registerUseCase,
            GetRiskLevelByIdUseCase getByIdUseCase,
            ListRiskLevelUseCase listUseCase,
            UpdateRiskLevelUseCase updateUseCase,
            DeleteRiskLevelUseCase deleteUseCase
    ) {
        this.registerUseCase = registerUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.listUseCase = listUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    @PostMapping
    public ResponseEntity<RiskLevelResponse> create(@RequestBody CreateRiskLevelRequest request) {
        var command = new RegisterRiskLevelCommand(request.code(), request.name(), request.severity());
        var response = registerUseCase.execute(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<RiskLevelResponse>> findAll() {
        return ResponseEntity.ok(listUseCase.execute());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RiskLevelResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(getByIdUseCase.execute(new RiskLevelId(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RiskLevelResponse> update(@PathVariable UUID id, @RequestBody UpdateRiskLevelRequest request) {
        var command = new UpdateRiskLevelCommand(new RiskLevelId(id), request.code(), request.name(), request.severity());
        return ResponseEntity.ok(updateUseCase.execute(command));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(new RiskLevelId(id));
        return ResponseEntity.noContent().build();
    }
}
