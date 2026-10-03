package com.backintro.application.conversationstatus.command;

import com.backintro.domain.conversationstatus.model.valueobject.ConversationStatusId;

public record UpdateConversationStatusCommand(ConversationStatusId id, String name, String code) {
}
