package org.adrianl.demospring.repository;

import org.adrianl.demospring.model.Programador;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProgramadorRepository extends JpaRepository<Programador, Long> {
    //Meter método por nombre

    Optional<Programador> findByNombre(String nombre);  //El nombre del método debe concordar
                                                        // con el nombre del atributo a buscar


}
