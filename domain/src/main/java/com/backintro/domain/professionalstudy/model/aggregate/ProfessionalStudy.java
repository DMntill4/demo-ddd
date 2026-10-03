package com.backintro.domain.professionalstudy.model.aggregate;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.Objects;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.professionalstudy.event.ProfessionalStudyRegisteredEvent;
import com.backintro.domain.professionalstudy.event.ProfessionalStudyUpdatedEvent;
import com.backintro.domain.professionalstudy.model.valueobject.ProfessionalStudyId;

public class ProfessionalStudy extends AggregateRoot {
    private final ProfessionalStudyId id;
    private UUID studyId;
    private UUID professionalId;
    private String title;
    private String university;
    private boolean isValid;
    private String resolutionNumber;
    private UUID countryId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private ProfessionalStudy(
            ProfessionalStudyId id, UUID studyId, UUID professionalId, String title, String university, boolean isValid, String resolutionNumber, UUID countryId, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "id must not be null");
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

    public static ProfessionalStudy register(UUID studyId, UUID professionalId, String title, String university, boolean isValid, String resolutionNumber, UUID countryId) {
        ProfessionalStudyId id = ProfessionalStudyId.generate();
        LocalDateTime now = LocalDateTime.now();
        ProfessionalStudy aggregate = new ProfessionalStudy(id, studyId, professionalId, title, university, isValid, resolutionNumber, countryId, now, now);
        aggregate.recordEvent(new ProfessionalStudyRegisteredEvent(id, now));
        return aggregate;
    }

    public static ProfessionalStudy restore(
            ProfessionalStudyId id, UUID studyId, UUID professionalId, String title, String university, boolean isValid, String resolutionNumber, UUID countryId, LocalDateTime createdAt, LocalDateTime updatedAt) {
        return new ProfessionalStudy(id, studyId, professionalId, title, university, isValid, resolutionNumber, countryId, createdAt, updatedAt);
    }

    public void update(UUID studyId, UUID professionalId, String title, String university, boolean isValid, String resolutionNumber, UUID countryId) {
        this.studyId = studyId;
        this.professionalId = professionalId;
        this.title = title;
        this.university = university;
        this.isValid = isValid;
        this.resolutionNumber = resolutionNumber;
        this.countryId = countryId;
        this.updatedAt = LocalDateTime.now();
        recordEvent(new ProfessionalStudyUpdatedEvent(this.id, LocalDateTime.now()));
    }

    public ProfessionalStudyId id() { return id; }
    public UUID studyId() { return studyId; }
    public UUID professionalId() { return professionalId; }
    public String title() { return title; }
    public String university() { return university; }
    public boolean isValid() { return isValid; }
    public String resolutionNumber() { return resolutionNumber; }
    public UUID countryId() { return countryId; }
    public LocalDateTime createdAt() { return createdAt; }
    public LocalDateTime updatedAt() { return updatedAt; }
}
