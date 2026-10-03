package com.backintro.infrastructure.messagetype.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.messagetype.usecase.*;
import com.backintro.domain.messagetype.port.repository.MessageTypeRepository;
import com.backintro.infrastructure.messagetype.adapters.out.persistence.mappers.MessageTypePersistenceMapper;
import com.backintro.infrastructure.messagetype.adapters.out.persistence.repositories.*;

@Configuration
public class MessageTypeBeansConfig {

    @Bean
    public MessageTypePersistenceMapper messagetypePersistenceMapper() {
        return new MessageTypePersistenceMapper();
    }

    @Bean
    public MessageTypeRepository messagetypeRepository(MessageTypeJpaRepository repository, MessageTypePersistenceMapper mapper) {
        return new MessageTypeRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterMessageTypeUseCase registerMessageTypeUseCase(MessageTypeRepository repository) {
        return new RegisterMessageTypeUseCase(repository);
    }

    @Bean
    public GetMessageTypeByIdUseCase getMessageTypeByIdUseCase(MessageTypeRepository repository) {
        return new GetMessageTypeByIdUseCase(repository);
    }

    @Bean
    public ListMessageTypeUseCase listMessageTypeUseCase(MessageTypeRepository repository) {
        return new ListMessageTypeUseCase(repository);
    }

    @Bean
    public UpdateMessageTypeUseCase updateMessageTypeUseCase(MessageTypeRepository repository) {
        return new UpdateMessageTypeUseCase(repository);
    }

    @Bean
    public DeleteMessageTypeUseCase deleteMessageTypeUseCase(MessageTypeRepository repository) {
        return new DeleteMessageTypeUseCase(repository);
    }
}
