package com.backintro.infrastructure.patient.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.patient.usecase.*;
import com.backintro.domain.patient.port.repository.PatientRepository;
import com.backintro.infrastructure.patient.adapters.out.persistence.mappers.PatientPersistenceMapper;
import com.backintro.infrastructure.patient.adapters.out.persistence.repositories.*;

@Configuration
public class PatientBeansConfig {

    @Bean
    public PatientPersistenceMapper patientPersistenceMapper() {
        return new PatientPersistenceMapper();
    }

    @Bean
    public PatientRepository patientRepository(PatientJpaRepository repository, PatientPersistenceMapper mapper) {
        return new PatientRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterPatientUseCase registerPatientUseCase(PatientRepository repository) {
        return new RegisterPatientUseCase(repository);
    }

    @Bean
    public GetPatientByIdUseCase getPatientByIdUseCase(PatientRepository repository) {
        return new GetPatientByIdUseCase(repository);
    }

    @Bean
    public ListPatientUseCase listPatientUseCase(PatientRepository repository) {
        return new ListPatientUseCase(repository);
    }

    @Bean
    public UpdatePatientUseCase updatePatientUseCase(PatientRepository repository) {
        return new UpdatePatientUseCase(repository);
    }

    @Bean
    public DeletePatientUseCase deletePatientUseCase(PatientRepository repository) {
        return new DeletePatientUseCase(repository);
    }
}
