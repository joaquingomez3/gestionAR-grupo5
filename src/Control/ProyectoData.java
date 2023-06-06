
package Control;

import Modelo.Proyecto;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ProyectoData {
    
    private Connection con;
    
    public ProyectoData(){
        con= Conexion.getConexion();
    }
    
    public void guardarProyecto(Proyecto proyecto){
        try {
            String sql= "INSERT INTO proyecto (nombre, descripcion, fechaInicio, estado) values(?,?,?,?)";
            
            PreparedStatement ps= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                     
            ps.setString(1, proyecto.getNombre());
            ps.setString(2, proyecto.getDescripcion());
            ps.setDate(3, Date.valueOf( proyecto.getFechaInicio()));
            ps.setBoolean(4, proyecto.isEstado());
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            
            if(rs.next()){
                proyecto.setIdProyecto(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Proyecto guardado.");
            }else
                System.out.println("El proyecto no se pudo guardar");
                
             ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "El proyecto no se pudo guardar");
            Logger.getLogger(ProyectoData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
