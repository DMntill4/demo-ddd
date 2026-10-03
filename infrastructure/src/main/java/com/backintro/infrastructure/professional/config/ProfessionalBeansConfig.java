package com.backintro.infrastructure.professional.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.professional.usecase.*;
import com.backintro.domain.professional.port.repository.ProfessionalRepository;
import com.backintro.infrastructure.professional.adapters.out.persistence.mappers.ProfessionalPersistenceMapper;
import com.backintro.infrastructure.professional.adapters.out.persistence.repositories.*;

@Configuration
public class ProfessionalBeansConfig {

    @Bean
    public ProfessionalPersistenceMapper professionalPersistenceMapper() {
        return new ProfessionalPersistenceMapper();
    }

    @Bean
    public ProfessionalRepository professionalRepository(ProfessionalJpaRepository repository, ProfessionalPersistenceMapper mapper) {
        return new ProfessionalRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterProfessionalUseCase registerProfessionalUseCase(ProfessionalRepository repository) {
        return new RegisterProfessionalUseCase(repository);
    }

    @Bean
    public GetProfessionalByIdUseCase getProfessionalByIdUseCase(ProfessionalRepository repository) {
        return new GetProfessionalByIdUseCase(repository);
    }

    @Bean
    public ListProfessionalUseCase listProfessionalUseCase(ProfessionalRepository repository) {
        return new ListProfessionalUseCase(repository);
    }

    @Bean
    public UpdateProfessionalUseCase updateProfessionalUseCase(ProfessionalRepository repository) {
        return new UpdateProfessionalUseCase(repository);
    }

    @Bean
    public DeleteProfessionalUseCase deleteProfessionalUseCase(ProfessionalRepository repository) {
        return new DeleteProfessionalUseCase(repository);
    }
}
