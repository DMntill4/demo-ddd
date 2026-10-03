package com.backintro.application.priority.command;

import com.backintro.domain.priority.model.valueobject.PriorityId;

public record UpdatePriorityCommand(PriorityId id, String namePriority) {
}
