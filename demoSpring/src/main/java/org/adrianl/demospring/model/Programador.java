package org.adrianl.demospring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="programador")
public class Programador {

    private long id;
    private String nombre;
    private double salario;
    private List<String> tecnologias;
    private List<Proyecto> proyectos;
    private Login login;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {return id;}
    public void setId(long id) {this.id = id;}

    @Basic
    @Column(name = "nombre", nullable = false)
    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    @Basic
    public double getSalario() {return salario;}
    public void setSalario(double salario) {this.salario = salario;}

    @ElementCollection
    //@ElementCollection(fetch = FetchType.EAGER)
    //@Column(name = "tecnologias_dominadas")   //No lo pongas que se crea otra tabla
    public List<String> getTecnologias() {return tecnologias;}
    public void setTecnologias(List<String> tecnologias) {this.tecnologias = tecnologias;}


    //Cada programador tiene varios proyectos
    @OneToMany(mappedBy = "programador")
    //@JsonManagedReference   //Para romper la recursividad
    //@OneToMany(fetch = FetchType.EAGER, mappedBy = "programador", cascade = CascadeType.PERSIST)
    // @OneToMany(mappedBy = "programador", cascade = [CascadeType.ALL], orphanRemoval = true)
    public List<Proyecto> getProyectos() {return proyectos;}
    public void setProyectos(List<Proyecto> proyectos) {this.proyectos = proyectos;}

    @OneToOne
    @JoinColumn(name="programador_login", referencedColumnName = "id")
    public Login getLogin() {return login;}
    public void setLogin(Login login) {this.login = login;}


    public void addProyecto(Proyecto proyecto){
        proyectos.add(proyecto);
    }
    public void removeProyecto(Proyecto proyecto){
        proyectos.remove(proyecto);
    }

}
