package com.backintro.infrastructure.chatmessage.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.chatmessage.usecase.*;
import com.backintro.domain.chatmessage.port.repository.ChatMessageRepository;
import com.backintro.infrastructure.chatmessage.adapters.out.persistence.mappers.ChatMessagePersistenceMapper;
import com.backintro.infrastructure.chatmessage.adapters.out.persistence.repositories.*;

@Configuration
public class ChatMessageBeansConfig {

    @Bean
    public ChatMessagePersistenceMapper chatmessagePersistenceMapper() {
        return new ChatMessagePersistenceMapper();
    }

    @Bean
    public ChatMessageRepository chatmessageRepository(ChatMessageJpaRepository repository, ChatMessagePersistenceMapper mapper) {
        return new ChatMessageRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterChatMessageUseCase registerChatMessageUseCase(ChatMessageRepository repository) {
        return new RegisterChatMessageUseCase(repository);
    }

    @Bean
    public GetChatMessageByIdUseCase getChatMessageByIdUseCase(ChatMessageRepository repository) {
        return new GetChatMessageByIdUseCase(repository);
    }

    @Bean
    public ListChatMessageUseCase listChatMessageUseCase(ChatMessageRepository repository) {
        return new ListChatMessageUseCase(repository);
    }

    @Bean
    public UpdateChatMessageUseCase updateChatMessageUseCase(ChatMessageRepository repository) {
        return new UpdateChatMessageUseCase(repository);
    }

    @Bean
    public DeleteChatMessageUseCase deleteChatMessageUseCase(ChatMessageRepository repository) {
        return new DeleteChatMessageUseCase(repository);
    }
}
