package org.adrianl.javasoft.dto;

import lombok.*;
import org.adrianl.javasoft.dao.Programador;
import org.adrianl.javasoft.dao.Proyecto;

import java.time.LocalDate;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TareaDto {
    private long id;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private double coste;
    private String programadorNombre;
    private String proyectoNombre;
}
