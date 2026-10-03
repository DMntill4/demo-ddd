package com.backintro.application.mentalstatusexam.usecase;

import com.backintro.application.mentalstatusexam.command.UpdateMentalStatusExamCommand;
import com.backintro.application.mentalstatusexam.dto.MentalStatusExamResponse;
import com.backintro.application.mentalstatusexam.exception.MentalStatusExamNotFoundApplicationException;
import com.backintro.domain.mentalstatusexam.model.aggregate.MentalStatusExam;
import com.backintro.domain.mentalstatusexam.port.repository.MentalStatusExamRepository;

public class UpdateMentalStatusExamUseCase {
    private final MentalStatusExamRepository repository;

    public UpdateMentalStatusExamUseCase(MentalStatusExamRepository repository) {
        this.repository = repository;
    }

    public MentalStatusExamResponse execute(UpdateMentalStatusExamCommand command) {
        MentalStatusExam aggregate = repository.findById(command.id())
                .orElseThrow(() -> new MentalStatusExamNotFoundApplicationException(command.id()));
        aggregate.update(command.encounterId(), command.appearance(), command.behavior(), command.attitude(), command.consciousness(), command.orientation(), command.attention(), command.memory(), command.speech(), command.mood(), command.affect(), command.thoughtProcess(), command.thoughtContent(), command.perception(), command.judgment(), command.insight(), command.psychomotorActivity(), command.observations(), command.createdBy());
        MentalStatusExam saved = repository.save(aggregate);
        return MentalStatusExamResponse.fromDomain(saved);
    }
}
