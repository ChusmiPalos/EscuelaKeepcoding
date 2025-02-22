package io.keepcoding.app.escuela.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.keepcoding.app.escuela.entity.Alumno;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {

}
