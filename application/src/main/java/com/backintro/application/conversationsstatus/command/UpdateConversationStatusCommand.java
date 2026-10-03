package com.backintro.application.conversationsstatus.command;

import com.backintro.domain.conversationsstatus.model.valueobject.ConversationStatusId;

public record UpdateConversationStatusCommand(ConversationStatusId id, String nameStatus) {
}
