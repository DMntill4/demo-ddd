package com.backintro.application.empresa.usecase;

import com.backintro.application.empresa.command.UpdateEmpresaCommand;
import com.backintro.application.empresa.dto.EmpresaResponse;
import com.backintro.application.empresa.exception.EmpresaNotFoundApplicationException;
import com.backintro.domain.empresa.model.aggregate.Empresa;
import com.backintro.domain.empresa.port.repository.EmpresaRepository;

public class UpdateEmpresaUseCase {
    private final EmpresaRepository repository;

    public UpdateEmpresaUseCase(EmpresaRepository repository) {
        this.repository = repository;
    }

    public EmpresaResponse execute(UpdateEmpresaCommand command) {
        Empresa aggregate = repository.findById(command.id())
                .orElseThrow(() -> new EmpresaNotFoundApplicationException(command.id()));
        aggregate.update(command.name(), command.nit(), command.email(), command.phone(), command.address());
        Empresa saved = repository.save(aggregate);
        return EmpresaResponse.fromDomain(saved);
    }
}
