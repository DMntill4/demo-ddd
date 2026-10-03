package com.backintro.application.chatairunmetric.command;

import java.math.BigDecimal;
import java.util.UUID;

import com.backintro.domain.chatairunmetric.model.valueobject.ChatAiRunMetricId;

public record UpdateChatAiRunMetricCommand(ChatAiRunMetricId id, UUID aiRunId, Integer promptTokens, Integer completionTokens, Integer totalTokens, BigDecimal cost) {
}
