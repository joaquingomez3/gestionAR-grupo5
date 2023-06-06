
package Modelo;

import java.time.LocalDate;

public class Equipo {
   private Proyecto proyecto;
   private int idEquipo;
   private String nombre;
   private LocalDate fechaCreacion;
   private boolean estado;

    public Equipo() {
    }

    public Equipo(Proyecto proyecto, int idEquipo, String nombre, LocalDate fechaCreacion, boolean estado) {
        this.proyecto = proyecto;
        this.idEquipo = idEquipo;
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
        this.estado = estado;
    }

    public Equipo(Proyecto proyecto, String nombre, LocalDate fechaCreacion, boolean estado) {
        this.proyecto = proyecto;
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
        this.estado = estado;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Equipo{" + "proyecto=" + proyecto + ", idEquipo=" + idEquipo + ", nombre=" + nombre + ", fechaCreacion=" + fechaCreacion + ", estado=" + estado + '}';
    }
   
}
