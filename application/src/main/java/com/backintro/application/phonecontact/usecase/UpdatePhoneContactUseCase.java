package com.backintro.application.phonecontact.usecase;

import com.backintro.application.phonecontact.command.UpdatePhoneContactCommand;
import com.backintro.application.phonecontact.dto.PhoneContactResponse;
import com.backintro.application.phonecontact.exception.PhoneContactNotFoundApplicationException;
import com.backintro.domain.phonecontact.model.aggregate.PhoneContact;
import com.backintro.domain.phonecontact.port.repository.PhoneContactRepository;

public class UpdatePhoneContactUseCase {
    private final PhoneContactRepository repository;

    public UpdatePhoneContactUseCase(PhoneContactRepository repository) {
        this.repository = repository;
    }

    public PhoneContactResponse execute(UpdatePhoneContactCommand command) {
        PhoneContact aggregate = repository.findById(command.id())
                .orElseThrow(() -> new PhoneContactNotFoundApplicationException(command.id()));
        aggregate.update(command.contactId(), command.phone(), command.notes());
        PhoneContact saved = repository.save(aggregate);
        return PhoneContactResponse.fromDomain(saved);
    }
}
