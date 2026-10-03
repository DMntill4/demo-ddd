package com.backintro.infrastructure.assessmenttype.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.assessmenttype.usecase.*;
import com.backintro.domain.assessmenttype.port.repository.AssessmentTypeRepository;
import com.backintro.infrastructure.assessmenttype.adapters.out.persistence.mappers.AssessmentTypePersistenceMapper;
import com.backintro.infrastructure.assessmenttype.adapters.out.persistence.repositories.*;

@Configuration
public class AssessmentTypeBeansConfig {

    @Bean
    public AssessmentTypePersistenceMapper assessmenttypePersistenceMapper() {
        return new AssessmentTypePersistenceMapper();
    }

    @Bean
    public AssessmentTypeRepository assessmenttypeRepository(AssessmentTypeJpaRepository repository, AssessmentTypePersistenceMapper mapper) {
        return new AssessmentTypeRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterAssessmentTypeUseCase registerAssessmentTypeUseCase(AssessmentTypeRepository repository) {
        return new RegisterAssessmentTypeUseCase(repository);
    }

    @Bean
    public GetAssessmentTypeByIdUseCase getAssessmentTypeByIdUseCase(AssessmentTypeRepository repository) {
        return new GetAssessmentTypeByIdUseCase(repository);
    }

    @Bean
    public ListAssessmentTypeUseCase listAssessmentTypeUseCase(AssessmentTypeRepository repository) {
        return new ListAssessmentTypeUseCase(repository);
    }

    @Bean
    public UpdateAssessmentTypeUseCase updateAssessmentTypeUseCase(AssessmentTypeRepository repository) {
        return new UpdateAssessmentTypeUseCase(repository);
    }

    @Bean
    public DeleteAssessmentTypeUseCase deleteAssessmentTypeUseCase(AssessmentTypeRepository repository) {
        return new DeleteAssessmentTypeUseCase(repository);
    }
}
