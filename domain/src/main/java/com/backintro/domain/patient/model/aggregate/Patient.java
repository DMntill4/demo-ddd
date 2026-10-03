package com.backintro.domain.patient.model.aggregate;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.UUID;
import java.util.Objects;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.patient.event.PatientRegisteredEvent;
import com.backintro.domain.patient.event.PatientUpdatedEvent;
import com.backintro.domain.patient.model.valueobject.PatientId;

public class Patient extends AggregateRoot {
    private final PatientId id;
    private UUID documentTypeId;
    private String documentNumber;
    private String firstName;
    private String middleName;
    private String lastName;
    private String secondLastName;
    private LocalDate birthDate;
    private UUID biologicalSexId;
    private UUID genderIdentity;
    private String email;
    private String phone;
    private String address;
    private boolean active;
    private LocalDateTime createdAt;
    private UUID createdBy;
    private LocalDateTime updatedAt;
    private UUID updatedBy;
    private UUID cityId;

    private Patient(
            PatientId id, UUID documentTypeId, String documentNumber, String firstName, String middleName, String lastName, String secondLastName, LocalDate birthDate, UUID biologicalSexId, UUID genderIdentity, String email, String phone, String address, boolean active, LocalDateTime createdAt, UUID createdBy, LocalDateTime updatedAt, UUID updatedBy, UUID cityId) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.documentTypeId = documentTypeId;
        this.documentNumber = documentNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.secondLastName = secondLastName;
        this.birthDate = birthDate;
        this.biologicalSexId = biologicalSexId;
        this.genderIdentity = genderIdentity;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.active = active;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.updatedAt = updatedAt;
        this.updatedBy = updatedBy;
        this.cityId = cityId;
    }

    public static Patient register(UUID documentTypeId, String documentNumber, String firstName, String middleName, String lastName, String secondLastName, LocalDate birthDate, UUID biologicalSexId, UUID genderIdentity, String email, String phone, String address, UUID createdBy, UUID updatedBy, UUID cityId) {
        PatientId id = PatientId.generate();
        LocalDateTime now = LocalDateTime.now();
        Patient aggregate = new Patient(id, documentTypeId, documentNumber, firstName, middleName, lastName, secondLastName, birthDate, biologicalSexId, genderIdentity, email, phone, address, true, now, createdBy, now, updatedBy, cityId);
        aggregate.recordEvent(new PatientRegisteredEvent(id, now));
        return aggregate;
    }

    public static Patient restore(
            PatientId id, UUID documentTypeId, String documentNumber, String firstName, String middleName, String lastName, String secondLastName, LocalDate birthDate, UUID biologicalSexId, UUID genderIdentity, String email, String phone, String address, boolean active, LocalDateTime createdAt, UUID createdBy, LocalDateTime updatedAt, UUID updatedBy, UUID cityId) {
        return new Patient(id, documentTypeId, documentNumber, firstName, middleName, lastName, secondLastName, birthDate, biologicalSexId, genderIdentity, email, phone, address, active, createdAt, createdBy, updatedAt, updatedBy, cityId);
    }

    public void update(UUID documentTypeId, String documentNumber, String firstName, String middleName, String lastName, String secondLastName, LocalDate birthDate, UUID biologicalSexId, UUID genderIdentity, String email, String phone, String address, UUID createdBy, UUID updatedBy, UUID cityId) {
        this.documentTypeId = documentTypeId;
        this.documentNumber = documentNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.secondLastName = secondLastName;
        this.birthDate = birthDate;
        this.biologicalSexId = biologicalSexId;
        this.genderIdentity = genderIdentity;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.cityId = cityId;
        this.updatedAt = LocalDateTime.now();
        recordEvent(new PatientUpdatedEvent(this.id, LocalDateTime.now()));
    }

    public PatientId id() { return id; }
    public UUID documentTypeId() { return documentTypeId; }
    public String documentNumber() { return documentNumber; }
    public String firstName() { return firstName; }
    public String middleName() { return middleName; }
    public String lastName() { return lastName; }
    public String secondLastName() { return secondLastName; }
    public LocalDate birthDate() { return birthDate; }
    public UUID biologicalSexId() { return biologicalSexId; }
    public UUID genderIdentity() { return genderIdentity; }
    public String email() { return email; }
    public String phone() { return phone; }
    public String address() { return address; }
    public boolean active() { return active; }
    public LocalDateTime createdAt() { return createdAt; }
    public UUID createdBy() { return createdBy; }
    public LocalDateTime updatedAt() { return updatedAt; }
    public UUID updatedBy() { return updatedBy; }
    public UUID cityId() { return cityId; }
}
