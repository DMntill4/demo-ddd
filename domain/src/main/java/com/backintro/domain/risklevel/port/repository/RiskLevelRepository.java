package com.backintro.domain.risklevel.port.repository;

import java.util.List;
import java.util.Optional;
import com.backintro.domain.risklevel.model.aggregate.RiskLevel;
import com.backintro.domain.risklevel.model.valueobject.RiskLevelId;

public interface RiskLevelRepository {
    RiskLevel save(RiskLevel aggregate);
    Optional<RiskLevel> findById(RiskLevelId id);
    List<RiskLevel> findAll();
    void delete(RiskLevel aggregate);
}
