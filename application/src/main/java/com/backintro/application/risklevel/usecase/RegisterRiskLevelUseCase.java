package com.backintro.application.risklevel.usecase;

import com.backintro.application.risklevel.command.RegisterRiskLevelCommand;
import com.backintro.application.risklevel.dto.RiskLevelResponse;
import com.backintro.domain.risklevel.model.aggregate.RiskLevel;
import com.backintro.domain.risklevel.port.repository.RiskLevelRepository;

public class RegisterRiskLevelUseCase {
    private final RiskLevelRepository repository;

    public RegisterRiskLevelUseCase(RiskLevelRepository repository) {
        this.repository = repository;
    }

    public RiskLevelResponse execute(RegisterRiskLevelCommand command) {
        RiskLevel aggregate = RiskLevel.register(command.code(), command.name(), command.severity());
        RiskLevel saved = repository.save(aggregate);
        return RiskLevelResponse.fromDomain(saved);
    }
}
