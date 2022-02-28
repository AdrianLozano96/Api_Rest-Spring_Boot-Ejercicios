package org.adrianl.demospring.dto;

import lombok.*;
import org.adrianl.demospring.model.Proyecto;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RepositorioDTO {

    private long id;
    private String nombre;
    private String url;

}
