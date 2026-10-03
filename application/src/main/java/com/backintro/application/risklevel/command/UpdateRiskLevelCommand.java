package com.backintro.application.risklevel.command;

import com.backintro.domain.risklevel.model.valueobject.RiskLevelId;

public record UpdateRiskLevelCommand(RiskLevelId id, String code, String name, Integer severity) {
}
