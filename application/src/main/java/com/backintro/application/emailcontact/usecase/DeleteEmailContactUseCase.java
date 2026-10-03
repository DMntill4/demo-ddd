package com.backintro.application.emailcontact.usecase;

import com.backintro.application.emailcontact.exception.EmailContactNotFoundApplicationException;
import com.backintro.domain.emailcontact.model.aggregate.EmailContact;
import com.backintro.domain.emailcontact.model.valueobject.EmailContactId;
import com.backintro.domain.emailcontact.port.repository.EmailContactRepository;

public class DeleteEmailContactUseCase {
    private final EmailContactRepository repository;

    public DeleteEmailContactUseCase(EmailContactRepository repository) {
        this.repository = repository;
    }

    public void execute(EmailContactId id) {
        EmailContact aggregate = repository.findById(id)
                .orElseThrow(() -> new EmailContactNotFoundApplicationException(id));
        repository.delete(aggregate);
    }
}
