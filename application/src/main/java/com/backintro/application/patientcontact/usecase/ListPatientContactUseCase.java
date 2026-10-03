package com.backintro.application.patientcontact.usecase;

import java.util.List;
import com.backintro.application.patientcontact.dto.PatientContactResponse;
import com.backintro.domain.patientcontact.port.repository.PatientContactRepository;

public class ListPatientContactUseCase {
    private final PatientContactRepository repository;

    public ListPatientContactUseCase(PatientContactRepository repository) {
        this.repository = repository;
    }

    public List<PatientContactResponse> execute() {
        return repository.findAll()
                .stream()
                .map(PatientContactResponse::fromDomain)
                .toList();
    }
}
