package org.adrianl.demospring.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="login")
public class Login {

    private long id;
    private String correo;
    private String password;
    private boolean admin;
    private String token;
    //private Programador programador;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id", nullable=false)
    public long getId() {return id;}
    public void setId(long id) {this.id = id;}

    @Basic
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Basic
    @Column(name="contraseña")
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {this.password = password;}

    @Basic
    @Column(name="administrador")
    public boolean isAdmin() {
        return admin;
    }
    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    @Basic
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
/*
    //LOS OneToOne MEJOR HACERLOS UNIDIRECCIONAL PARA LA HORA DE METER DATOS
    @OneToOne
    @JoinColumn(name="login_programador", referencedColumnName = "id")
    public Programador getProgramador() {return programador;}
    public void setProgramador(Programador programador) {this.programador = programador;}

 */
}
