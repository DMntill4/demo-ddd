package com.backintro.infrastructure.professionalstudy.adapters.in.rest.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backintro.application.professionalstudy.command.RegisterProfessionalStudyCommand;
import com.backintro.application.professionalstudy.command.UpdateProfessionalStudyCommand;
import com.backintro.application.professionalstudy.dto.ProfessionalStudyResponse;
import com.backintro.application.professionalstudy.usecase.*;
import com.backintro.domain.professionalstudy.model.valueobject.ProfessionalStudyId;
import com.backintro.infrastructure.professionalstudy.adapters.in.rest.dtos.CreateProfessionalStudyRequest;
import com.backintro.infrastructure.professionalstudy.adapters.in.rest.dtos.UpdateProfessionalStudyRequest;

@RestController
@RequestMapping("/api/v1/professional-studies")
public class ProfessionalStudyController {

    private final RegisterProfessionalStudyUseCase registerUseCase;
    private final GetProfessionalStudyByIdUseCase getByIdUseCase;
    private final ListProfessionalStudyUseCase listUseCase;
    private final UpdateProfessionalStudyUseCase updateUseCase;
    private final DeleteProfessionalStudyUseCase deleteUseCase;

    public ProfessionalStudyController(
            RegisterProfessionalStudyUseCase registerUseCase,
            GetProfessionalStudyByIdUseCase getByIdUseCase,
            ListProfessionalStudyUseCase listUseCase,
            UpdateProfessionalStudyUseCase updateUseCase,
            DeleteProfessionalStudyUseCase deleteUseCase
    ) {
        this.registerUseCase = registerUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.listUseCase = listUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    @PostMapping
    public ResponseEntity<ProfessionalStudyResponse> create(@RequestBody CreateProfessionalStudyRequest request) {
        var command = new RegisterProfessionalStudyCommand(request.studyId(), request.professionalId(), request.title(), request.university(), request.isValid(), request.resolutionNumber(), request.countryId());
        var response = registerUseCase.execute(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<ProfessionalStudyResponse>> findAll() {
        return ResponseEntity.ok(listUseCase.execute());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfessionalStudyResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(getByIdUseCase.execute(new ProfessionalStudyId(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfessionalStudyResponse> update(@PathVariable UUID id, @RequestBody UpdateProfessionalStudyRequest request) {
        var command = new UpdateProfessionalStudyCommand(new ProfessionalStudyId(id), request.studyId(), request.professionalId(), request.title(), request.university(), request.isValid(), request.resolutionNumber(), request.countryId());
        return ResponseEntity.ok(updateUseCase.execute(command));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(new ProfessionalStudyId(id));
        return ResponseEntity.noContent().build();
    }
}
