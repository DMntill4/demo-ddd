package com.backintro.application.chatairunmetric.exception;

import com.backintro.application.common.exception.ApplicationException;
import com.backintro.domain.chatairunmetric.model.valueobject.ChatAiRunMetricId;

public class ChatAiRunMetricNotFoundApplicationException extends ApplicationException {
    public ChatAiRunMetricNotFoundApplicationException(ChatAiRunMetricId id) {
        super("ChatAiRunMetric with id " + id.value() + " was not found.");
    }
}
