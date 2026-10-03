package com.backintro.infrastructure.country.adapters.out.persistence.mappers;

import com.backintro.domain.country.model.aggregate.Country;
import com.backintro.domain.country.model.valueobject.CountryId;
import com.backintro.infrastructure.country.adapters.out.persistence.entity.CountryJpaEntity;

public class CountryPersistenceMapper {
    public CountryJpaEntity toJpa(Country aggregate) {
        if (aggregate == null) return null;
        return new CountryJpaEntity(aggregate.id().value(), aggregate.nameCountry(), aggregate.codeCountry(), aggregate.description(), aggregate.isActive(), aggregate.telephonePrefix(), aggregate.createdAt(), aggregate.updatedAt());
    }

    public Country toDomain(CountryJpaEntity entityObj) {
        if (entityObj == null) return null;
        return Country.restore(new CountryId(entityObj.getId()), entityObj.getNameCountry(), entityObj.getCodeCountry(), entityObj.getDescription(), entityObj.getIsActive(), entityObj.getTelephonePrefix(), entityObj.getCreatedAt(), entityObj.getUpdatedAt());
    }
}
