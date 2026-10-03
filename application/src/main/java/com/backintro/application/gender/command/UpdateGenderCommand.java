package com.backintro.application.gender.command;

import com.backintro.domain.gender.model.valueobject.GenderId;

public record UpdateGenderCommand(GenderId id, String description) {
}
