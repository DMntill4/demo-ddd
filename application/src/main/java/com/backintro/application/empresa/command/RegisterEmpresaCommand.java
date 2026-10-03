package com.backintro.application.empresa.command;

public record RegisterEmpresaCommand(String name, String nit, String email, String phone, String address) {
}
