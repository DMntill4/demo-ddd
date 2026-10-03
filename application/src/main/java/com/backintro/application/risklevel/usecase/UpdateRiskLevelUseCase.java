package com.backintro.application.risklevel.usecase;

import com.backintro.application.risklevel.command.UpdateRiskLevelCommand;
import com.backintro.application.risklevel.dto.RiskLevelResponse;
import com.backintro.application.risklevel.exception.RiskLevelNotFoundApplicationException;
import com.backintro.domain.risklevel.model.aggregate.RiskLevel;
import com.backintro.domain.risklevel.port.repository.RiskLevelRepository;

public class UpdateRiskLevelUseCase {
    private final RiskLevelRepository repository;

    public UpdateRiskLevelUseCase(RiskLevelRepository repository) {
        this.repository = repository;
    }

    public RiskLevelResponse execute(UpdateRiskLevelCommand command) {
        RiskLevel aggregate = repository.findById(command.id())
                .orElseThrow(() -> new RiskLevelNotFoundApplicationException(command.id()));
        aggregate.update(command.code(), command.name(), command.severity());
        RiskLevel saved = repository.save(aggregate);
        return RiskLevelResponse.fromDomain(saved);
    }
}
