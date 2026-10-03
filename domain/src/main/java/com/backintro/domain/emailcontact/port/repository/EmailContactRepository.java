package com.backintro.domain.emailcontact.port.repository;

import java.util.List;
import java.util.Optional;
import com.backintro.domain.emailcontact.model.aggregate.EmailContact;
import com.backintro.domain.emailcontact.model.valueobject.EmailContactId;

public interface EmailContactRepository {
    EmailContact save(EmailContact aggregate);
    Optional<EmailContact> findById(EmailContactId id);
    List<EmailContact> findAll();
    void delete(EmailContact aggregate);
}
