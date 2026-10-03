package com.backintro.application.messagetype.usecase;

import com.backintro.application.messagetype.exception.MessageTypeNotFoundApplicationException;
import com.backintro.domain.messagetype.model.aggregate.MessageType;
import com.backintro.domain.messagetype.model.valueobject.MessageTypeId;
import com.backintro.domain.messagetype.port.repository.MessageTypeRepository;

public class DeleteMessageTypeUseCase {
    private final MessageTypeRepository repository;

    public DeleteMessageTypeUseCase(MessageTypeRepository repository) {
        this.repository = repository;
    }

    public void execute(MessageTypeId id) {
        MessageType aggregate = repository.findById(id)
                .orElseThrow(() -> new MessageTypeNotFoundApplicationException(id));
        repository.delete(aggregate);
    }
}
