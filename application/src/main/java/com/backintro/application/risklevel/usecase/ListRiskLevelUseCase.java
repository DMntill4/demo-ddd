package com.backintro.application.risklevel.usecase;

import java.util.List;
import com.backintro.application.risklevel.dto.RiskLevelResponse;
import com.backintro.domain.risklevel.port.repository.RiskLevelRepository;

public class ListRiskLevelUseCase {
    private final RiskLevelRepository repository;

    public ListRiskLevelUseCase(RiskLevelRepository repository) {
        this.repository = repository;
    }

    public List<RiskLevelResponse> execute() {
        return repository.findAll()
                .stream()
                .map(RiskLevelResponse::fromDomain)
                .toList();
    }
}
