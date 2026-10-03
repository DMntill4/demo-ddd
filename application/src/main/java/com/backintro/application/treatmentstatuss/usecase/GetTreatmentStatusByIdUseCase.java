package com.backintro.application.treatmentstatuss.usecase;

import com.backintro.application.treatmentstatuss.dto.TreatmentStatusResponse;
import com.backintro.application.treatmentstatuss.exception.TreatmentStatusNotFoundApplicationException;
import com.backintro.domain.treatmentstatuss.model.valueobject.TreatmentStatusId;
import com.backintro.domain.treatmentstatuss.port.repository.TreatmentStatusRepository;

public class GetTreatmentStatusByIdUseCase {
    private final TreatmentStatusRepository repository;

    public GetTreatmentStatusByIdUseCase(TreatmentStatusRepository repository) {
        this.repository = repository;
    }

    public TreatmentStatusResponse execute(TreatmentStatusId id) {
        return repository.findById(id)
                .map(TreatmentStatusResponse::fromDomain)
                .orElseThrow(() -> new TreatmentStatusNotFoundApplicationException(id));
    }
}
