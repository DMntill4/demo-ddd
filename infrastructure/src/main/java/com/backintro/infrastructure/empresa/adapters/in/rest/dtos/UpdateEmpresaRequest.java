package com.backintro.infrastructure.empresa.adapters.in.rest.dtos;

public record UpdateEmpresaRequest(String name, String nit, String email, String phone, String address) {
}
