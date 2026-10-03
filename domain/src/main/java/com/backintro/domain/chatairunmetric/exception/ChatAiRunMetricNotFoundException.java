package com.backintro.domain.chatairunmetric.exception;

import com.backintro.domain.common.exception.DomainException;
import com.backintro.domain.chatairunmetric.model.valueobject.ChatAiRunMetricId;

public class ChatAiRunMetricNotFoundException extends DomainException {
    public ChatAiRunMetricNotFoundException(ChatAiRunMetricId id) {
        super("ChatAiRunMetric with id " + id.value() + " was not found.");
    }
}
