package com.backintro.application.phonecontact.usecase;

import com.backintro.application.phonecontact.dto.PhoneContactResponse;
import com.backintro.application.phonecontact.exception.PhoneContactNotFoundApplicationException;
import com.backintro.domain.phonecontact.model.valueobject.PhoneContactId;
import com.backintro.domain.phonecontact.port.repository.PhoneContactRepository;

public class GetPhoneContactByIdUseCase {
    private final PhoneContactRepository repository;

    public GetPhoneContactByIdUseCase(PhoneContactRepository repository) {
        this.repository = repository;
    }

    public PhoneContactResponse execute(PhoneContactId id) {
        return repository.findById(id)
                .map(PhoneContactResponse::fromDomain)
                .orElseThrow(() -> new PhoneContactNotFoundApplicationException(id));
    }
}
