package org.adrianl.demospring.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {

    private long id;
    private String correo;
    private String password;
    private boolean admin;
    private String token;

}
