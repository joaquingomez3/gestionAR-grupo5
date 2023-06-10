
package Control;

import Modelo.Miembro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class MiembroData {
    private Connection con;
    
    public MiembroData(){
        con= Conexion.getConexion();
    }
    
    public void crearMiembro(Miembro miembro){
        try {
            String sql= "INSERT INTO miembro (dni, nombre, apellido, estado) values(?,?,?,?)";
            
            PreparedStatement ps= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                     
            ps.setInt(1, miembro.getDni());
            ps.setString(2, miembro.getNombre());
            ps.setString(3, miembro.getApellido());
            ps.setBoolean(4, miembro.isEstado());
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            
            if(rs.next()){
                miembro.setIdMiembro(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Miembro agregado.");
            }else
                System.out.println("El miembro no se pudo agregar");
                
             ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "El miembro no se pudo agregar");
            Logger.getLogger(ProyectoData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}