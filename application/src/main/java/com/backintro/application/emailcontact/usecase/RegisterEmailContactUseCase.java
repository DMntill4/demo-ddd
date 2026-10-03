package com.backintro.application.emailcontact.usecase;

import com.backintro.application.emailcontact.command.RegisterEmailContactCommand;
import com.backintro.application.emailcontact.dto.EmailContactResponse;
import com.backintro.domain.emailcontact.model.aggregate.EmailContact;
import com.backintro.domain.emailcontact.port.repository.EmailContactRepository;

public class RegisterEmailContactUseCase {
    private final EmailContactRepository repository;

    public RegisterEmailContactUseCase(EmailContactRepository repository) {
        this.repository = repository;
    }

    public EmailContactResponse execute(RegisterEmailContactCommand command) {
        EmailContact aggregate = EmailContact.register(command.contactId(), command.email(), command.notes());
        EmailContact saved = repository.save(aggregate);
        return EmailContactResponse.fromDomain(saved);
    }
}
