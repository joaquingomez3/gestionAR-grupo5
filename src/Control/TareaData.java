
package Control;

import Modelo.Tarea;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class TareaData {
    private Connection con;
    
    public TareaData(){
        con= Conexion.getConexion();
    }
    
    public void asignarTarea(Tarea tarea){
        try {
            String sql= "INSERT INTO tarea(nombre, fechaCreacion, fechaCierre, estado, idMiembroEq) values(?,?,?,?,?)";
            
            PreparedStatement ps= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            ps.setString(1, tarea.getNombre());
            ps.setDate(2, Date.valueOf(tarea.getFechaCreacion()));
            ps.setDate(3, Date.valueOf(tarea.getFechaCierre()));
            ps.setBoolean(4, tarea.isEstado());
            ps.setInt(5, tarea.getEquipoM().getIdMiembroEq());
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            
            if(rs.next()){
                tarea.setIdTarea(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Tarea agregada.");
            }else
                System.out.println("La tarea no se pudo agregar");
                
             ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "La tarea no se pudo agregar");
            Logger.getLogger(ProyectoData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void actualizarTarea(Tarea tarea){
        try {
            String sql= "UPDATE tarea SET  nombre=?, fechaCreacion=?, fechaCierre=?, estado=?, idMiembroEq=? WHERE tarea.idTarea=?";
            
            PreparedStatement ps= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, tarea.getNombre());
            ps.setDate(2, Date.valueOf( tarea.getFechaCreacion()));
            ps.setDate(3, Date.valueOf( tarea.getFechaCierre()));            
            ps.setBoolean(4, tarea.isEstado());
            ps.setInt(5, tarea.getEquipoM().getIdMiembroEq());
            ps.setInt(6, tarea.getIdTarea());
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Tarea actualizada");
            ps.close();
            
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "La tarea no se pudo actualizar");
            Logger.getLogger(TareaData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
