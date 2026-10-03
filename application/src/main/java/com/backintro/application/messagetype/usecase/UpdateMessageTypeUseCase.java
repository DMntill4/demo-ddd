package com.backintro.application.messagetype.usecase;

import com.backintro.application.messagetype.command.UpdateMessageTypeCommand;
import com.backintro.application.messagetype.dto.MessageTypeResponse;
import com.backintro.application.messagetype.exception.MessageTypeNotFoundApplicationException;
import com.backintro.domain.messagetype.model.aggregate.MessageType;
import com.backintro.domain.messagetype.port.repository.MessageTypeRepository;

public class UpdateMessageTypeUseCase {
    private final MessageTypeRepository repository;

    public UpdateMessageTypeUseCase(MessageTypeRepository repository) {
        this.repository = repository;
    }

    public MessageTypeResponse execute(UpdateMessageTypeCommand command) {
        MessageType aggregate = repository.findById(command.id())
                .orElseThrow(() -> new MessageTypeNotFoundApplicationException(command.id()));
        aggregate.update(command.nameType());
        MessageType saved = repository.save(aggregate);
        return MessageTypeResponse.fromDomain(saved);
    }
}
