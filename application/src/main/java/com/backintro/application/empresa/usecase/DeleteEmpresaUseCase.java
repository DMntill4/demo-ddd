package com.backintro.application.empresa.usecase;

import com.backintro.application.empresa.exception.EmpresaNotFoundApplicationException;
import com.backintro.domain.empresa.model.aggregate.Empresa;
import com.backintro.domain.empresa.model.valueobject.EmpresaId;
import com.backintro.domain.empresa.port.repository.EmpresaRepository;

public class DeleteEmpresaUseCase {
    private final EmpresaRepository repository;

    public DeleteEmpresaUseCase(EmpresaRepository repository) {
        this.repository = repository;
    }

    public void execute(EmpresaId id) {
        Empresa aggregate = repository.findById(id)
                .orElseThrow(() -> new EmpresaNotFoundApplicationException(id));
        repository.delete(aggregate);
    }
}
