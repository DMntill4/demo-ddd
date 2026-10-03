package com.backintro.application.messagetype.usecase;

import com.backintro.application.messagetype.command.RegisterMessageTypeCommand;
import com.backintro.application.messagetype.dto.MessageTypeResponse;
import com.backintro.domain.messagetype.model.aggregate.MessageType;
import com.backintro.domain.messagetype.port.repository.MessageTypeRepository;

public class RegisterMessageTypeUseCase {
    private final MessageTypeRepository repository;

    public RegisterMessageTypeUseCase(MessageTypeRepository repository) {
        this.repository = repository;
    }

    public MessageTypeResponse execute(RegisterMessageTypeCommand command) {
        MessageType aggregate = MessageType.register(command.nameType());
        MessageType saved = repository.save(aggregate);
        return MessageTypeResponse.fromDomain(saved);
    }
}
