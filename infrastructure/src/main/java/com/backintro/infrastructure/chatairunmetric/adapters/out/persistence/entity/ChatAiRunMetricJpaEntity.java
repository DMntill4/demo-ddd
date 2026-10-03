package com.backintro.infrastructure.chatairunmetric.adapters.out.persistence.entity;

import java.time.LocalDateTime;
import java.math.BigDecimal;
import java.util.UUID;
import jakarta.persistence.*;

@Entity
@Table(name = "chat_ai_run_metrics")
public class ChatAiRunMetricJpaEntity {
    @Id
    private UUID id;

    @Column(name = "ai_run_id", nullable = false)
    private UUID aiRunId;

    @Column(name = "prompt_tokens")
    private Integer promptTokens;

    @Column(name = "completion_tokens")
    private Integer completionTokens;

    @Column(name = "total_tokens")
    private Integer totalTokens;

    @Column(name = "cost")
    private BigDecimal cost;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    public ChatAiRunMetricJpaEntity() {
    }

    public ChatAiRunMetricJpaEntity(UUID id, UUID aiRunId, Integer promptTokens, Integer completionTokens, Integer totalTokens, BigDecimal cost, LocalDateTime createdAt) {
        this.id = id;
        this.aiRunId = aiRunId;
        this.promptTokens = promptTokens;
        this.completionTokens = completionTokens;
        this.totalTokens = totalTokens;
        this.cost = cost;
        this.createdAt = createdAt;
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public UUID getAiRunId() { return aiRunId; }
    public void setAiRunId(UUID aiRunId) { this.aiRunId = aiRunId; }

    public Integer getPromptTokens() { return promptTokens; }
    public void setPromptTokens(Integer promptTokens) { this.promptTokens = promptTokens; }

    public Integer getCompletionTokens() { return completionTokens; }
    public void setCompletionTokens(Integer completionTokens) { this.completionTokens = completionTokens; }

    public Integer getTotalTokens() { return totalTokens; }
    public void setTotalTokens(Integer totalTokens) { this.totalTokens = totalTokens; }

    public BigDecimal getCost() { return cost; }
    public void setCost(BigDecimal cost) { this.cost = cost; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
