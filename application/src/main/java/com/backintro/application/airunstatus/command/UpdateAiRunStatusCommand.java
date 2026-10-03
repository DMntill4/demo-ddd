package com.backintro.application.airunstatus.command;

import com.backintro.domain.airunstatus.model.valueobject.AiRunStatusId;

public record UpdateAiRunStatusCommand(AiRunStatusId id, String name, String code) {
}
