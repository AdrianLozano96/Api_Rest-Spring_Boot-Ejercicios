package org.adrianl.demospring.dto;

import lombok.*;
import org.adrianl.demospring.model.Programador;
import org.adrianl.demospring.model.Repositorio;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProyectoDTO {

    private long id;
    private String nombre;
    private String descripcion;
    private LocalDate fecha;    //Si eso ponerlo como String y más facil
    private Repositorio repositorio;    //Al que pertenece
    private Programador programador;    //Quien lo crea

}
