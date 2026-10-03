package com.backintro.domain.documenttype.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.documenttype.event.DocumentTypeRegisteredEvent;
import com.backintro.domain.documenttype.event.DocumentTypeUpdatedEvent;
import com.backintro.domain.documenttype.model.valueobject.DocumentTypeId;

public class DocumentType extends AggregateRoot {
    private final DocumentTypeId id;
    private String code;
    private String name;
    private boolean active;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private DocumentType(
            DocumentTypeId id, String code, String name, boolean active, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.code = code;
        this.name = name;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static DocumentType register(String code, String name) {
        DocumentTypeId id = DocumentTypeId.generate();
        LocalDateTime now = LocalDateTime.now();
        DocumentType aggregate = new DocumentType(id, code, name, true, now, now);
        aggregate.recordEvent(new DocumentTypeRegisteredEvent(id, now));
        return aggregate;
    }

    public static DocumentType restore(
            DocumentTypeId id, String code, String name, boolean active, LocalDateTime createdAt, LocalDateTime updatedAt) {
        return new DocumentType(id, code, name, active, createdAt, updatedAt);
    }

    public void update(String code, String name) {
        this.code = code;
        this.name = name;
        this.updatedAt = LocalDateTime.now();
        recordEvent(new DocumentTypeUpdatedEvent(this.id, LocalDateTime.now()));
    }

    public DocumentTypeId id() { return id; }
    public String code() { return code; }
    public String name() { return name; }
    public boolean active() { return active; }
    public LocalDateTime createdAt() { return createdAt; }
    public LocalDateTime updatedAt() { return updatedAt; }
}
