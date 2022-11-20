package com.ista.dulceria.dulce.estrella.web.models.entity.service;

import com.ista.dulceria.dulce.estrella.web.models.entity.Empresa;

import java.util.List;

public interface EmpresaService {

    public Empresa save(Empresa empresa);

    public List<Empresa> findAll();

    public Empresa findById(Long id);

    public void delete(Long id);

    public Empresa actualizar(Empresa empresa);

}
