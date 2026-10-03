package com.backintro.infrastructure.chatairunmetric.adapters.in.rest.dtos;

import java.math.BigDecimal;
import java.util.UUID;

public record UpdateChatAiRunMetricRequest(UUID aiRunId, Integer promptTokens, Integer completionTokens, Integer totalTokens, BigDecimal cost) {
}
