package org.adrianl.demospring.repository;

import org.adrianl.demospring.model.Login;
import org.adrianl.demospring.model.Programador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login, Long>{
}
