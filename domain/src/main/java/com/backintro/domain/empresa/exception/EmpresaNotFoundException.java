package com.backintro.domain.empresa.exception;

import com.backintro.domain.common.exception.DomainException;
import com.backintro.domain.empresa.model.valueobject.EmpresaId;

public class EmpresaNotFoundException extends DomainException {
    public EmpresaNotFoundException(EmpresaId id) {
        super("Empresa with id " + id.value() + " was not found.");
    }
}
