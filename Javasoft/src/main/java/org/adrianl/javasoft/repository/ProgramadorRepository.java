package org.adrianl.javasoft.repository;

import org.adrianl.javasoft.dao.Programador;
import org.adrianl.javasoft.dao.Tarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProgramadorRepository extends JpaRepository<Programador, Long> {
    Optional<Programador> findByNombre(String nombre);
    //Optional<Tarea> find(String nombre);

    //Page<Programador> findAll(Pageable pageable);
}
