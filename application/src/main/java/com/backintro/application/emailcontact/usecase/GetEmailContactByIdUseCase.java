package com.backintro.application.emailcontact.usecase;

import com.backintro.application.emailcontact.dto.EmailContactResponse;
import com.backintro.application.emailcontact.exception.EmailContactNotFoundApplicationException;
import com.backintro.domain.emailcontact.model.valueobject.EmailContactId;
import com.backintro.domain.emailcontact.port.repository.EmailContactRepository;

public class GetEmailContactByIdUseCase {
    private final EmailContactRepository repository;

    public GetEmailContactByIdUseCase(EmailContactRepository repository) {
        this.repository = repository;
    }

    public EmailContactResponse execute(EmailContactId id) {
        return repository.findById(id)
                .map(EmailContactResponse::fromDomain)
                .orElseThrow(() -> new EmailContactNotFoundApplicationException(id));
    }
}
