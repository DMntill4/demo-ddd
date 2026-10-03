package com.backintro.infrastructure.citymunicipality.adapters.out.persistence.entity;

import java.time.LocalDateTime;
import java.util.UUID;
import jakarta.persistence.*;

@Entity
@Table(name = "city_municipalities")
public class CityMunicipalityJpaEntity {
    @Id
    private UUID id;

    @Column(name = "name_city", nullable = false)
    private String nameCity;

    @Column(name = "code_citi", nullable = false)
    private String codeCiti;

    @Column(name = "description")
    private String description;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    @Column(name = "region_id", nullable = false)
    private UUID regionId;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    public CityMunicipalityJpaEntity() {
    }

    public CityMunicipalityJpaEntity(UUID id, String nameCity, String codeCiti, String description, boolean isActive, UUID regionId, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.nameCity = nameCity;
        this.codeCiti = codeCiti;
        this.description = description;
        this.isActive = isActive;
        this.regionId = regionId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getNameCity() { return nameCity; }
    public void setNameCity(String nameCity) { this.nameCity = nameCity; }

    public String getCodeCiti() { return codeCiti; }
    public void setCodeCiti(String codeCiti) { this.codeCiti = codeCiti; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public boolean getIsActive() { return isActive; }
    public void setIsActive(boolean isActive) { this.isActive = isActive; }

    public UUID getRegionId() { return regionId; }
    public void setRegionId(UUID regionId) { this.regionId = regionId; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
