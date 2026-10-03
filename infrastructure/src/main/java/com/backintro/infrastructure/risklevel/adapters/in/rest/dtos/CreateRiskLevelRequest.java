package com.backintro.infrastructure.risklevel.adapters.in.rest.dtos;

public record CreateRiskLevelRequest(String code, String name, Integer severity) {
}
