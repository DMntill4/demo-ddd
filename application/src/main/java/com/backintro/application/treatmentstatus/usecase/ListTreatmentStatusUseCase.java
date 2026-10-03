package com.backintro.application.treatmentstatus.usecase;

import java.util.List;
import com.backintro.application.treatmentstatus.dto.TreatmentStatusResponse;
import com.backintro.domain.treatmentstatus.port.repository.TreatmentStatusRepository;

public class ListTreatmentStatusUseCase {
    private final TreatmentStatusRepository repository;

    public ListTreatmentStatusUseCase(TreatmentStatusRepository repository) {
        this.repository = repository;
    }

    public List<TreatmentStatusResponse> execute() {
        return repository.findAll()
                .stream()
                .map(TreatmentStatusResponse::fromDomain)
                .toList();
    }
}
