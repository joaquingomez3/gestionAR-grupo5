
package Control;

import Modelo.Comentarios;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class ComentariosData {
    private Connection con;
    
    public ComentariosData(){
        con= Conexion.getConexion();
    }

    public void registrarComentario(Comentarios com){
        try {
            String sql= "INSERT INTO comentarios(comentario, fechaAvance, idTarea) values(?,?,?)";
            
            PreparedStatement ps= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            ps.setString(1, com.getComentario());
            ps.setDate(2, Date.valueOf(com.getFechaAvance()));
            ps.setInt(3, com.getTarea().getIdTarea());
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            
            if(rs.next()){
                com.setIdComentario(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Comentario agregado.");
            }else
                System.out.println("El comentario no se pudo agregar");
                
             ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "El comentario no se pudo agregar");
            Logger.getLogger(ProyectoData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

    