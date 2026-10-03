package com.backintro.application.emailcontact.usecase;

import java.util.List;
import com.backintro.application.emailcontact.dto.EmailContactResponse;
import com.backintro.domain.emailcontact.port.repository.EmailContactRepository;

public class ListEmailContactUseCase {
    private final EmailContactRepository repository;

    public ListEmailContactUseCase(EmailContactRepository repository) {
        this.repository = repository;
    }

    public List<EmailContactResponse> execute() {
        return repository.findAll()
                .stream()
                .map(EmailContactResponse::fromDomain)
                .toList();
    }
}
