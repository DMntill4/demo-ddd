package com.backintro.infrastructure.chataisettings.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.chataisettings.usecase.*;
import com.backintro.domain.chataisettings.port.repository.ChatAiSettingsRepository;
import com.backintro.infrastructure.chataisettings.adapters.out.persistence.mappers.ChatAiSettingsPersistenceMapper;
import com.backintro.infrastructure.chataisettings.adapters.out.persistence.repositories.*;

@Configuration
public class ChatAiSettingsBeansConfig {

    @Bean
    public ChatAiSettingsPersistenceMapper chataisettingsPersistenceMapper() {
        return new ChatAiSettingsPersistenceMapper();
    }

    @Bean
    public ChatAiSettingsRepository chataisettingsRepository(ChatAiSettingsJpaRepository repository, ChatAiSettingsPersistenceMapper mapper) {
        return new ChatAiSettingsRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterChatAiSettingsUseCase registerChatAiSettingsUseCase(ChatAiSettingsRepository repository) {
        return new RegisterChatAiSettingsUseCase(repository);
    }

    @Bean
    public GetChatAiSettingsByIdUseCase getChatAiSettingsByIdUseCase(ChatAiSettingsRepository repository) {
        return new GetChatAiSettingsByIdUseCase(repository);
    }

    @Bean
    public ListChatAiSettingsUseCase listChatAiSettingsUseCase(ChatAiSettingsRepository repository) {
        return new ListChatAiSettingsUseCase(repository);
    }

    @Bean
    public UpdateChatAiSettingsUseCase updateChatAiSettingsUseCase(ChatAiSettingsRepository repository) {
        return new UpdateChatAiSettingsUseCase(repository);
    }

    @Bean
    public DeleteChatAiSettingsUseCase deleteChatAiSettingsUseCase(ChatAiSettingsRepository repository) {
        return new DeleteChatAiSettingsUseCase(repository);
    }
}
