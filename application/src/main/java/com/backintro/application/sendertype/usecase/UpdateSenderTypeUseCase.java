package com.backintro.application.sendertype.usecase;

import com.backintro.application.sendertype.command.UpdateSenderTypeCommand;
import com.backintro.application.sendertype.dto.SenderTypeResponse;
import com.backintro.application.sendertype.exception.SenderTypeNotFoundApplicationException;
import com.backintro.domain.sendertype.model.aggregate.SenderType;
import com.backintro.domain.sendertype.port.repository.SenderTypeRepository;

public class UpdateSenderTypeUseCase {
    private final SenderTypeRepository repository;

    public UpdateSenderTypeUseCase(SenderTypeRepository repository) {
        this.repository = repository;
    }

    public SenderTypeResponse execute(UpdateSenderTypeCommand command) {
        SenderType aggregate = repository.findById(command.id())
                .orElseThrow(() -> new SenderTypeNotFoundApplicationException(command.id()));
        aggregate.update(command.nameType());
        SenderType saved = repository.save(aggregate);
        return SenderTypeResponse.fromDomain(saved);
    }
}
