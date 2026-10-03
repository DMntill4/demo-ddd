package com.backintro.application.risklevel.usecase;

import com.backintro.application.risklevel.exception.RiskLevelNotFoundApplicationException;
import com.backintro.domain.risklevel.model.aggregate.RiskLevel;
import com.backintro.domain.risklevel.model.valueobject.RiskLevelId;
import com.backintro.domain.risklevel.port.repository.RiskLevelRepository;

public class DeleteRiskLevelUseCase {
    private final RiskLevelRepository repository;

    public DeleteRiskLevelUseCase(RiskLevelRepository repository) {
        this.repository = repository;
    }

    public void execute(RiskLevelId id) {
        RiskLevel aggregate = repository.findById(id)
                .orElseThrow(() -> new RiskLevelNotFoundApplicationException(id));
        repository.delete(aggregate);
    }
}
