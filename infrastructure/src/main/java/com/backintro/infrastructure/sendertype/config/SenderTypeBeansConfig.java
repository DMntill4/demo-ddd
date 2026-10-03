package com.backintro.infrastructure.sendertype.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.sendertype.usecase.*;
import com.backintro.domain.sendertype.port.repository.SenderTypeRepository;
import com.backintro.infrastructure.sendertype.adapters.out.persistence.mappers.SenderTypePersistenceMapper;
import com.backintro.infrastructure.sendertype.adapters.out.persistence.repositories.*;

@Configuration
public class SenderTypeBeansConfig {

    @Bean
    public SenderTypePersistenceMapper sendertypePersistenceMapper() {
        return new SenderTypePersistenceMapper();
    }

    @Bean
    public SenderTypeRepository sendertypeRepository(SenderTypeJpaRepository repository, SenderTypePersistenceMapper mapper) {
        return new SenderTypeRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterSenderTypeUseCase registerSenderTypeUseCase(SenderTypeRepository repository) {
        return new RegisterSenderTypeUseCase(repository);
    }

    @Bean
    public GetSenderTypeByIdUseCase getSenderTypeByIdUseCase(SenderTypeRepository repository) {
        return new GetSenderTypeByIdUseCase(repository);
    }

    @Bean
    public ListSenderTypeUseCase listSenderTypeUseCase(SenderTypeRepository repository) {
        return new ListSenderTypeUseCase(repository);
    }

    @Bean
    public UpdateSenderTypeUseCase updateSenderTypeUseCase(SenderTypeRepository repository) {
        return new UpdateSenderTypeUseCase(repository);
    }

    @Bean
    public DeleteSenderTypeUseCase deleteSenderTypeUseCase(SenderTypeRepository repository) {
        return new DeleteSenderTypeUseCase(repository);
    }
}
