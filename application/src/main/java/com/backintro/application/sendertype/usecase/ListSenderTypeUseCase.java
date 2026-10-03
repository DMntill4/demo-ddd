package com.backintro.application.sendertype.usecase;

import java.util.List;
import com.backintro.application.sendertype.dto.SenderTypeResponse;
import com.backintro.domain.sendertype.port.repository.SenderTypeRepository;

public class ListSenderTypeUseCase {
    private final SenderTypeRepository repository;

    public ListSenderTypeUseCase(SenderTypeRepository repository) {
        this.repository = repository;
    }

    public List<SenderTypeResponse> execute() {
        return repository.findAll()
                .stream()
                .map(SenderTypeResponse::fromDomain)
                .toList();
    }
}
