package com.backintro.infrastructure.phonecontact.adapters.out.persistence.mappers;

import com.backintro.domain.phonecontact.model.aggregate.PhoneContact;
import com.backintro.domain.phonecontact.model.valueobject.PhoneContactId;
import com.backintro.infrastructure.phonecontact.adapters.out.persistence.entity.PhoneContactJpaEntity;

public class PhoneContactPersistenceMapper {
    public PhoneContactJpaEntity toJpa(PhoneContact aggregate) {
        if (aggregate == null) return null;
        return new PhoneContactJpaEntity(aggregate.id().value(), aggregate.contactId(), aggregate.phone(), aggregate.notes());
    }

    public PhoneContact toDomain(PhoneContactJpaEntity entityObj) {
        if (entityObj == null) return null;
        return PhoneContact.restore(new PhoneContactId(entityObj.getId()), entityObj.getContactId(), entityObj.getPhone(), entityObj.getNotes());
    }
}
