package com.backintro.infrastructure.chatairun.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.chatairun.usecase.*;
import com.backintro.domain.chatairun.port.repository.ChatAiRunRepository;
import com.backintro.infrastructure.chatairun.adapters.out.persistence.mappers.ChatAiRunPersistenceMapper;
import com.backintro.infrastructure.chatairun.adapters.out.persistence.repositories.*;

@Configuration
public class ChatAiRunBeansConfig {

    @Bean
    public ChatAiRunPersistenceMapper chatairunPersistenceMapper() {
        return new ChatAiRunPersistenceMapper();
    }

    @Bean
    public ChatAiRunRepository chatairunRepository(ChatAiRunJpaRepository repository, ChatAiRunPersistenceMapper mapper) {
        return new ChatAiRunRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterChatAiRunUseCase registerChatAiRunUseCase(ChatAiRunRepository repository) {
        return new RegisterChatAiRunUseCase(repository);
    }

    @Bean
    public GetChatAiRunByIdUseCase getChatAiRunByIdUseCase(ChatAiRunRepository repository) {
        return new GetChatAiRunByIdUseCase(repository);
    }

    @Bean
    public ListChatAiRunUseCase listChatAiRunUseCase(ChatAiRunRepository repository) {
        return new ListChatAiRunUseCase(repository);
    }

    @Bean
    public UpdateChatAiRunUseCase updateChatAiRunUseCase(ChatAiRunRepository repository) {
        return new UpdateChatAiRunUseCase(repository);
    }

    @Bean
    public DeleteChatAiRunUseCase deleteChatAiRunUseCase(ChatAiRunRepository repository) {
        return new DeleteChatAiRunUseCase(repository);
    }
}
