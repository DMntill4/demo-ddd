package com.backintro.application.sendertype.usecase;

import com.backintro.application.sendertype.dto.SenderTypeResponse;
import com.backintro.application.sendertype.exception.SenderTypeNotFoundApplicationException;
import com.backintro.domain.sendertype.model.valueobject.SenderTypeId;
import com.backintro.domain.sendertype.port.repository.SenderTypeRepository;

public class GetSenderTypeByIdUseCase {
    private final SenderTypeRepository repository;

    public GetSenderTypeByIdUseCase(SenderTypeRepository repository) {
        this.repository = repository;
    }

    public SenderTypeResponse execute(SenderTypeId id) {
        return repository.findById(id)
                .map(SenderTypeResponse::fromDomain)
                .orElseThrow(() -> new SenderTypeNotFoundApplicationException(id));
    }
}
