package com.backintro.domain.empresa.port.repository;

import java.util.List;
import java.util.Optional;
import com.backintro.domain.empresa.model.aggregate.Empresa;
import com.backintro.domain.empresa.model.valueobject.EmpresaId;

public interface EmpresaRepository {
    Empresa save(Empresa aggregate);
    Optional<Empresa> findById(EmpresaId id);
    List<Empresa> findAll();
    void delete(Empresa aggregate);
}
