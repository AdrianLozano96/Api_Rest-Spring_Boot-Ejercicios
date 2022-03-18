package org.adrianl.javasoft.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="proyecto")
public class Proyecto {
    private long id;
    private String nombre;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    //@Column(name = "coste", nullable = true)
    private double coste; //suma del coste de las tareas que lo forman
    private List<Tarea> tareas;
    private Programador responsable;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public long getId() {return id;}
    public void setId(long id) {this.id = id;}
    @Basic
    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    @Basic
    @CreationTimestamp
    public LocalDate getFechaInicio() {return fechaInicio;}
    public void setFechaInicio(LocalDate fechaInicio) {this.fechaInicio = fechaInicio;}
    @Basic
    @CreationTimestamp
    public LocalDate getFechaFin() {return fechaFin;}
    public void setFechaFin(LocalDate fechaFin) {this.fechaFin = fechaFin;}
    @Basic
    public double getCoste() {
        //tareas.forEach(t->this.coste+=t.getCoste());
        for(int i=0;i<tareas.size();i++){
            this.coste+=tareas.get(i).getCoste();
        }
        return this.coste;
    }
    public void setCoste( double coste) {this.coste = coste;}

    @OneToMany(mappedBy = "proyecto")
    public List<Tarea> getTareas() {return tareas;}
    public void setTareas(List<Tarea> tareas) {this.tareas = tareas;}

    @OneToOne
    @JoinColumn(name="programador", referencedColumnName = "id")
    public Programador getResponsable() {return responsable;}
    public void setResponsable(Programador responsable) {this.responsable = responsable;}

}
