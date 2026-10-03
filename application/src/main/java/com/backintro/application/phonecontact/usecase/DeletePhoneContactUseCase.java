package com.backintro.application.phonecontact.usecase;

import com.backintro.application.phonecontact.exception.PhoneContactNotFoundApplicationException;
import com.backintro.domain.phonecontact.model.aggregate.PhoneContact;
import com.backintro.domain.phonecontact.model.valueobject.PhoneContactId;
import com.backintro.domain.phonecontact.port.repository.PhoneContactRepository;

public class DeletePhoneContactUseCase {
    private final PhoneContactRepository repository;

    public DeletePhoneContactUseCase(PhoneContactRepository repository) {
        this.repository = repository;
    }

    public void execute(PhoneContactId id) {
        PhoneContact aggregate = repository.findById(id)
                .orElseThrow(() -> new PhoneContactNotFoundApplicationException(id));
        repository.delete(aggregate);
    }
}
