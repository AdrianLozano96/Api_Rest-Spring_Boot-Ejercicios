package org.adrianl.demospring.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="proyecto")
public class Proyecto {

    private long id;
    private String nombre;
    private String descripcion;
    private LocalDate fecha;    //Si eso ponerlo como String y más facil
    private Repositorio repositorio;    //Al que pertenece
    private Programador programador;    //Quien lo crea

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {return id;}
    public void setId(long id) {this.id = id;}

    @Basic
    @Column(name="nombre", nullable=false)
    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    @Basic
    @Column(name="descripcion")
    public String getDescripcion() {return descripcion;}
    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}

    @Basic
    @CreationTimestamp
    //@CreatedDate
    public LocalDate getFecha() {return fecha;} //CURRENT_TIMESTAMP en SQL
    public void setFecha(LocalDate fecha) {this.fecha = fecha;}

    //@JsonBackReference // Evitar recursividad
    //@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")    //poner sobre la clase
    @JsonIgnore// Ignora este lado de la relacón
    //Un proyecto tiene un repositorio y cada repositorio puede tener varios proyectos
    @ManyToOne  //Cascada
    @JoinColumn(name="repositorio_id", referencedColumnName="id")
    public Repositorio getRepositorio() {return repositorio;}
    public void setRepositorio(Repositorio repositorio) {this.repositorio = repositorio;}

    //Cada proyecto pertenece a un programador
    //@JsonBackReference    //Evitar recursividad //Qutar s no el one to
    @JsonIgnore
    @ManyToOne  //Cascada
    @JoinColumn(name="programador_id", referencedColumnName="id")
    public Programador getProgramador() {return programador;}
    public void setProgramador(Programador programador) {this.programador = programador;}
}
