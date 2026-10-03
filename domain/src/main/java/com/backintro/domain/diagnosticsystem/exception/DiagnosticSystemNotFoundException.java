package com.backintro.domain.diagnosticsystem.exception;

import com.backintro.domain.common.exception.DomainException;
import com.backintro.domain.diagnosticsystem.model.valueobject.DiagnosticSystemId;

public class DiagnosticSystemNotFoundException extends DomainException {
    public DiagnosticSystemNotFoundException(DiagnosticSystemId id) {
        super("DiagnosticSystem with id " + id.value() + " was not found.");
    }
}
