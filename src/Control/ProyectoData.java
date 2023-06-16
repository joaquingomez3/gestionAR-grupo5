
package Control;

import Modelo.Proyecto;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
    
     public List<Proyecto> listarTareas(){
              List<Proyecto> proyectos = new ArrayList<>();    

            try {
                String query = "SELECT * FROM proyecto";
                PreparedStatement ps;
                ps = con.prepareStatement(query);
                ResultSet rs = ps.executeQuery();

                while(rs.next()){

                    Proyecto proy = new Proyecto();
                    proy.setIdProyecto(rs.getInt("idProyecto"));
                    proy.setNombre(rs.getString("nombre"));
                    proy.setDescripcion(rs.getString("descripcion"));
                    proy.setFechaInicio(rs.getDate("fechaInicio").toLocalDate());
                    proy.setEstado(rs.getBoolean("estado"));
                                 
                    proyectos.add(proy);

                }      
                ps.close();
            }catch (SQLException ex) {
                JOptionPane.showInternalMessageDialog(null, "Error proyectos "+ex.getMessage());
            }
            return proyectos;

        }
     
    public void actualizarProyecto(Proyecto proyecto) {
        try {
            String sql = "UPDATE proyecto SET nombre = ?, descripcion = ?, fechaInicio = ?, estado = ? WHERE idProyecto = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, proyecto.getNombre());
            ps.setString(2, proyecto.getDescripcion());
            ps.setDate(3, Date.valueOf(proyecto.getFechaInicio()));
            ps.setBoolean(4, proyecto.isEstado());
            ps.setInt(5, proyecto.getIdProyecto());

            int filasActualizadas = ps.executeUpdate();

            if (filasActualizadas > 0) {
                JOptionPane.showMessageDialog(null, "Proyecto actualizado.");
            } else {
                System.out.println("El proyecto no se pudo actualizar.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "El proyecto no se pudo actualizar.");
            Logger.getLogger(ProyectoData.class.getName()).log(Level.SEVERE, null, ex);
        }
}

    public void eliminarProyecto(int idProyecto) {
        try {
            String sql = "DELETE FROM proyecto WHERE idProyecto = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, idProyecto);

            int filasEliminadas = ps.executeUpdate();

            if (filasEliminadas > 0) {
                JOptionPane.showMessageDialog(null, "Proyecto eliminado.");
            } else {
                System.out.println("El proyecto no se pudo eliminar.");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "El proyecto no se pudo eliminar.");
            Logger.getLogger(ProyectoData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Proyecto obtenerProyecto(int idProyecto) throws SQLException {
    Proyecto proyecto = null;
    String sql = "SELECT * FROM proyecto WHERE idProyecto = ?";
    
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    try {
        ps = con.prepareStatement(sql);
        ps.setInt(1, idProyecto);
        rs = ps.executeQuery();
        
        if (rs.next()) {
            proyecto = new Proyecto();
            proyecto.setIdProyecto(rs.getInt("idProyecto"));
            proyecto.setNombre(rs.getString("nombre"));
            proyecto.setDescripcion(rs.getString("descripcion"));
            proyecto.setFechaInicio(rs.getDate("fechaInicio").toLocalDate());
            proyecto.setEstado(rs.getBoolean("estado"));
        }
    } finally {
        if (rs != null) {
            rs.close();
        }
        if (ps != null) {
            ps.close();
        }
    }
    
    return proyecto;
}

   


}
