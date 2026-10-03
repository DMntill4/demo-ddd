package com.backintro.application.clinicalrecord.usecase;

import java.util.List;
import com.backintro.application.clinicalrecord.dto.ClinicalRecordResponse;
import com.backintro.domain.clinicalrecord.port.repository.ClinicalRecordRepository;

public class ListClinicalRecordUseCase {
    private final ClinicalRecordRepository repository;

    public ListClinicalRecordUseCase(ClinicalRecordRepository repository) {
        this.repository = repository;
    }

    public List<ClinicalRecordResponse> execute() {
        return repository.findAll()
                .stream()
                .map(ClinicalRecordResponse::fromDomain)
                .toList();
    }
}
