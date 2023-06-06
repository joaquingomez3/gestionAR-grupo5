
package Modelo;

public class Miembro {
   private int idMiembro;
   private int dni;
   private String apellido;
   private String nombre;
   private boolean estado;

    public Miembro() {
    }

    public Miembro(int idMiembro, int dni, String apellido, String nombre, boolean estado) {
        this.idMiembro = idMiembro;
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Miembro(int dni, String apellido, String nombre, boolean estado) {
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.estado = estado;
    }

    public int getIdMiembro() {
        return idMiembro;
    }

    public void setIdMiembro(int idMiembro) {
        this.idMiembro = idMiembro;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Miembro{" + "idMiembro=" + idMiembro + ", dni=" + dni + ", apellido=" + apellido + ", nombre=" + nombre + ", estado=" + estado + '}';
    }
   
}
