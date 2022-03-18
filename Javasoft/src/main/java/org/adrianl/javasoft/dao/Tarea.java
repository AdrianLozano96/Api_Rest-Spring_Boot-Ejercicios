package org.adrianl.javasoft.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="tarea")
public class Tarea {
    private long id;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private double coste;
    private List<String> actividad;
    private Programador programador;
    private Proyecto proyecto;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public long getId() {return id;}
    public void setId(long id) {this.id = id;}
    @Basic
    @CreationTimestamp
    public LocalDate getFechaInicio() {return fechaInicio;}
    public void setFechaInicio(LocalDate fechaInicio) {this.fechaInicio = fechaInicio;}
    @Basic
    @CreationTimestamp
    public LocalDate getFechaFin() {return fechaFin;}
    public void setFechaFin(LocalDate fechaFin) {this.fechaFin = fechaFin;}
    @Basic
    public double getCoste() {return coste;}
    public void setCoste(double coste) {this.coste = coste;}
    @ElementCollection
    public List<String> getActividad() {return actividad;}
    public void setActividad(List<String> actividad) {this.actividad = actividad;}

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="programador", referencedColumnName = "id")
    public Programador getProgramador() {return programador;}
    public void setProgramador(Programador programador) {this.programador = programador;}

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="proyecto", referencedColumnName="id")
    public Proyecto getProyecto() {return proyecto;}
    public void setProyecto(Proyecto proyecto) {this.proyecto = proyecto;}

}