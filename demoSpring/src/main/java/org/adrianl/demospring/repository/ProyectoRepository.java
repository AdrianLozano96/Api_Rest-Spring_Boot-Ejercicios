package org.adrianl.demospring.repository;

import org.adrianl.demospring.model.Programador;
import org.adrianl.demospring.model.Proyecto;
import org.adrianl.demospring.model.Repositorio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {

    List<Proyecto> findByProgramador (Programador programador); //Porque el programador tiene una lista de proyectos

    List<Proyecto> findByRepositorio (Repositorio repositorio); //Porque el repositorio tiene una lista de proyectos

}
