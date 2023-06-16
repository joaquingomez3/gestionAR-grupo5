
package Modelo;

import java.time.LocalDate;

public class Tarea {
    private int idTarea;
    private String nombre;
    private LocalDate fechaCreacion;
    private LocalDate fechaCierre;
    private boolean estado;
    private EquipoMiembros equipoM;
    private Proyecto proyecto;
    

    public Tarea(int idTarea, String nombre, LocalDate fechaCreacion, LocalDate fechaCierre, boolean estado, EquipoMiembros equipoM) {
        this.idTarea = idTarea;
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
        this.fechaCierre = fechaCierre;
        this.estado = estado;
        this.equipoM = equipoM;
    }

    public Tarea(String nombre, LocalDate fechaCreacion, LocalDate fechaCierre, boolean estado, EquipoMiembros equipoM) {
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
        this.fechaCierre = fechaCierre;
        this.estado = estado;
        this.equipoM = equipoM;
    }

    public Tarea() {
    }

    public Tarea(int idTarea, String nombre, EquipoMiembros equipoM, Proyecto proyecto) {
        this.idTarea = idTarea;
        this.nombre = nombre;
        this.equipoM = equipoM;
        this.proyecto = proyecto;
    }
       
    public int getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(int idTarea) {
        this.idTarea = idTarea;
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

    public LocalDate getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(LocalDate fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public EquipoMiembros getEquipoM() {
        return equipoM;
    }

    public void setEquipoM(EquipoMiembros equipoM) {
        this.equipoM = equipoM;
    }
    
    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    @Override
    public String toString() {
        return "Tarea{" + "idTarea=" + idTarea + ", nombre=" + nombre + ", fechaCreacion=" + fechaCreacion + ", fechaCierre=" + fechaCierre + ", estado=" + estado + ", equipoM=" + equipoM + '}';
    }
    
}
