package com.backintro.infrastructure.relationshiptype.adapters.out.persistence.entity;

import java.util.UUID;
import jakarta.persistence.*;

@Entity
@Table(name = "relationship_types")
public class RelationshipTypeJpaEntity {
    @Id
    private UUID id;

    @Column(name = "description", nullable = false)
    private String description;

    public RelationshipTypeJpaEntity() {
    }

    public RelationshipTypeJpaEntity(UUID id, String description) {
        this.id = id;
        this.description = description;
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
