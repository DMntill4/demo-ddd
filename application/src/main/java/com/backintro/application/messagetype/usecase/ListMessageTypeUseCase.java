package com.backintro.application.messagetype.usecase;

import java.util.List;
import com.backintro.application.messagetype.dto.MessageTypeResponse;
import com.backintro.domain.messagetype.port.repository.MessageTypeRepository;

public class ListMessageTypeUseCase {
    private final MessageTypeRepository repository;

    public ListMessageTypeUseCase(MessageTypeRepository repository) {
        this.repository = repository;
    }

    public List<MessageTypeResponse> execute() {
        return repository.findAll()
                .stream()
                .map(MessageTypeResponse::fromDomain)
                .toList();
    }
}
