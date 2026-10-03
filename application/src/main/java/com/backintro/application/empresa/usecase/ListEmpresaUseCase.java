package com.backintro.application.empresa.usecase;

import java.util.List;
import com.backintro.application.empresa.dto.EmpresaResponse;
import com.backintro.domain.empresa.port.repository.EmpresaRepository;

public class ListEmpresaUseCase {
    private final EmpresaRepository repository;

    public ListEmpresaUseCase(EmpresaRepository repository) {
        this.repository = repository;
    }

    public List<EmpresaResponse> execute() {
        return repository.findAll()
                .stream()
                .map(EmpresaResponse::fromDomain)
                .toList();
    }
}
