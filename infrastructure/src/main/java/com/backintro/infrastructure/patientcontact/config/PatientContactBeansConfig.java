package com.backintro.infrastructure.patientcontact.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.patientcontact.usecase.*;
import com.backintro.domain.patientcontact.port.repository.PatientContactRepository;
import com.backintro.infrastructure.patientcontact.adapters.out.persistence.mappers.PatientContactPersistenceMapper;
import com.backintro.infrastructure.patientcontact.adapters.out.persistence.repositories.*;

@Configuration
public class PatientContactBeansConfig {

    @Bean
    public PatientContactPersistenceMapper patientcontactPersistenceMapper() {
        return new PatientContactPersistenceMapper();
    }

    @Bean
    public PatientContactRepository patientcontactRepository(PatientContactJpaRepository repository, PatientContactPersistenceMapper mapper) {
        return new PatientContactRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterPatientContactUseCase registerPatientContactUseCase(PatientContactRepository repository) {
        return new RegisterPatientContactUseCase(repository);
    }

    @Bean
    public GetPatientContactByIdUseCase getPatientContactByIdUseCase(PatientContactRepository repository) {
        return new GetPatientContactByIdUseCase(repository);
    }

    @Bean
    public ListPatientContactUseCase listPatientContactUseCase(PatientContactRepository repository) {
        return new ListPatientContactUseCase(repository);
    }

    @Bean
    public UpdatePatientContactUseCase updatePatientContactUseCase(PatientContactRepository repository) {
        return new UpdatePatientContactUseCase(repository);
    }

    @Bean
    public DeletePatientContactUseCase deletePatientContactUseCase(PatientContactRepository repository) {
        return new DeletePatientContactUseCase(repository);
    }
}
