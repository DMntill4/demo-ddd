package com.backintro.infrastructure.professionalstudy.adapters.out.persistence.entity;

import java.time.LocalDateTime;
import java.util.UUID;
import jakarta.persistence.*;

@Entity
@Table(name = "professional_studies")
public class ProfessionalStudyJpaEntity {
    @Id
    private UUID id;

    @Column(name = "study_id", nullable = false)
    private UUID studyId;

    @Column(name = "professional_id", nullable = false)
    private UUID professionalId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "university", nullable = false)
    private String university;

    @Column(name = "is_valid", nullable = false)
    private boolean isValid;

    @Column(name = "resolution_number")
    private String resolutionNumber;

    @Column(name = "country_id")
    private UUID countryId;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    public ProfessionalStudyJpaEntity() {
    }

    public ProfessionalStudyJpaEntity(UUID id, UUID studyId, UUID professionalId, String title, String university, boolean isValid, String resolutionNumber, UUID countryId, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.studyId = studyId;
        this.professionalId = professionalId;
        this.title = title;
        this.university = university;
        this.isValid = isValid;
        this.resolutionNumber = resolutionNumber;
        this.countryId = countryId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public UUID getStudyId() { return studyId; }
    public void setStudyId(UUID studyId) { this.studyId = studyId; }

    public UUID getProfessionalId() { return professionalId; }
    public void setProfessionalId(UUID professionalId) { this.professionalId = professionalId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getUniversity() { return university; }
    public void setUniversity(String university) { this.university = university; }

    public boolean getIsValid() { return isValid; }
    public void setIsValid(boolean isValid) { this.isValid = isValid; }

    public String getResolutionNumber() { return resolutionNumber; }
    public void setResolutionNumber(String resolutionNumber) { this.resolutionNumber = resolutionNumber; }

    public UUID getCountryId() { return countryId; }
    public void setCountryId(UUID countryId) { this.countryId = countryId; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
