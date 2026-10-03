package com.backintro.infrastructure.conversationsstatus.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.conversationsstatus.usecase.*;
import com.backintro.domain.conversationsstatus.port.repository.ConversationStatusRepository;
import com.backintro.infrastructure.conversationsstatus.adapters.out.persistence.mappers.ConversationStatusPersistenceMapper;
import com.backintro.infrastructure.conversationsstatus.adapters.out.persistence.repositories.*;

@Configuration
public class ConversationStatusBeansConfig {

    @Bean
    public ConversationStatusPersistenceMapper conversationsstatusPersistenceMapper() {
        return new ConversationStatusPersistenceMapper();
    }

    @Bean
    public ConversationStatusRepository conversationsstatusRepository(ConversationStatusJpaRepository repository, ConversationStatusPersistenceMapper mapper) {
        return new ConversationStatusRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterConversationStatusUseCase registerConversationStatusUseCase(ConversationStatusRepository repository) {
        return new RegisterConversationStatusUseCase(repository);
    }

    @Bean
    public GetConversationStatusByIdUseCase getConversationStatusByIdUseCase(ConversationStatusRepository repository) {
        return new GetConversationStatusByIdUseCase(repository);
    }

    @Bean
    public ListConversationStatusUseCase listConversationStatusUseCase(ConversationStatusRepository repository) {
        return new ListConversationStatusUseCase(repository);
    }

    @Bean
    public UpdateConversationStatusUseCase updateConversationStatusUseCase(ConversationStatusRepository repository) {
        return new UpdateConversationStatusUseCase(repository);
    }

    @Bean
    public DeleteConversationStatusUseCase deleteConversationStatusUseCase(ConversationStatusRepository repository) {
        return new DeleteConversationStatusUseCase(repository);
    }
}
