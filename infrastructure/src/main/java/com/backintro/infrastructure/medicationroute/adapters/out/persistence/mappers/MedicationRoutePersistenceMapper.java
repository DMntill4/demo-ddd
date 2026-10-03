package com.backintro.infrastructure.medicationroute.adapters.out.persistence.mappers;

import com.backintro.domain.medicationroute.model.aggregate.MedicationRoute;
import com.backintro.domain.medicationroute.model.valueobject.MedicationRouteId;
import com.backintro.infrastructure.medicationroute.adapters.out.persistence.entity.MedicationRouteJpaEntity;

public class MedicationRoutePersistenceMapper {
    public MedicationRouteJpaEntity toJpa(MedicationRoute aggregate) {
        if (aggregate == null) return null;
        return new MedicationRouteJpaEntity(aggregate.id().value(), aggregate.code(), aggregate.name(), aggregate.active(), aggregate.createdAt(), aggregate.updatedAt());
    }

    public MedicationRoute toDomain(MedicationRouteJpaEntity entityObj) {
        if (entityObj == null) return null;
        return MedicationRoute.restore(new MedicationRouteId(entityObj.getId()), entityObj.getCode(), entityObj.getName(), entityObj.getActive(), entityObj.getCreatedAt(), entityObj.getUpdatedAt());
    }
}
