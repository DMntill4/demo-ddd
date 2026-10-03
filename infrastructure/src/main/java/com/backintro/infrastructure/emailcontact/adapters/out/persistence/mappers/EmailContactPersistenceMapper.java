package com.backintro.infrastructure.emailcontact.adapters.out.persistence.mappers;

import com.backintro.domain.emailcontact.model.aggregate.EmailContact;
import com.backintro.domain.emailcontact.model.valueobject.EmailContactId;
import com.backintro.infrastructure.emailcontact.adapters.out.persistence.entity.EmailContactJpaEntity;

public class EmailContactPersistenceMapper {
    public EmailContactJpaEntity toJpa(EmailContact aggregate) {
        if (aggregate == null) return null;
        return new EmailContactJpaEntity(aggregate.id().value(), aggregate.contactId(), aggregate.email(), aggregate.notes(), aggregate.createdAt(), aggregate.updatedAt());
    }

    public EmailContact toDomain(EmailContactJpaEntity entityObj) {
        if (entityObj == null) return null;
        return EmailContact.restore(new EmailContactId(entityObj.getId()), entityObj.getContactId(), entityObj.getEmail(), entityObj.getNotes(), entityObj.getCreatedAt(), entityObj.getUpdatedAt());
    }
}
