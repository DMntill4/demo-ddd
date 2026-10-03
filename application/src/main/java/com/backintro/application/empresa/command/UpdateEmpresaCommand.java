package com.backintro.application.empresa.command;

import com.backintro.domain.empresa.model.valueobject.EmpresaId;

public record UpdateEmpresaCommand(EmpresaId id, String name, String nit, String email, String phone, String address) {
}
