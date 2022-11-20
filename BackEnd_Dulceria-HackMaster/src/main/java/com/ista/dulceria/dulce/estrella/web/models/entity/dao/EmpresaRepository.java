package com.ista.dulceria.dulce.estrella.web.models.entity.dao;

import com.ista.dulceria.dulce.estrella.web.models.entity.Empresa;
import com.ista.dulceria.dulce.estrella.web.models.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

}
