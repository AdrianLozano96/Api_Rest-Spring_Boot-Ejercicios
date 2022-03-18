package org.adrianl.javasoft.dto;

import lombok.*;
import org.adrianl.javasoft.dao.Proyecto;
import org.adrianl.javasoft.dao.Tarea;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProgramadorDto {

    private long id;
    private String nombre;
    private String username;
    private String correo;
    private String avatar;

}
