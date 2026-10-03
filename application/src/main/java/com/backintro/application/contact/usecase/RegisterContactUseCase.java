package com.backintro.application.contact.usecase;

import com.backintro.application.contact.command.RegisterContactCommand;
import com.backintro.application.contact.dto.ContactResponse;
import com.backintro.domain.contact.model.aggregate.Contact;
import com.backintro.domain.contact.port.repository.ContactRepository;

public class RegisterContactUseCase {
    private final ContactRepository repository;

    public RegisterContactUseCase(ContactRepository repository) {
        this.repository = repository;
    }

    public ContactResponse execute(RegisterContactCommand command) {
        Contact aggregate = Contact.register(command.fullName(), command.email(), command.notes(), command.cityId(), command.createdBy(), command.updatedBy());
        Contact saved = repository.save(aggregate);
        return ContactResponse.fromDomain(saved);
    }
}
