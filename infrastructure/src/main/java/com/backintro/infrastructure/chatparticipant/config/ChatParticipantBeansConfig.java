package com.backintro.infrastructure.chatparticipant.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.chatparticipant.usecase.*;
import com.backintro.domain.chatparticipant.port.repository.ChatParticipantRepository;
import com.backintro.infrastructure.chatparticipant.adapters.out.persistence.mappers.ChatParticipantPersistenceMapper;
import com.backintro.infrastructure.chatparticipant.adapters.out.persistence.repositories.*;

@Configuration
public class ChatParticipantBeansConfig {

    @Bean
    public ChatParticipantPersistenceMapper chatparticipantPersistenceMapper() {
        return new ChatParticipantPersistenceMapper();
    }

    @Bean
    public ChatParticipantRepository chatparticipantRepository(ChatParticipantJpaRepository repository, ChatParticipantPersistenceMapper mapper) {
        return new ChatParticipantRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterChatParticipantUseCase registerChatParticipantUseCase(ChatParticipantRepository repository) {
        return new RegisterChatParticipantUseCase(repository);
    }

    @Bean
    public GetChatParticipantByIdUseCase getChatParticipantByIdUseCase(ChatParticipantRepository repository) {
        return new GetChatParticipantByIdUseCase(repository);
    }

    @Bean
    public ListChatParticipantUseCase listChatParticipantUseCase(ChatParticipantRepository repository) {
        return new ListChatParticipantUseCase(repository);
    }

    @Bean
    public UpdateChatParticipantUseCase updateChatParticipantUseCase(ChatParticipantRepository repository) {
        return new UpdateChatParticipantUseCase(repository);
    }

    @Bean
    public DeleteChatParticipantUseCase deleteChatParticipantUseCase(ChatParticipantRepository repository) {
        return new DeleteChatParticipantUseCase(repository);
    }
}
