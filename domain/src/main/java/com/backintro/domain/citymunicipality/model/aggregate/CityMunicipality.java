package com.backintro.domain.citymunicipality.model.aggregate;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.Objects;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.citymunicipality.event.CityMunicipalityRegisteredEvent;
import com.backintro.domain.citymunicipality.event.CityMunicipalityUpdatedEvent;
import com.backintro.domain.citymunicipality.model.valueobject.CityMunicipalityId;

public class CityMunicipality extends AggregateRoot {
    private final CityMunicipalityId id;
    private String nameCity;
    private String codeCiti;
    private String description;
    private boolean isActive;
    private UUID regionId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private CityMunicipality(
            CityMunicipalityId id, String nameCity, String codeCiti, String description, boolean isActive, UUID regionId, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.nameCity = nameCity;
        this.codeCiti = codeCiti;
        this.description = description;
        this.isActive = isActive;
        this.regionId = regionId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static CityMunicipality register(String nameCity, String codeCiti, String description, UUID regionId) {
        CityMunicipalityId id = CityMunicipalityId.generate();
        LocalDateTime now = LocalDateTime.now();
        CityMunicipality aggregate = new CityMunicipality(id, nameCity, codeCiti, description, true, regionId, now, now);
        aggregate.recordEvent(new CityMunicipalityRegisteredEvent(id, now));
        return aggregate;
    }

    public static CityMunicipality restore(
            CityMunicipalityId id, String nameCity, String codeCiti, String description, boolean isActive, UUID regionId, LocalDateTime createdAt, LocalDateTime updatedAt) {
        return new CityMunicipality(id, nameCity, codeCiti, description, isActive, regionId, createdAt, updatedAt);
    }

    public void update(String nameCity, String codeCiti, String description, UUID regionId) {
        this.nameCity = nameCity;
        this.codeCiti = codeCiti;
        this.description = description;
        this.regionId = regionId;
        this.updatedAt = LocalDateTime.now();
        recordEvent(new CityMunicipalityUpdatedEvent(this.id, LocalDateTime.now()));
    }

    public CityMunicipalityId id() { return id; }
    public String nameCity() { return nameCity; }
    public String codeCiti() { return codeCiti; }
    public String description() { return description; }
    public boolean isActive() { return isActive; }
    public UUID regionId() { return regionId; }
    public LocalDateTime createdAt() { return createdAt; }
    public LocalDateTime updatedAt() { return updatedAt; }
}
