package com.backintro.infrastructure.citymunicipality.adapters.in.rest.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backintro.application.citymunicipality.command.RegisterCityMunicipalityCommand;
import com.backintro.application.citymunicipality.command.UpdateCityMunicipalityCommand;
import com.backintro.application.citymunicipality.dto.CityMunicipalityResponse;
import com.backintro.application.citymunicipality.usecase.*;
import com.backintro.domain.citymunicipality.model.valueobject.CityMunicipalityId;
import com.backintro.infrastructure.citymunicipality.adapters.in.rest.dtos.CreateCityMunicipalityRequest;
import com.backintro.infrastructure.citymunicipality.adapters.in.rest.dtos.UpdateCityMunicipalityRequest;

@RestController
@RequestMapping("/api/v1/city-municipalities")
public class CityMunicipalityController {

    private final RegisterCityMunicipalityUseCase registerUseCase;
    private final GetCityMunicipalityByIdUseCase getByIdUseCase;
    private final ListCityMunicipalityUseCase listUseCase;
    private final UpdateCityMunicipalityUseCase updateUseCase;
    private final DeleteCityMunicipalityUseCase deleteUseCase;

    public CityMunicipalityController(
            RegisterCityMunicipalityUseCase registerUseCase,
            GetCityMunicipalityByIdUseCase getByIdUseCase,
            ListCityMunicipalityUseCase listUseCase,
            UpdateCityMunicipalityUseCase updateUseCase,
            DeleteCityMunicipalityUseCase deleteUseCase
    ) {
        this.registerUseCase = registerUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.listUseCase = listUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    @PostMapping
    public ResponseEntity<CityMunicipalityResponse> create(@RequestBody CreateCityMunicipalityRequest request) {
        var command = new RegisterCityMunicipalityCommand(request.nameCity(), request.codeCiti(), request.description(), request.regionId());
        var response = registerUseCase.execute(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<CityMunicipalityResponse>> findAll() {
        return ResponseEntity.ok(listUseCase.execute());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CityMunicipalityResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(getByIdUseCase.execute(new CityMunicipalityId(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CityMunicipalityResponse> update(@PathVariable UUID id, @RequestBody UpdateCityMunicipalityRequest request) {
        var command = new UpdateCityMunicipalityCommand(new CityMunicipalityId(id), request.nameCity(), request.codeCiti(), request.description(), request.regionId());
        return ResponseEntity.ok(updateUseCase.execute(command));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(new CityMunicipalityId(id));
        return ResponseEntity.noContent().build();
    }
}
