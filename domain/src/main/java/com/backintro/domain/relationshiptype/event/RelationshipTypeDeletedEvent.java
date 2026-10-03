package com.backintro.domain.relationshiptype.event;

import java.time.LocalDateTime;
import com.backintro.domain.common.event.DomainEvent;
import com.backintro.domain.relationshiptype.model.valueobject.RelationshipTypeId;

public record RelationshipTypeDeletedEvent(
        RelationshipTypeId id,
        LocalDateTime occurredOn
) implements DomainEvent {
}
