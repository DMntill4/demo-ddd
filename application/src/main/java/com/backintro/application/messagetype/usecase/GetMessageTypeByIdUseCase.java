package com.backintro.application.messagetype.usecase;

import com.backintro.application.messagetype.dto.MessageTypeResponse;
import com.backintro.application.messagetype.exception.MessageTypeNotFoundApplicationException;
import com.backintro.domain.messagetype.model.valueobject.MessageTypeId;
import com.backintro.domain.messagetype.port.repository.MessageTypeRepository;

public class GetMessageTypeByIdUseCase {
    private final MessageTypeRepository repository;

    public GetMessageTypeByIdUseCase(MessageTypeRepository repository) {
        this.repository = repository;
    }

    public MessageTypeResponse execute(MessageTypeId id) {
        return repository.findById(id)
                .map(MessageTypeResponse::fromDomain)
                .orElseThrow(() -> new MessageTypeNotFoundApplicationException(id));
    }
}
