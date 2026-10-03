package com.backintro.infrastructure.mentalstatusexam.adapters.in.rest.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backintro.application.mentalstatusexam.command.RegisterMentalStatusExamCommand;
import com.backintro.application.mentalstatusexam.command.UpdateMentalStatusExamCommand;
import com.backintro.application.mentalstatusexam.dto.MentalStatusExamResponse;
import com.backintro.application.mentalstatusexam.usecase.*;
import com.backintro.domain.mentalstatusexam.model.valueobject.MentalStatusExamId;
import com.backintro.infrastructure.mentalstatusexam.adapters.in.rest.dtos.CreateMentalStatusExamRequest;
import com.backintro.infrastructure.mentalstatusexam.adapters.in.rest.dtos.UpdateMentalStatusExamRequest;

@RestController
@RequestMapping("/api/v1/mental-status-exams")
public class MentalStatusExamController {

    private final RegisterMentalStatusExamUseCase registerUseCase;
    private final GetMentalStatusExamByIdUseCase getByIdUseCase;
    private final ListMentalStatusExamUseCase listUseCase;
    private final UpdateMentalStatusExamUseCase updateUseCase;
    private final DeleteMentalStatusExamUseCase deleteUseCase;

    public MentalStatusExamController(
            RegisterMentalStatusExamUseCase registerUseCase,
            GetMentalStatusExamByIdUseCase getByIdUseCase,
            ListMentalStatusExamUseCase listUseCase,
            UpdateMentalStatusExamUseCase updateUseCase,
            DeleteMentalStatusExamUseCase deleteUseCase
    ) {
        this.registerUseCase = registerUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.listUseCase = listUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    @PostMapping
    public ResponseEntity<MentalStatusExamResponse> create(@RequestBody CreateMentalStatusExamRequest request) {
        var command = new RegisterMentalStatusExamCommand(request.encounterId(), request.appearance(), request.behavior(), request.attitude(), request.consciousness(), request.orientation(), request.attention(), request.memory(), request.speech(), request.mood(), request.affect(), request.thoughtProcess(), request.thoughtContent(), request.perception(), request.judgment(), request.insight(), request.psychomotorActivity(), request.observations(), request.createdBy());
        var response = registerUseCase.execute(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<MentalStatusExamResponse>> findAll() {
        return ResponseEntity.ok(listUseCase.execute());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MentalStatusExamResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(getByIdUseCase.execute(new MentalStatusExamId(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MentalStatusExamResponse> update(@PathVariable UUID id, @RequestBody UpdateMentalStatusExamRequest request) {
        var command = new UpdateMentalStatusExamCommand(new MentalStatusExamId(id), request.encounterId(), request.appearance(), request.behavior(), request.attitude(), request.consciousness(), request.orientation(), request.attention(), request.memory(), request.speech(), request.mood(), request.affect(), request.thoughtProcess(), request.thoughtContent(), request.perception(), request.judgment(), request.insight(), request.psychomotorActivity(), request.observations(), request.createdBy());
        return ResponseEntity.ok(updateUseCase.execute(command));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(new MentalStatusExamId(id));
        return ResponseEntity.noContent().build();
    }
}
