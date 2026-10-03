package com.backintro.application.escalationstatus.exception;

import com.backintro.application.common.exception.ApplicationException;
import com.backintro.domain.escalationstatus.model.valueobject.EscalationStatusId;

public class EscalationStatusNotFoundApplicationException extends ApplicationException {
    public EscalationStatusNotFoundApplicationException(EscalationStatusId id) {
        super("EscalationStatus with id " + id.value() + " was not found.");
    }
}
