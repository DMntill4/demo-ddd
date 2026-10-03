package com.backintro.application.empresa.exception;

import com.backintro.application.common.exception.ApplicationException;
import com.backintro.domain.empresa.model.valueobject.EmpresaId;

public class EmpresaNotFoundApplicationException extends ApplicationException {
    public EmpresaNotFoundApplicationException(EmpresaId id) {
        super("Empresa with id " + id.value() + " was not found.");
    }
}
