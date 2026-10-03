package com.backintro.infrastructure.clinicalnote.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.clinicalnote.usecase.*;
import com.backintro.domain.clinicalnote.port.repository.ClinicalNoteRepository;
import com.backintro.infrastructure.clinicalnote.adapters.out.persistence.mappers.ClinicalNotePersistenceMapper;
import com.backintro.infrastructure.clinicalnote.adapters.out.persistence.repositories.*;

@Configuration
public class ClinicalNoteBeansConfig {

    @Bean
    public ClinicalNotePersistenceMapper clinicalnotePersistenceMapper() {
        return new ClinicalNotePersistenceMapper();
    }

    @Bean
    public ClinicalNoteRepository clinicalnoteRepository(ClinicalNoteJpaRepository repository, ClinicalNotePersistenceMapper mapper) {
        return new ClinicalNoteRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterClinicalNoteUseCase registerClinicalNoteUseCase(ClinicalNoteRepository repository) {
        return new RegisterClinicalNoteUseCase(repository);
    }

    @Bean
    public GetClinicalNoteByIdUseCase getClinicalNoteByIdUseCase(ClinicalNoteRepository repository) {
        return new GetClinicalNoteByIdUseCase(repository);
    }

    @Bean
    public ListClinicalNoteUseCase listClinicalNoteUseCase(ClinicalNoteRepository repository) {
        return new ListClinicalNoteUseCase(repository);
    }

    @Bean
    public UpdateClinicalNoteUseCase updateClinicalNoteUseCase(ClinicalNoteRepository repository) {
        return new UpdateClinicalNoteUseCase(repository);
    }

    @Bean
    public DeleteClinicalNoteUseCase deleteClinicalNoteUseCase(ClinicalNoteRepository repository) {
        return new DeleteClinicalNoteUseCase(repository);
    }
}
