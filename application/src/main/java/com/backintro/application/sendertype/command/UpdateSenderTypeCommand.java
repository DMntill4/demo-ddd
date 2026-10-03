package com.backintro.application.sendertype.command;

import com.backintro.domain.sendertype.model.valueobject.SenderTypeId;

public record UpdateSenderTypeCommand(SenderTypeId id, String nameType) {
}
