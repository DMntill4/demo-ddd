package com.backintro.infrastructure.study.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.study.usecase.*;
import com.backintro.domain.study.port.repository.StudyRepository;
import com.backintro.infrastructure.study.adapters.out.persistence.mappers.StudyPersistenceMapper;
import com.backintro.infrastructure.study.adapters.out.persistence.repositories.*;

@Configuration
public class StudyBeansConfig {

    @Bean
    public StudyPersistenceMapper studyPersistenceMapper() {
        return new StudyPersistenceMapper();
    }

    @Bean
    public StudyRepository studyRepository(StudyJpaRepository repository, StudyPersistenceMapper mapper) {
        return new StudyRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterStudyUseCase registerStudyUseCase(StudyRepository repository) {
        return new RegisterStudyUseCase(repository);
    }

    @Bean
    public GetStudyByIdUseCase getStudyByIdUseCase(StudyRepository repository) {
        return new GetStudyByIdUseCase(repository);
    }

    @Bean
    public ListStudyUseCase listStudyUseCase(StudyRepository repository) {
        return new ListStudyUseCase(repository);
    }

    @Bean
    public UpdateStudyUseCase updateStudyUseCase(StudyRepository repository) {
        return new UpdateStudyUseCase(repository);
    }

    @Bean
    public DeleteStudyUseCase deleteStudyUseCase(StudyRepository repository) {
        return new DeleteStudyUseCase(repository);
    }
}
