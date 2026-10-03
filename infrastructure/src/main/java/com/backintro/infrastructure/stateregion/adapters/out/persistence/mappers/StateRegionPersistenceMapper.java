package com.backintro.infrastructure.stateregion.adapters.out.persistence.mappers;

import com.backintro.domain.stateregion.model.aggregate.StateRegion;
import com.backintro.domain.stateregion.model.valueobject.StateRegionId;
import com.backintro.infrastructure.stateregion.adapters.out.persistence.entity.StateRegionJpaEntity;

public class StateRegionPersistenceMapper {
    public StateRegionJpaEntity toJpa(StateRegion aggregate) {
        if (aggregate == null) return null;
        return new StateRegionJpaEntity(aggregate.id().value(), aggregate.nameRegion(), aggregate.codeRegion(), aggregate.description(), aggregate.isActive(), aggregate.countryId(), aggregate.createdAt(), aggregate.updatedAt());
    }

    public StateRegion toDomain(StateRegionJpaEntity entityObj) {
        if (entityObj == null) return null;
        return StateRegion.restore(new StateRegionId(entityObj.getId()), entityObj.getNameRegion(), entityObj.getCodeRegion(), entityObj.getDescription(), entityObj.getIsActive(), entityObj.getCountryId(), entityObj.getCreatedAt(), entityObj.getUpdatedAt());
    }
}
