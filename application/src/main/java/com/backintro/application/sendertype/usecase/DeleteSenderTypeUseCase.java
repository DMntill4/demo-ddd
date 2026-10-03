package com.backintro.application.sendertype.usecase;

import com.backintro.application.sendertype.exception.SenderTypeNotFoundApplicationException;
import com.backintro.domain.sendertype.model.aggregate.SenderType;
import com.backintro.domain.sendertype.model.valueobject.SenderTypeId;
import com.backintro.domain.sendertype.port.repository.SenderTypeRepository;

public class DeleteSenderTypeUseCase {
    private final SenderTypeRepository repository;

    public DeleteSenderTypeUseCase(SenderTypeRepository repository) {
        this.repository = repository;
    }

    public void execute(SenderTypeId id) {
        SenderType aggregate = repository.findById(id)
                .orElseThrow(() -> new SenderTypeNotFoundApplicationException(id));
        repository.delete(aggregate);
    }
}
