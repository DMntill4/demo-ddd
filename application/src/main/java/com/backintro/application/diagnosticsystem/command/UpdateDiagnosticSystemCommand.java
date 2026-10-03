package com.backintro.application.diagnosticsystem.command;

import com.backintro.domain.diagnosticsystem.model.valueobject.DiagnosticSystemId;

public record UpdateDiagnosticSystemCommand(DiagnosticSystemId id, String code, String name, String version) {
}
