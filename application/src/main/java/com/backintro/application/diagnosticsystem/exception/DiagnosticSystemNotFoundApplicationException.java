package com.backintro.application.diagnosticsystem.exception;

import com.backintro.application.common.exception.ApplicationException;
import com.backintro.domain.diagnosticsystem.model.valueobject.DiagnosticSystemId;

public class DiagnosticSystemNotFoundApplicationException extends ApplicationException {
    public DiagnosticSystemNotFoundApplicationException(DiagnosticSystemId id) {
        super("DiagnosticSystem with id " + id.value() + " was not found.");
    }
}
