package com.backintro.application.chataisettings.command;

import com.backintro.domain.chataisettings.model.valueobject.ChatAiSettingsId;

public record UpdateChatAiSettingsCommand(ChatAiSettingsId id, String name, String code) {
}
