package com.backintro.application.stateregion.usecase;

import com.backintro.application.stateregion.command.RegisterStateRegionCommand;
import com.backintro.application.stateregion.dto.StateRegionResponse;
import com.backintro.domain.stateregion.model.aggregate.StateRegion;
import com.backintro.domain.stateregion.port.repository.StateRegionRepository;

public class RegisterStateRegionUseCase {
    private final StateRegionRepository repository;

    public RegisterStateRegionUseCase(StateRegionRepository repository) {
        this.repository = repository;
    }

    public StateRegionResponse execute(RegisterStateRegionCommand command) {
        StateRegion aggregate = StateRegion.register(command.nameRegion(), command.codeRegion(), command.description(), command.countryId());
        StateRegion saved = repository.save(aggregate);
        return StateRegionResponse.fromDomain(saved);
    }
}
