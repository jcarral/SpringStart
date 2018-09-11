package com.jcarral.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jcarral.model.Empleado;

@Repository
public interface EmpleadoRepo extends JpaRepository<Empleado, Long>{

}
