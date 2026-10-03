package com.backintro.domain.relationshiptype.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.relationshiptype.event.RelationshipTypeRegisteredEvent;
import com.backintro.domain.relationshiptype.event.RelationshipTypeUpdatedEvent;
import com.backintro.domain.relationshiptype.model.valueobject.RelationshipTypeId;

public class RelationshipType extends AggregateRoot {
    private final RelationshipTypeId id;
    private String description;

    private RelationshipType(
            RelationshipTypeId id, String description) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.description = description;
    }

    public static RelationshipType register(String description) {
        RelationshipTypeId id = RelationshipTypeId.generate();
        LocalDateTime now = LocalDateTime.now();
        RelationshipType aggregate = new RelationshipType(id, description);
        aggregate.recordEvent(new RelationshipTypeRegisteredEvent(id, now));
        return aggregate;
    }

    public static RelationshipType restore(
            RelationshipTypeId id, String description) {
        return new RelationshipType(id, description);
    }

    public void update(String description) {
        this.description = description;
        recordEvent(new RelationshipTypeUpdatedEvent(this.id, LocalDateTime.now()));
    }

    public RelationshipTypeId id() { return id; }
    public String description() { return description; }
}
