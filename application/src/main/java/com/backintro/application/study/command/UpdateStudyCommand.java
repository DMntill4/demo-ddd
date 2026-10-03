package com.backintro.application.study.command;

import com.backintro.domain.study.model.valueobject.StudyId;

public record UpdateStudyCommand(StudyId id, String name) {
}
