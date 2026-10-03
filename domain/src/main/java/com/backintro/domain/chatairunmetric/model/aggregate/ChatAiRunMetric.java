package com.backintro.domain.chatairunmetric.model.aggregate;

import java.time.LocalDateTime;
import java.math.BigDecimal;
import java.util.UUID;
import java.util.Objects;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.chatairunmetric.event.ChatAiRunMetricRegisteredEvent;
import com.backintro.domain.chatairunmetric.event.ChatAiRunMetricUpdatedEvent;
import com.backintro.domain.chatairunmetric.model.valueobject.ChatAiRunMetricId;

public class ChatAiRunMetric extends AggregateRoot {
    private final ChatAiRunMetricId id;
    private UUID aiRunId;
    private Integer promptTokens;
    private Integer completionTokens;
    private Integer totalTokens;
    private BigDecimal cost;
    private LocalDateTime createdAt;

    private ChatAiRunMetric(
            ChatAiRunMetricId id, UUID aiRunId, Integer promptTokens, Integer completionTokens, Integer totalTokens, BigDecimal cost, LocalDateTime createdAt) {
        this.id = Objects.requireNonNull(id, "id must not be null");
        this.aiRunId = aiRunId;
        this.promptTokens = promptTokens;
        this.completionTokens = completionTokens;
        this.totalTokens = totalTokens;
        this.cost = cost;
        this.createdAt = createdAt;
    }

    public static ChatAiRunMetric register(UUID aiRunId, Integer promptTokens, Integer completionTokens, Integer totalTokens, BigDecimal cost) {
        ChatAiRunMetricId id = ChatAiRunMetricId.generate();
        LocalDateTime now = LocalDateTime.now();
        ChatAiRunMetric aggregate = new ChatAiRunMetric(id, aiRunId, promptTokens, completionTokens, totalTokens, cost, now);
        aggregate.recordEvent(new ChatAiRunMetricRegisteredEvent(id, now));
        return aggregate;
    }

    public static ChatAiRunMetric restore(
            ChatAiRunMetricId id, UUID aiRunId, Integer promptTokens, Integer completionTokens, Integer totalTokens, BigDecimal cost, LocalDateTime createdAt) {
        return new ChatAiRunMetric(id, aiRunId, promptTokens, completionTokens, totalTokens, cost, createdAt);
    }

    public void update(UUID aiRunId, Integer promptTokens, Integer completionTokens, Integer totalTokens, BigDecimal cost) {
        this.aiRunId = aiRunId;
        this.promptTokens = promptTokens;
        this.completionTokens = completionTokens;
        this.totalTokens = totalTokens;
        this.cost = cost;
        recordEvent(new ChatAiRunMetricUpdatedEvent(this.id, LocalDateTime.now()));
    }

    public ChatAiRunMetricId id() { return id; }
    public UUID aiRunId() { return aiRunId; }
    public Integer promptTokens() { return promptTokens; }
    public Integer completionTokens() { return completionTokens; }
    public Integer totalTokens() { return totalTokens; }
    public BigDecimal cost() { return cost; }
    public LocalDateTime createdAt() { return createdAt; }
}
