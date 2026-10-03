package com.backintro.domain.mentalstatusexam.model.aggregate;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.Objects;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.mentalstatusexam.event.MentalStatusExamRegisteredEvent;
import com.backintro.domain.mentalstatusexam.event.MentalStatusExamUpdatedEvent;
import com.backintro.domain.mentalstatusexam.model.valueobject.MentalStatusExamId;

public class MentalStatusExam extends AggregateRoot {
    private final MentalStatusExamId id;
    private UUID encounterId;
    private String appearance;
    private String behavior;
    private String attitude;
    private String consciousness;
    private String orientation;
    private String attention;
    private String memory;
    private String speech;
    private String mood;
    private String affect;
    private String thoughtProcess;
    private String thoughtContent;
    private String perception;
    private String judgment;
    private String insight;
    private String psychomotorActivity;
    private String observations;
    private LocalDateTime createdAt;
    private UUID createdBy;

    private MentalStatusExam(
            MentalStatusExamId id, UUID encounterId, String appearance, String behavior, String attitude, String consciousness, String orientation, String attention, String memory, String speech, String mood, String affect, String thoughtProcess, String thoughtContent, String perception, String judgment, String insight, String psychomotorActivity, String observations, LocalDateTime createdAt, UUID createdBy) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.encounterId = encounterId;
        this.appearance = appearance;
        this.behavior = behavior;
        this.attitude = attitude;
        this.consciousness = consciousness;
        this.orientation = orientation;
        this.attention = attention;
        this.memory = memory;
        this.speech = speech;
        this.mood = mood;
        this.affect = affect;
        this.thoughtProcess = thoughtProcess;
        this.thoughtContent = thoughtContent;
        this.perception = perception;
        this.judgment = judgment;
        this.insight = insight;
        this.psychomotorActivity = psychomotorActivity;
        this.observations = observations;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
    }

    public static MentalStatusExam register(UUID encounterId, String appearance, String behavior, String attitude, String consciousness, String orientation, String attention, String memory, String speech, String mood, String affect, String thoughtProcess, String thoughtContent, String perception, String judgment, String insight, String psychomotorActivity, String observations, UUID createdBy) {
        MentalStatusExamId id = MentalStatusExamId.generate();
        LocalDateTime now = LocalDateTime.now();
        MentalStatusExam aggregate = new MentalStatusExam(id, encounterId, appearance, behavior, attitude, consciousness, orientation, attention, memory, speech, mood, affect, thoughtProcess, thoughtContent, perception, judgment, insight, psychomotorActivity, observations, now, createdBy);
        aggregate.recordEvent(new MentalStatusExamRegisteredEvent(id, now));
        return aggregate;
    }

    public static MentalStatusExam restore(
            MentalStatusExamId id, UUID encounterId, String appearance, String behavior, String attitude, String consciousness, String orientation, String attention, String memory, String speech, String mood, String affect, String thoughtProcess, String thoughtContent, String perception, String judgment, String insight, String psychomotorActivity, String observations, LocalDateTime createdAt, UUID createdBy) {
        return new MentalStatusExam(id, encounterId, appearance, behavior, attitude, consciousness, orientation, attention, memory, speech, mood, affect, thoughtProcess, thoughtContent, perception, judgment, insight, psychomotorActivity, observations, createdAt, createdBy);
    }

    public void update(UUID encounterId, String appearance, String behavior, String attitude, String consciousness, String orientation, String attention, String memory, String speech, String mood, String affect, String thoughtProcess, String thoughtContent, String perception, String judgment, String insight, String psychomotorActivity, String observations, UUID createdBy) {
        this.encounterId = encounterId;
        this.appearance = appearance;
        this.behavior = behavior;
        this.attitude = attitude;
        this.consciousness = consciousness;
        this.orientation = orientation;
        this.attention = attention;
        this.memory = memory;
        this.speech = speech;
        this.mood = mood;
        this.affect = affect;
        this.thoughtProcess = thoughtProcess;
        this.thoughtContent = thoughtContent;
        this.perception = perception;
        this.judgment = judgment;
        this.insight = insight;
        this.psychomotorActivity = psychomotorActivity;
        this.observations = observations;
        this.createdBy = createdBy;
        recordEvent(new MentalStatusExamUpdatedEvent(this.id, LocalDateTime.now()));
    }

    public MentalStatusExamId id() { return id; }
    public UUID encounterId() { return encounterId; }
    public String appearance() { return appearance; }
    public String behavior() { return behavior; }
    public String attitude() { return attitude; }
    public String consciousness() { return consciousness; }
    public String orientation() { return orientation; }
    public String attention() { return attention; }
    public String memory() { return memory; }
    public String speech() { return speech; }
    public String mood() { return mood; }
    public String affect() { return affect; }
    public String thoughtProcess() { return thoughtProcess; }
    public String thoughtContent() { return thoughtContent; }
    public String perception() { return perception; }
    public String judgment() { return judgment; }
    public String insight() { return insight; }
    public String psychomotorActivity() { return psychomotorActivity; }
    public String observations() { return observations; }
    public LocalDateTime createdAt() { return createdAt; }
    public UUID createdBy() { return createdBy; }
}
