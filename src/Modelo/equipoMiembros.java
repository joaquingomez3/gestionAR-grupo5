
package Modelo;

import java.time.LocalDate;

public class equipoMiembros {
    private int idMiembroEq;
    private LocalDate fechaIncorporacion;
    private Equipo equipo;
    private Miembro miembro;

    public equipoMiembros(int idMiembroEq, LocalDate fechaIncorporacion, Equipo equipo, Miembro miembro) {
        this.idMiembroEq = idMiembroEq;
        this.fechaIncorporacion = fechaIncorporacion;
        this.equipo = equipo;
        this.miembro = miembro;
    }

    public equipoMiembros(LocalDate fechaIncorporacion, Equipo equipo, Miembro miembro) {
        this.fechaIncorporacion = fechaIncorporacion;
        this.equipo = equipo;
        this.miembro = miembro;
    }
    
    public equipoMiembros() {
    }

    public int getIdMiembroEq() {
        return idMiembroEq;
    }

    public void setIdMiembroEq(int idMiembroEq) {
        this.idMiembroEq = idMiembroEq;
    }

    public LocalDate getFechaIncorporacion() {
        return fechaIncorporacion;
    }

    public void setFechaIncorporacion(LocalDate fechaIncorporacion) {
        this.fechaIncorporacion = fechaIncorporacion;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Miembro getMiembro() {
        return miembro;
    }

    public void setMiembro(Miembro miembro) {
        this.miembro = miembro;
    }

    @Override
    public String toString() {
        return "equipoMiembros{" + "idMiembroEq=" + idMiembroEq + ", fechaIncorporacion=" + fechaIncorporacion + ", equipo=" + equipo + ", miembro=" + miembro + '}';
    }
    
}
