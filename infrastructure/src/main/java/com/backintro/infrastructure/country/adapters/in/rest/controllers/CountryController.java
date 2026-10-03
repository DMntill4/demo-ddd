package com.backintro.infrastructure.country.adapters.in.rest.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backintro.application.country.command.RegisterCountryCommand;
import com.backintro.application.country.command.UpdateCountryCommand;
import com.backintro.application.country.dto.CountryResponse;
import com.backintro.application.country.usecase.*;
import com.backintro.domain.country.model.valueobject.CountryId;
import com.backintro.infrastructure.country.adapters.in.rest.dtos.CreateCountryRequest;
import com.backintro.infrastructure.country.adapters.in.rest.dtos.UpdateCountryRequest;

@RestController
@RequestMapping("/api/v1/countries")
public class CountryController {

    private final RegisterCountryUseCase registerUseCase;
    private final GetCountryByIdUseCase getByIdUseCase;
    private final ListCountryUseCase listUseCase;
    private final UpdateCountryUseCase updateUseCase;
    private final DeleteCountryUseCase deleteUseCase;

    public CountryController(
            RegisterCountryUseCase registerUseCase,
            GetCountryByIdUseCase getByIdUseCase,
            ListCountryUseCase listUseCase,
            UpdateCountryUseCase updateUseCase,
            DeleteCountryUseCase deleteUseCase
    ) {
        this.registerUseCase = registerUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.listUseCase = listUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    @PostMapping
    public ResponseEntity<CountryResponse> create(@RequestBody CreateCountryRequest request) {
        var command = new RegisterCountryCommand(request.nameCountry(), request.codeCountry(), request.description(), request.telephonePrefix());
        var response = registerUseCase.execute(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<CountryResponse>> findAll() {
        return ResponseEntity.ok(listUseCase.execute());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CountryResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(getByIdUseCase.execute(new CountryId(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CountryResponse> update(@PathVariable UUID id, @RequestBody UpdateCountryRequest request) {
        var command = new UpdateCountryCommand(new CountryId(id), request.nameCountry(), request.codeCountry(), request.description(), request.telephonePrefix());
        return ResponseEntity.ok(updateUseCase.execute(command));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(new CountryId(id));
        return ResponseEntity.noContent().build();
    }
}
