package com.backintro.infrastructure.aimodel.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.aimodel.usecase.*;
import com.backintro.domain.aimodel.port.repository.AiModelRepository;
import com.backintro.infrastructure.aimodel.adapters.out.persistence.mappers.AiModelPersistenceMapper;
import com.backintro.infrastructure.aimodel.adapters.out.persistence.repositories.*;

@Configuration
public class AiModelBeansConfig {

    @Bean
    public AiModelPersistenceMapper aimodelPersistenceMapper() {
        return new AiModelPersistenceMapper();
    }

    @Bean
    public AiModelRepository aimodelRepository(AiModelJpaRepository repository, AiModelPersistenceMapper mapper) {
        return new AiModelRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterAiModelUseCase registerAiModelUseCase(AiModelRepository repository) {
        return new RegisterAiModelUseCase(repository);
    }

    @Bean
    public GetAiModelByIdUseCase getAiModelByIdUseCase(AiModelRepository repository) {
        return new GetAiModelByIdUseCase(repository);
    }

    @Bean
    public ListAiModelUseCase listAiModelUseCase(AiModelRepository repository) {
        return new ListAiModelUseCase(repository);
    }

    @Bean
    public UpdateAiModelUseCase updateAiModelUseCase(AiModelRepository repository) {
        return new UpdateAiModelUseCase(repository);
    }

    @Bean
    public DeleteAiModelUseCase deleteAiModelUseCase(AiModelRepository repository) {
        return new DeleteAiModelUseCase(repository);
    }
}
