package com.backend.portafoliobackend.security.repository;

import com.backend.portafoliobackend.security.entity.Rol;
import com.backend.portafoliobackend.security.enums.RolNombre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolNombre(RolNombre rolNombre);


}
