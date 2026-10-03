package com.backintro.infrastructure.risklevel.adapters.in.rest.dtos;

public record UpdateRiskLevelRequest(String code, String name, Integer severity) {
}
