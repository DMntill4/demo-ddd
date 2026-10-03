package com.backintro.application.chatmessage.usecase;

import com.backintro.application.chatmessage.dto.ChatMessageResponse;
import com.backintro.application.chatmessage.exception.ChatMessageNotFoundApplicationException;
import com.backintro.domain.chatmessage.model.valueobject.ChatMessageId;
import com.backintro.domain.chatmessage.port.repository.ChatMessageRepository;

public class GetChatMessageByIdUseCase {
    private final ChatMessageRepository repository;

    public GetChatMessageByIdUseCase(ChatMessageRepository repository) {
        this.repository = repository;
    }

    public ChatMessageResponse execute(ChatMessageId id) {
        return repository.findById(id)
                .map(ChatMessageResponse::fromDomain)
                .orElseThrow(() -> new ChatMessageNotFoundApplicationException(id));
    }
}
