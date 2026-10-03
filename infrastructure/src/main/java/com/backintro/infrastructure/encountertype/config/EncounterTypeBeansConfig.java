package com.backintro.infrastructure.encountertype.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.encountertype.usecase.*;
import com.backintro.domain.encountertype.port.repository.EncounterTypeRepository;
import com.backintro.infrastructure.encountertype.adapters.out.persistence.mappers.EncounterTypePersistenceMapper;
import com.backintro.infrastructure.encountertype.adapters.out.persistence.repositories.*;

@Configuration
public class EncounterTypeBeansConfig {

    @Bean
    public EncounterTypePersistenceMapper encountertypePersistenceMapper() {
        return new EncounterTypePersistenceMapper();
    }

    @Bean
    public EncounterTypeRepository encountertypeRepository(EncounterTypeJpaRepository repository, EncounterTypePersistenceMapper mapper) {
        return new EncounterTypeRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterEncounterTypeUseCase registerEncounterTypeUseCase(EncounterTypeRepository repository) {
        return new RegisterEncounterTypeUseCase(repository);
    }

    @Bean
    public GetEncounterTypeByIdUseCase getEncounterTypeByIdUseCase(EncounterTypeRepository repository) {
        return new GetEncounterTypeByIdUseCase(repository);
    }

    @Bean
    public ListEncounterTypeUseCase listEncounterTypeUseCase(EncounterTypeRepository repository) {
        return new ListEncounterTypeUseCase(repository);
    }

    @Bean
    public UpdateEncounterTypeUseCase updateEncounterTypeUseCase(EncounterTypeRepository repository) {
        return new UpdateEncounterTypeUseCase(repository);
    }

    @Bean
    public DeleteEncounterTypeUseCase deleteEncounterTypeUseCase(EncounterTypeRepository repository) {
        return new DeleteEncounterTypeUseCase(repository);
    }
}
