package com.backintro.application.risklevel.command;

public record RegisterRiskLevelCommand(String code, String name, Integer severity) {
}
