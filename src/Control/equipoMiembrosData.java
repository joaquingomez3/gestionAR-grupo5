
package Control;

import Modelo.equipoMiembros;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;





public class equipoMiembrosData {
     private Connection con;
    
    public equipoMiembrosData(){
        con= Conexion.getConexion();
    }

    public void crearEquipoMiembros(equipoMiembros equipomiembros){
        try {
            String sql= "INSERT INTO equipomiembros(fechaIncorporacion, idEquipo, idMiembro) values(?,?,?)";
            
            PreparedStatement ps= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                     
            ps.setDate(1, Date.valueOf(equipomiembros.getFechaIncorporacion()));
            ps.setInt(2, equipomiembros.getEquipo().getIdEquipo());
            ps.setInt(3, equipomiembros.getMiembro().getIdMiembro());
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            
            if(rs.next()){
                equipomiembros.setIdMiembroEq(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Equipo miembros agregado.");
            }else
                System.out.println("El equipo miembros no se pudo agregar");
                
             ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "El equipo miembros no se pudo agregar");
            Logger.getLogger(ProyectoData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }



}



