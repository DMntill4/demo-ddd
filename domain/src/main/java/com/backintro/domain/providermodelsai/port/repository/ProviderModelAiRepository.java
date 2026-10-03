package com.backintro.domain.providermodelsai.port.repository;

import java.util.List;
import java.util.Optional;
import com.backintro.domain.providermodelsai.model.aggregate.ProviderModelAi;
import com.backintro.domain.providermodelsai.model.valueobject.ProviderModelAiId;

public interface ProviderModelAiRepository {
    ProviderModelAi save(ProviderModelAi aggregate);
    Optional<ProviderModelAi> findById(ProviderModelAiId id);
    List<ProviderModelAi> findAll();
    void delete(ProviderModelAi aggregate);
}
