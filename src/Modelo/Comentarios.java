
package Modelo;

import java.time.LocalDate;

public class Comentarios {
    private int idComentario;
    private String comentario;
    private LocalDate fechaAvance;
    private Tarea tarea;

    public Comentarios() {
    }

    public Comentarios(int idComentario, String comentario, LocalDate fechaAvance, Tarea tarea) {
        this.idComentario = idComentario;
        this.comentario = comentario;
        this.fechaAvance = fechaAvance;
        this.tarea = tarea;
    }

    public Comentarios(String comentario, LocalDate fechaAvance, Tarea tarea) {
        this.comentario = comentario;
        this.fechaAvance = fechaAvance;
        this.tarea = tarea;
    }

    public int getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(int idComentario) {
        this.idComentario = idComentario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public LocalDate getFechaAvance() {
        return fechaAvance;
    }

    public void setFechaAvance(LocalDate fechaAvance) {
        this.fechaAvance = fechaAvance;
    }

    public Tarea getTarea() {
        return tarea;
    }

    public void setTarea(Tarea tarea) {
        this.tarea = tarea;
    }

    @Override
    public String toString() {
        return "Comentarios{" + "idComentario=" + idComentario + ", comentario=" + comentario + ", fechaAvance=" + fechaAvance + ", tarea=" + tarea + '}';
    }
    
}
