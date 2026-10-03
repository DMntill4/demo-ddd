package com.backintro.domain.escalationsstatus.exception;

import com.backintro.domain.common.exception.DomainException;
import com.backintro.domain.escalationsstatus.model.valueobject.EscalationStatusId;

public class EscalationStatusNotFoundException extends DomainException {
    public EscalationStatusNotFoundException(EscalationStatusId id) {
        super("EscalationStatus with id " + id.value() + " was not found.");
    }
}
