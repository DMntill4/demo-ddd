package com.backintro.application.contact.usecase;

import com.backintro.application.contact.dto.ContactResponse;
import com.backintro.application.contact.exception.ContactNotFoundApplicationException;
import com.backintro.domain.contact.model.valueobject.ContactId;
import com.backintro.domain.contact.port.repository.ContactRepository;

public class GetContactByIdUseCase {
    private final ContactRepository repository;

    public GetContactByIdUseCase(ContactRepository repository) {
        this.repository = repository;
    }

    public ContactResponse execute(ContactId id) {
        return repository.findById(id)
                .map(ContactResponse::fromDomain)
                .orElseThrow(() -> new ContactNotFoundApplicationException(id));
    }
}
