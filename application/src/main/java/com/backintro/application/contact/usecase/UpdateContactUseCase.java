package com.backintro.application.contact.usecase;

import com.backintro.application.contact.command.UpdateContactCommand;
import com.backintro.application.contact.dto.ContactResponse;
import com.backintro.application.contact.exception.ContactNotFoundApplicationException;
import com.backintro.domain.contact.model.aggregate.Contact;
import com.backintro.domain.contact.port.repository.ContactRepository;

public class UpdateContactUseCase {
    private final ContactRepository repository;

    public UpdateContactUseCase(ContactRepository repository) {
        this.repository = repository;
    }

    public ContactResponse execute(UpdateContactCommand command) {
        Contact aggregate = repository.findById(command.id())
                .orElseThrow(() -> new ContactNotFoundApplicationException(command.id()));
        aggregate.update(command.fullName(), command.email(), command.notes(), command.cityId(), command.createdBy(), command.updatedBy());
        Contact saved = repository.save(aggregate);
        return ContactResponse.fromDomain(saved);
    }
}
