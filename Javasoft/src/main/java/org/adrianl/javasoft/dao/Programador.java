package org.adrianl.javasoft.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private String username;
    private String correo;
    private String avatar;
    private List<Tecnologia> tecnologias;
    private List<Tarea> tareas;
    //private Proyecto proyecto;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public long getId() {return id;}
    public void setId(long id) {this.id = id;}
    @Basic
    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    @Basic
    public String getUsername() {return username;}
    public void setUsername(String username) {this.username = username;}
    @Basic
    public String getCorreo() {return correo;}
    public void setCorreo(String correo) {this.correo = correo;}
    @Basic
    public String getAvatar() {return avatar;}
    public void setAvatar(String avatar) {this.avatar = avatar;}
    @ElementCollection
    @Enumerated(EnumType.STRING)
    public List<Tecnologia> getTecnologias() {return tecnologias;}
    public void setTecnologias(List<Tecnologia> tecnologias) {this.tecnologias = tecnologias;}

    @OneToMany(mappedBy = "programador")
    public List<Tarea> getTareas() {return tareas;}
    public void setTareas(List<Tarea> tareas) {this.tareas = tareas;}

    public void addTarea(Tarea tarea){
        this.tareas.add(tarea);
        tarea.setProgramador(this);
    }
    public void removeTarea(Tarea tarea){
        this.tareas.remove(tarea);
        tarea.setProgramador(null);
    }
/*
    @OneToOne
    @JoinColumn(name="proyecto", referencedColumnName = "id")
    public Proyecto getProyecto() {return proyecto;}
    public void setProyecto(Proyecto proyecto) {this.proyecto = proyecto;}

 */


}
