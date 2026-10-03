package com.backintro.domain.aimodel.model.aggregate;

import java.time.LocalDateTime;
import java.math.BigDecimal;
import java.util.UUID;
import java.util.Objects;

import com.backintro.domain.common.model.AggregateRoot;
import com.backintro.domain.aimodel.event.AiModelRegisteredEvent;
import com.backintro.domain.aimodel.event.AiModelUpdatedEvent;
import com.backintro.domain.aimodel.model.valueobject.AiModelId;

public class AiModel extends AggregateRoot {
    private final AiModelId id;
    private UUID providerModelId;
    private String nameModel;
    private String modelKey;
    private BigDecimal inputTokenPrice;
    private BigDecimal outputTokenPrice;
    private Integer maxTokens;
    private Integer contextWindow;
    private boolean isActive;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private AiModel(
            AiModelId id, UUID providerModelId, String nameModel, String modelKey, BigDecimal inputTokenPrice, BigDecimal outputTokenPrice, Integer maxTokens, Integer contextWindow, boolean isActive, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "id must not be null");
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

    public static AiModel register(UUID providerModelId, String nameModel, String modelKey, BigDecimal inputTokenPrice, BigDecimal outputTokenPrice, Integer maxTokens, Integer contextWindow) {
        AiModelId id = AiModelId.generate();
        LocalDateTime now = LocalDateTime.now();
        AiModel aggregate = new AiModel(id, providerModelId, nameModel, modelKey, inputTokenPrice, outputTokenPrice, maxTokens, contextWindow, true, now, now);
        aggregate.recordEvent(new AiModelRegisteredEvent(id, now));
        return aggregate;
    }

    public static AiModel restore(
            AiModelId id, UUID providerModelId, String nameModel, String modelKey, BigDecimal inputTokenPrice, BigDecimal outputTokenPrice, Integer maxTokens, Integer contextWindow, boolean isActive, LocalDateTime createdAt, LocalDateTime updatedAt) {
        return new AiModel(id, providerModelId, nameModel, modelKey, inputTokenPrice, outputTokenPrice, maxTokens, contextWindow, isActive, createdAt, updatedAt);
    }

    public void update(UUID providerModelId, String nameModel, String modelKey, BigDecimal inputTokenPrice, BigDecimal outputTokenPrice, Integer maxTokens, Integer contextWindow) {
        this.providerModelId = providerModelId;
        this.nameModel = nameModel;
        this.modelKey = modelKey;
        this.inputTokenPrice = inputTokenPrice;
        this.outputTokenPrice = outputTokenPrice;
        this.maxTokens = maxTokens;
        this.contextWindow = contextWindow;
        this.updatedAt = LocalDateTime.now();
        recordEvent(new AiModelUpdatedEvent(this.id, LocalDateTime.now()));
    }

    public AiModelId id() { return id; }
    public UUID providerModelId() { return providerModelId; }
    public String nameModel() { return nameModel; }
    public String modelKey() { return modelKey; }
    public BigDecimal inputTokenPrice() { return inputTokenPrice; }
    public BigDecimal outputTokenPrice() { return outputTokenPrice; }
    public Integer maxTokens() { return maxTokens; }
    public Integer contextWindow() { return contextWindow; }
    public boolean isActive() { return isActive; }
    public LocalDateTime createdAt() { return createdAt; }
    public LocalDateTime updatedAt() { return updatedAt; }
}
