package com.backintro.application.emailcontact.usecase;

import com.backintro.application.emailcontact.command.UpdateEmailContactCommand;
import com.backintro.application.emailcontact.dto.EmailContactResponse;
import com.backintro.application.emailcontact.exception.EmailContactNotFoundApplicationException;
import com.backintro.domain.emailcontact.model.aggregate.EmailContact;
import com.backintro.domain.emailcontact.port.repository.EmailContactRepository;

public class UpdateEmailContactUseCase {
    private final EmailContactRepository repository;

    public UpdateEmailContactUseCase(EmailContactRepository repository) {
        this.repository = repository;
    }

    public EmailContactResponse execute(UpdateEmailContactCommand command) {
        EmailContact aggregate = repository.findById(command.id())
                .orElseThrow(() -> new EmailContactNotFoundApplicationException(command.id()));
        aggregate.update(command.contactId(), command.email(), command.notes());
        EmailContact saved = repository.save(aggregate);
        return EmailContactResponse.fromDomain(saved);
    }
}
