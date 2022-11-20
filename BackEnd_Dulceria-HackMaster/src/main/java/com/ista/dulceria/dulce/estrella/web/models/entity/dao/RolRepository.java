package com.ista.dulceria.dulce.estrella.web.models.entity.dao;

import com.ista.dulceria.dulce.estrella.web.models.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {

}
