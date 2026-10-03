package com.backintro.application.airunsstatus.command;

import com.backintro.domain.airunsstatus.model.valueobject.AiRunStatusId;

public record UpdateAiRunStatusCommand(AiRunStatusId id, String nameStatus) {
}
