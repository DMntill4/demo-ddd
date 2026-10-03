package com.backintro.application.contact.usecase;

import com.backintro.application.contact.exception.ContactNotFoundApplicationException;
import com.backintro.domain.contact.model.aggregate.Contact;
import com.backintro.domain.contact.model.valueobject.ContactId;
import com.backintro.domain.contact.port.repository.ContactRepository;

public class DeleteContactUseCase {
    private final ContactRepository repository;

    public DeleteContactUseCase(ContactRepository repository) {
        this.repository = repository;
    }

    public void execute(ContactId id) {
        Contact aggregate = repository.findById(id)
                .orElseThrow(() -> new ContactNotFoundApplicationException(id));
        repository.delete(aggregate);
    }
}
