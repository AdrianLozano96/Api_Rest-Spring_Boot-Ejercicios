package org.adrianl.javasoft.repository;

import org.adrianl.javasoft.dao.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TareaRepository extends JpaRepository<Tarea, Long> {

}
