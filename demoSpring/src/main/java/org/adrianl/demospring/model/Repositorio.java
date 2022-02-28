package org.adrianl.demospring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="repositorio")
public class Repositorio {

    private long id;
    private String nombre;
    private String url;
    private List<Proyecto> proyectos;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {return id;}
    public void setId(long id) {this.id = id;}

    @Basic
    @Column(name="nombre", nullable=false)
    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    @Basic
    public String getUrl() {return url;}
    public void setUrl(String url) {this.url = url;}

    @OneToMany(mappedBy="repositorio")  //MIRAR BIEN
    //@JsonManagedReference   //Para romper la recursividad
    public List<Proyecto> getProyectos() {return proyectos;}
    public void setProyectos(List<Proyecto> proyectos) {this.proyectos = proyectos;}
}
