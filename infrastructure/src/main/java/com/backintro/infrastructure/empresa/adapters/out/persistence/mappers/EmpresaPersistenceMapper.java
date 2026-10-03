package com.backintro.infrastructure.empresa.adapters.out.persistence.mappers;

import com.backintro.domain.empresa.model.aggregate.Empresa;
import com.backintro.domain.empresa.model.valueobject.EmpresaId;
import com.backintro.infrastructure.empresa.adapters.out.persistence.entity.EmpresaJpaEntity;

public class EmpresaPersistenceMapper {
    public EmpresaJpaEntity toJpa(Empresa aggregate) {
        if (aggregate == null) return null;
        return new EmpresaJpaEntity(aggregate.id().value(), aggregate.name(), aggregate.nit(), aggregate.email(), aggregate.phone(), aggregate.address(), aggregate.active(), aggregate.createdAt(), aggregate.updatedAt());
    }

    public Empresa toDomain(EmpresaJpaEntity entityObj) {
        if (entityObj == null) return null;
        return Empresa.restore(new EmpresaId(entityObj.getId()), entityObj.getName(), entityObj.getNit(), entityObj.getEmail(), entityObj.getPhone(), entityObj.getAddress(), entityObj.getActive(), entityObj.getCreatedAt(), entityObj.getUpdatedAt());
    }
}
