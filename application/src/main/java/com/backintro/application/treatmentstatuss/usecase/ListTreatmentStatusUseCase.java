package com.backintro.application.treatmentstatuss.usecase;

import java.util.List;
import com.backintro.application.treatmentstatuss.dto.TreatmentStatusResponse;
import com.backintro.domain.treatmentstatuss.port.repository.TreatmentStatusRepository;

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
