package com.backintro.application.empresa.usecase;

import com.backintro.application.empresa.dto.EmpresaResponse;
import com.backintro.application.empresa.exception.EmpresaNotFoundApplicationException;
import com.backintro.domain.empresa.model.valueobject.EmpresaId;
import com.backintro.domain.empresa.port.repository.EmpresaRepository;

public class GetEmpresaByIdUseCase {
    private final EmpresaRepository repository;

    public GetEmpresaByIdUseCase(EmpresaRepository repository) {
        this.repository = repository;
    }

    public EmpresaResponse execute(EmpresaId id) {
        return repository.findById(id)
                .map(EmpresaResponse::fromDomain)
                .orElseThrow(() -> new EmpresaNotFoundApplicationException(id));
    }
}
