package com.backintro.infrastructure.aimodel.adapters.out.persistence.entity;

import java.time.LocalDateTime;
import java.math.BigDecimal;
import java.util.UUID;
import jakarta.persistence.*;

@Entity
@Table(name = "ai_models")
public class AiModelJpaEntity {
    @Id
    private UUID id;

    @Column(name = "provider_model_id", nullable = false)
    private UUID providerModelId;

    @Column(name = "name_model", nullable = false)
    private String nameModel;

    @Column(name = "model_key", nullable = false)
    private String modelKey;

    @Column(name = "input_token_price")
    private BigDecimal inputTokenPrice;

    @Column(name = "output_token_price")
    private BigDecimal outputTokenPrice;

    @Column(name = "max_tokens")
    private Integer maxTokens;

    @Column(name = "context_window")
    private Integer contextWindow;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    public AiModelJpaEntity() {
    }

    public AiModelJpaEntity(UUID id, UUID providerModelId, String nameModel, String modelKey, BigDecimal inputTokenPrice, BigDecimal outputTokenPrice, Integer maxTokens, Integer contextWindow, boolean isActive, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.providerModelId = providerModelId;
        this.nameModel = nameModel;
        this.modelKey = modelKey;
        this.inputTokenPrice = inputTokenPrice;
        this.outputTokenPrice = outputTokenPrice;
        this.maxTokens = maxTokens;
        this.contextWindow = contextWindow;
        this.isActive = isActive;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public UUID getProviderModelId() { return providerModelId; }
    public void setProviderModelId(UUID providerModelId) { this.providerModelId = providerModelId; }

    public String getNameModel() { return nameModel; }
    public void setNameModel(String nameModel) { this.nameModel = nameModel; }

    public String getModelKey() { return modelKey; }
    public void setModelKey(String modelKey) { this.modelKey = modelKey; }

    public BigDecimal getInputTokenPrice() { return inputTokenPrice; }
    public void setInputTokenPrice(BigDecimal inputTokenPrice) { this.inputTokenPrice = inputTokenPrice; }

    public BigDecimal getOutputTokenPrice() { return outputTokenPrice; }
    public void setOutputTokenPrice(BigDecimal outputTokenPrice) { this.outputTokenPrice = outputTokenPrice; }

    public Integer getMaxTokens() { return maxTokens; }
    public void setMaxTokens(Integer maxTokens) { this.maxTokens = maxTokens; }

    public Integer getContextWindow() { return contextWindow; }
    public void setContextWindow(Integer contextWindow) { this.contextWindow = contextWindow; }

    public boolean getIsActive() { return isActive; }
    public void setIsActive(boolean isActive) { this.isActive = isActive; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
