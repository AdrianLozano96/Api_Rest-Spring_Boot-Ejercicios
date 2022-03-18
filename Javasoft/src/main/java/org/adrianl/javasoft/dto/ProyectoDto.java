package org.adrianl.javasoft.dto;

import lombok.*;
import org.adrianl.javasoft.dao.Programador;
import org.adrianl.javasoft.dao.Tarea;

import java.time.LocalDate;
import java.util.List;
@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProyectoDto {

    private long id;
    private String nombre;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Programador responsable;
    private List<Tarea> tareas;
}
