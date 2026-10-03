package com.backintro.infrastructure.empresa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backintro.application.empresa.usecase.*;
import com.backintro.domain.empresa.port.repository.EmpresaRepository;
import com.backintro.infrastructure.empresa.adapters.out.persistence.mappers.EmpresaPersistenceMapper;
import com.backintro.infrastructure.empresa.adapters.out.persistence.repositories.*;

@Configuration
public class EmpresaBeansConfig {

    @Bean
    public EmpresaPersistenceMapper empresaPersistenceMapper() {
        return new EmpresaPersistenceMapper();
    }

    @Bean
    public EmpresaRepository empresaRepository(EmpresaJpaRepository repository, EmpresaPersistenceMapper mapper) {
        return new EmpresaRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterEmpresaUseCase registerEmpresaUseCase(EmpresaRepository repository) {
        return new RegisterEmpresaUseCase(repository);
    }

    @Bean
    public GetEmpresaByIdUseCase getEmpresaByIdUseCase(EmpresaRepository repository) {
        return new GetEmpresaByIdUseCase(repository);
    }

    @Bean
    public ListEmpresaUseCase listEmpresaUseCase(EmpresaRepository repository) {
        return new ListEmpresaUseCase(repository);
    }

    @Bean
    public UpdateEmpresaUseCase updateEmpresaUseCase(EmpresaRepository repository) {
        return new UpdateEmpresaUseCase(repository);
    }

    @Bean
    public DeleteEmpresaUseCase deleteEmpresaUseCase(EmpresaRepository repository) {
        return new DeleteEmpresaUseCase(repository);
    }
}
