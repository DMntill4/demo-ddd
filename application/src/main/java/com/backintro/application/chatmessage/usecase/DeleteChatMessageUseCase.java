package com.backintro.application.chatmessage.usecase;

import com.backintro.application.chatmessage.exception.ChatMessageNotFoundApplicationException;
import com.backintro.domain.chatmessage.model.aggregate.ChatMessage;
import com.backintro.domain.chatmessage.model.valueobject.ChatMessageId;
import com.backintro.domain.chatmessage.port.repository.ChatMessageRepository;

public class DeleteChatMessageUseCase {
    private final ChatMessageRepository repository;

    public DeleteChatMessageUseCase(ChatMessageRepository repository) {
        this.repository = repository;
    }

    public void execute(ChatMessageId id) {
        ChatMessage aggregate = repository.findById(id)
                .orElseThrow(() -> new ChatMessageNotFoundApplicationException(id));
        repository.delete(aggregate);
    }
}
