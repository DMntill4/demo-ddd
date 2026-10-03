package com.backintro.application.chatmessage.usecase;

import com.backintro.application.chatmessage.command.UpdateChatMessageCommand;
import com.backintro.application.chatmessage.dto.ChatMessageResponse;
import com.backintro.application.chatmessage.exception.ChatMessageNotFoundApplicationException;
import com.backintro.domain.chatmessage.model.aggregate.ChatMessage;
import com.backintro.domain.chatmessage.port.repository.ChatMessageRepository;

public class UpdateChatMessageUseCase {
    private final ChatMessageRepository repository;

    public UpdateChatMessageUseCase(ChatMessageRepository repository) {
        this.repository = repository;
    }

    public ChatMessageResponse execute(UpdateChatMessageCommand command) {
        ChatMessage aggregate = repository.findById(command.id())
                .orElseThrow(() -> new ChatMessageNotFoundApplicationException(command.id()));
        aggregate.update(command.conversationId(), command.messageTypeId(), command.participantId(), command.content(), command.metadata());
        ChatMessage saved = repository.save(aggregate);
        return ChatMessageResponse.fromDomain(saved);
    }
}
