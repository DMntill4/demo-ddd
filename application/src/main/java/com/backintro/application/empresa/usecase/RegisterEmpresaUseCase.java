package com.backintro.application.empresa.usecase;

import com.backintro.application.empresa.command.RegisterEmpresaCommand;
import com.backintro.application.empresa.dto.EmpresaResponse;
import com.backintro.domain.empresa.model.aggregate.Empresa;
import com.backintro.domain.empresa.port.repository.EmpresaRepository;

public class RegisterEmpresaUseCase {
    private final EmpresaRepository repository;

    public RegisterEmpresaUseCase(EmpresaRepository repository) {
        this.repository = repository;
    }

    public EmpresaResponse execute(RegisterEmpresaCommand command) {
        Empresa aggregate = Empresa.register(command.name(), command.nit(), command.email(), command.phone(), command.address());
        Empresa saved = repository.save(aggregate);
        return EmpresaResponse.fromDomain(saved);
    }
}
