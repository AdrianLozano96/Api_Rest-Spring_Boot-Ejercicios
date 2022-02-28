package org.adrianl.demospring.repository;

import org.adrianl.demospring.model.Programador;
import org.adrianl.demospring.model.Repositorio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioRepository extends JpaRepository<Repositorio, Long> {
}
