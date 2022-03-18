package org.adrianl.javasoft.repository;

import org.adrianl.javasoft.dao.Proyecto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {
    Page<Proyecto> findAll(Pageable pageable);
}
