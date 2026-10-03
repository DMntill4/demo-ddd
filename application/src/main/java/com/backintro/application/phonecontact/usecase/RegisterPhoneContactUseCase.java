package com.backintro.application.phonecontact.usecase;

import com.backintro.application.phonecontact.command.RegisterPhoneContactCommand;
import com.backintro.application.phonecontact.dto.PhoneContactResponse;
import com.backintro.domain.phonecontact.model.aggregate.PhoneContact;
import com.backintro.domain.phonecontact.port.repository.PhoneContactRepository;

public class RegisterPhoneContactUseCase {
    private final PhoneContactRepository repository;

    public RegisterPhoneContactUseCase(PhoneContactRepository repository) {
        this.repository = repository;
    }

    public PhoneContactResponse execute(RegisterPhoneContactCommand command) {
        PhoneContact aggregate = PhoneContact.register(command.contactId(), command.phone(), command.notes());
        PhoneContact saved = repository.save(aggregate);
        return PhoneContactResponse.fromDomain(saved);
    }
}
