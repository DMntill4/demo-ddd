package com.backintro.domain.citymunicipality.port.repository;

import java.util.List;
import java.util.Optional;
import com.backintro.domain.citymunicipality.model.aggregate.CityMunicipality;
import com.backintro.domain.citymunicipality.model.valueobject.CityMunicipalityId;

public interface CityMunicipalityRepository {
    CityMunicipality save(CityMunicipality aggregate);
    Optional<CityMunicipality> findById(CityMunicipalityId id);
    List<CityMunicipality> findAll();
    void delete(CityMunicipality aggregate);
}
