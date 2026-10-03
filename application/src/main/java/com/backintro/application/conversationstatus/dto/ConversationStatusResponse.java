package com.backintro.application.conversationstatus.dto;

import java.util.UUID;
import com.backintro.domain.conversationstatus.model.aggregate.ConversationStatus;

public record ConversationStatusResponse(UUID id, String name, String code, boolean active) {
    public static ConversationStatusResponse fromDomain(ConversationStatus aggregate) {
        return new ConversationStatusResponse(
                aggregate.id().value(),
                aggregate.name(),
                aggregate.code(),
                aggregate.active()
        );
    }
}
