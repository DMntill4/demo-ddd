package com.backintro.infrastructure.documenttype.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.documenttype.usecase.*;
import com.backintro.domain.documenttype.port.repository.DocumentTypeRepository;
import com.backintro.infrastructure.documenttype.adapters.out.persistence.mappers.DocumentTypePersistenceMapper;
import com.backintro.infrastructure.documenttype.adapters.out.persistence.repositories.*;

@Configuration
public class DocumentTypeBeansConfig {

    @Bean
    public DocumentTypePersistenceMapper documenttypePersistenceMapper() {
        return new DocumentTypePersistenceMapper();
    }

    @Bean
    public DocumentTypeRepository documenttypeRepository(DocumentTypeJpaRepository repository, DocumentTypePersistenceMapper mapper) {
        return new DocumentTypeRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterDocumentTypeUseCase registerDocumentTypeUseCase(DocumentTypeRepository repository) {
        return new RegisterDocumentTypeUseCase(repository);
    }

    @Bean
    public GetDocumentTypeByIdUseCase getDocumentTypeByIdUseCase(DocumentTypeRepository repository) {
        return new GetDocumentTypeByIdUseCase(repository);
    }

    @Bean
    public ListDocumentTypeUseCase listDocumentTypeUseCase(DocumentTypeRepository repository) {
        return new ListDocumentTypeUseCase(repository);
    }

    @Bean
    public UpdateDocumentTypeUseCase updateDocumentTypeUseCase(DocumentTypeRepository repository) {
        return new UpdateDocumentTypeUseCase(repository);
    }

    @Bean
    public DeleteDocumentTypeUseCase deleteDocumentTypeUseCase(DocumentTypeRepository repository) {
        return new DeleteDocumentTypeUseCase(repository);
    }
}
