package com.backintro.infrastructure.patientallergy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.patientallergy.usecase.*;
import com.backintro.domain.patientallergy.port.repository.PatientAllergyRepository;
import com.backintro.infrastructure.patientallergy.adapters.out.persistence.mappers.PatientAllergyPersistenceMapper;
import com.backintro.infrastructure.patientallergy.adapters.out.persistence.repositories.*;

@Configuration
public class PatientAllergyBeansConfig {

    @Bean
    public PatientAllergyPersistenceMapper patientallergyPersistenceMapper() {
        return new PatientAllergyPersistenceMapper();
    }

    @Bean
    public PatientAllergyRepository patientallergyRepository(PatientAllergyJpaRepository repository, PatientAllergyPersistenceMapper mapper) {
        return new PatientAllergyRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterPatientAllergyUseCase registerPatientAllergyUseCase(PatientAllergyRepository repository) {
        return new RegisterPatientAllergyUseCase(repository);
    }

    @Bean
    public GetPatientAllergyByIdUseCase getPatientAllergyByIdUseCase(PatientAllergyRepository repository) {
        return new GetPatientAllergyByIdUseCase(repository);
    }

    @Bean
    public ListPatientAllergyUseCase listPatientAllergyUseCase(PatientAllergyRepository repository) {
        return new ListPatientAllergyUseCase(repository);
    }

    @Bean
    public UpdatePatientAllergyUseCase updatePatientAllergyUseCase(PatientAllergyRepository repository) {
        return new UpdatePatientAllergyUseCase(repository);
    }

    @Bean
    public DeletePatientAllergyUseCase deletePatientAllergyUseCase(PatientAllergyRepository repository) {
        return new DeletePatientAllergyUseCase(repository);
    }
}
