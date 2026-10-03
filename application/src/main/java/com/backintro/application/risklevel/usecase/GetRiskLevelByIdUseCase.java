package com.backintro.application.risklevel.usecase;

import com.backintro.application.risklevel.dto.RiskLevelResponse;
import com.backintro.application.risklevel.exception.RiskLevelNotFoundApplicationException;
import com.backintro.domain.risklevel.model.valueobject.RiskLevelId;
import com.backintro.domain.risklevel.port.repository.RiskLevelRepository;

public class GetRiskLevelByIdUseCase {
    private final RiskLevelRepository repository;

    public GetRiskLevelByIdUseCase(RiskLevelRepository repository) {
        this.repository = repository;
    }

    public RiskLevelResponse execute(RiskLevelId id) {
        return repository.findById(id)
                .map(RiskLevelResponse::fromDomain)
                .orElseThrow(() -> new RiskLevelNotFoundApplicationException(id));
    }
}
