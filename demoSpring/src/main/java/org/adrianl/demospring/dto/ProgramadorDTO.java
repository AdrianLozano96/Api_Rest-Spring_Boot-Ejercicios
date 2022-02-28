package org.adrianl.demospring.dto;

import lombok.*;
import org.adrianl.demospring.model.Login;
import org.adrianl.demospring.model.Proyecto;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProgramadorDTO {

    private long id;
    private String nombre;
    private double salario;
    private Login login;
    /*
    private long id;
    @NotBlank(message = "Debes introducir un dni")
     @Email(regexp = ".*@.*\\..*", message = "Email debe ser correcto")
    private String correo;
    @Min(message = "El salario no puede ser negativo", value = 0)
    private Double salario;
     */
}
