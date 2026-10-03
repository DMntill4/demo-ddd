package com.backintro.application.messagetype.command;

import com.backintro.domain.messagetype.model.valueobject.MessageTypeId;

public record UpdateMessageTypeCommand(MessageTypeId id, String nameType) {
}
