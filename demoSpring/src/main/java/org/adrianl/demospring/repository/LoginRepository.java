package org.adrianl.demospring.repository;

import org.adrianl.demospring.model.Login;
import org.adrianl.demospring.model.Programador;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login, Long>{
    //Page<Login> findByCorreoContainsIgnoreCase(String txt, Pageable pageable);
}
