package com.backintro.infrastructure.riskassessment.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.riskassessment.usecase.*;
import com.backintro.domain.riskassessment.port.repository.RiskAssessmentRepository;
import com.backintro.infrastructure.riskassessment.adapters.out.persistence.mappers.RiskAssessmentPersistenceMapper;
import com.backintro.infrastructure.riskassessment.adapters.out.persistence.repositories.*;

@Configuration
public class RiskAssessmentBeansConfig {

    @Bean
    public RiskAssessmentPersistenceMapper riskassessmentPersistenceMapper() {
        return new RiskAssessmentPersistenceMapper();
    }

    @Bean
    public RiskAssessmentRepository riskassessmentRepository(RiskAssessmentJpaRepository repository, RiskAssessmentPersistenceMapper mapper) {
        return new RiskAssessmentRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterRiskAssessmentUseCase registerRiskAssessmentUseCase(RiskAssessmentRepository repository) {
        return new RegisterRiskAssessmentUseCase(repository);
    }

    @Bean
    public GetRiskAssessmentByIdUseCase getRiskAssessmentByIdUseCase(RiskAssessmentRepository repository) {
        return new GetRiskAssessmentByIdUseCase(repository);
    }

    @Bean
    public ListRiskAssessmentUseCase listRiskAssessmentUseCase(RiskAssessmentRepository repository) {
        return new ListRiskAssessmentUseCase(repository);
    }

    @Bean
    public UpdateRiskAssessmentUseCase updateRiskAssessmentUseCase(RiskAssessmentRepository repository) {
        return new UpdateRiskAssessmentUseCase(repository);
    }

    @Bean
    public DeleteRiskAssessmentUseCase deleteRiskAssessmentUseCase(RiskAssessmentRepository repository) {
        return new DeleteRiskAssessmentUseCase(repository);
    }
}
