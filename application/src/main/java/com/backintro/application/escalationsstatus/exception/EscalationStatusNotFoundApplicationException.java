package com.backintro.application.escalationsstatus.exception;

import com.backintro.application.common.exception.ApplicationException;
import com.backintro.domain.escalationsstatus.model.valueobject.EscalationStatusId;

public class EscalationStatusNotFoundApplicationException extends ApplicationException {
    public EscalationStatusNotFoundApplicationException(EscalationStatusId id) {
        super("EscalationStatus with id " + id.value() + " was not found.");
    }
}
