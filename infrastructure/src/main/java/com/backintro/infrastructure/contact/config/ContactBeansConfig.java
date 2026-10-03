package com.backintro.infrastructure.contact.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.contact.usecase.*;
import com.backintro.domain.contact.port.repository.ContactRepository;
import com.backintro.infrastructure.contact.adapters.out.persistence.mappers.ContactPersistenceMapper;
import com.backintro.infrastructure.contact.adapters.out.persistence.repositories.*;

@Configuration
public class ContactBeansConfig {

    @Bean
    public ContactPersistenceMapper contactPersistenceMapper() {
        return new ContactPersistenceMapper();
    }

    @Bean
    public ContactRepository contactRepository(ContactJpaRepository repository, ContactPersistenceMapper mapper) {
        return new ContactRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterContactUseCase registerContactUseCase(ContactRepository repository) {
        return new RegisterContactUseCase(repository);
    }

    @Bean
    public GetContactByIdUseCase getContactByIdUseCase(ContactRepository repository) {
        return new GetContactByIdUseCase(repository);
    }

    @Bean
    public ListContactUseCase listContactUseCase(ContactRepository repository) {
        return new ListContactUseCase(repository);
    }

    @Bean
    public UpdateContactUseCase updateContactUseCase(ContactRepository repository) {
        return new UpdateContactUseCase(repository);
    }

    @Bean
    public DeleteContactUseCase deleteContactUseCase(ContactRepository repository) {
        return new DeleteContactUseCase(repository);
    }
}
