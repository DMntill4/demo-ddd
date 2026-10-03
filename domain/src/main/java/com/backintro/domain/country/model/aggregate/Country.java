package com.backintro.domain.country.model.aggregate;

import java.time.LocalDateTime;
import java.util.Objects;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.country.event.CountryRegisteredEvent;
import com.backintro.domain.country.event.CountryUpdatedEvent;
import com.backintro.domain.country.model.valueobject.CountryId;

public class Country extends AggregateRoot {
    private final CountryId id;
    private String nameCountry;
    private String codeCountry;
    private String description;
    private boolean isActive;
    private String telephonePrefix;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private Country(
            CountryId id, String nameCountry, String codeCountry, String description, boolean isActive, String telephonePrefix, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.nameCountry = nameCountry;
        this.codeCountry = codeCountry;
        this.description = description;
        this.isActive = isActive;
        this.telephonePrefix = telephonePrefix;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static Country register(String nameCountry, String codeCountry, String description, String telephonePrefix) {
        CountryId id = CountryId.generate();
        LocalDateTime now = LocalDateTime.now();
        Country aggregate = new Country(id, nameCountry, codeCountry, description, true, telephonePrefix, now, now);
        aggregate.recordEvent(new CountryRegisteredEvent(id, now));
        return aggregate;
    }

    public static Country restore(
            CountryId id, String nameCountry, String codeCountry, String description, boolean isActive, String telephonePrefix, LocalDateTime createdAt, LocalDateTime updatedAt) {
        return new Country(id, nameCountry, codeCountry, description, isActive, telephonePrefix, createdAt, updatedAt);
    }

    public void update(String nameCountry, String codeCountry, String description, String telephonePrefix) {
        this.nameCountry = nameCountry;
        this.codeCountry = codeCountry;
        this.description = description;
        this.telephonePrefix = telephonePrefix;
        this.updatedAt = LocalDateTime.now();
        recordEvent(new CountryUpdatedEvent(this.id, LocalDateTime.now()));
    }

    public CountryId id() { return id; }
    public String nameCountry() { return nameCountry; }
    public String codeCountry() { return codeCountry; }
    public String description() { return description; }
    public boolean isActive() { return isActive; }
    public String telephonePrefix() { return telephonePrefix; }
    public LocalDateTime createdAt() { return createdAt; }
    public LocalDateTime updatedAt() { return updatedAt; }
}
