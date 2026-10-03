package com.backintro.infrastructure.citymunicipality.adapters.out.persistence.mappers;

import com.backintro.domain.citymunicipality.model.aggregate.CityMunicipality;
import com.backintro.domain.citymunicipality.model.valueobject.CityMunicipalityId;
import com.backintro.infrastructure.citymunicipality.adapters.out.persistence.entity.CityMunicipalityJpaEntity;

public class CityMunicipalityPersistenceMapper {
    public CityMunicipalityJpaEntity toJpa(CityMunicipality aggregate) {
        if (aggregate == null) return null;
        return new CityMunicipalityJpaEntity(aggregate.id().value(), aggregate.nameCity(), aggregate.codeCiti(), aggregate.description(), aggregate.isActive(), aggregate.regionId(), aggregate.createdAt(), aggregate.updatedAt());
    }

    public CityMunicipality toDomain(CityMunicipalityJpaEntity entityObj) {
        if (entityObj == null) return null;
        return CityMunicipality.restore(new CityMunicipalityId(entityObj.getId()), entityObj.getNameCity(), entityObj.getCodeCiti(), entityObj.getDescription(), entityObj.getIsActive(), entityObj.getRegionId(), entityObj.getCreatedAt(), entityObj.getUpdatedAt());
    }
}
