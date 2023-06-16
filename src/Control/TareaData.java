
package Control;

import Modelo.EquipoMiembros;
import Modelo.Tarea;
import Control.EquipoMiembrosData;
import Modelo.Equipo;
import Modelo.Miembro;
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
                JOptionPane.showMessageDialog(null, "Tarea asignada.");
            }else
                System.out.println("La tarea no se pudo asignar.");
                
             ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "La tarea no se pudo asignar.");
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
    
    public void eliminarTarea(int idTarea) {
    try {
        String sql = "UPDATE tarea SET estado = 0 WHERE idTarea = ?;";
        
        PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, idTarea);
        ps.executeUpdate();
        
        ps.close();
        
    } catch (SQLException ex) {
        Logger.getLogger(TareaData.class.getName()).log(Level.SEVERE, null, ex);
    }
} 
    
    public List<Tarea> listarTareas(){
              List<Tarea> tarea = new ArrayList<>();    

            try {
                String query = "SELECT * FROM tarea";
                PreparedStatement ps;
                ps = con.prepareStatement(query);
                ResultSet rs = ps.executeQuery();

                while(rs.next()){

                    Tarea tar = new Tarea();
                    tar.setIdTarea(rs.getInt("idTarea"));
                    tar.setNombre(rs.getString("nombre"));
                    tar.setFechaCreacion(rs.getDate("fechaCreacion").toLocalDate());
                    tar.setFechaCierre(rs.getDate("fechaNaCierre").toLocalDate());
                    tar.setEstado(rs.getBoolean("estado"));
//                    tar.setEquipoM(rs.getInt("idMiembroEq"));
                                 
                    tarea.add(tar);

                }      
                ps.close();
            }catch (SQLException ex) {
                JOptionPane.showInternalMessageDialog(null, "Error tareas "+ex.getMessage());
            }
            return tarea;

        }
    
    public Tarea obtenerTarea(int idTarea) 
        throws SQLException {
    Tarea tarea = null;
    String sql = "SELECT * FROM tarea WHERE idTarea = ?";
    
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    try {
        ps = con.prepareStatement(sql);
        ps.setInt(1, idTarea);
        rs = ps.executeQuery();
        
        if (rs.next()) {
            tarea = new Tarea();
            tarea.setIdTarea(rs.getInt("idTarea"));
            tarea.setNombre(rs.getString("nombre"));
            tarea.setFechaCreacion(rs.getDate("fechaCreacion").toLocalDate());
            tarea.setFechaCierre(rs.getDate("fechaCierre").toLocalDate());
            tarea.setEstado(rs.getBoolean("estado"));
            
            int equipoMiembrosId = rs.getInt("equipoMiembrosId");
            // Aquí debes obtener el objeto equipoMiembros correspondiente al ID
            
            EquipoMiembros equipoM = obtenerEquipoMiembros(equipoMiembrosId);
            tarea.setEquipoM(equipoM);
        }
    } finally {
        if (rs != null) {
            rs.close();
        }
        if (ps != null) {
            ps.close();
        }
    }
    
    return tarea;
}

    public EquipoMiembros obtenerEquipoMiembros(int equipoMiembrosId) 
        throws SQLException {
        EquipoMiembros equipoM = null;
        String sql = "SELECT * FROM equipoMiembros WHERE idMiembroEq = ?";

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, equipoMiembrosId);
            rs = ps.executeQuery();

            if (rs.next()) {
                equipoM = new EquipoMiembros();
                equipoM.setIdMiembroEq(rs.getInt("idMiembroEq"));
                equipoM.setFechaIncorporacion(rs.getDate("fechaIncorporacion").toLocalDate());
                equipoM.getEquipo().setIdEquipo(rs.getInt("idEquipo"));
                equipoM.getMiembro().setIdMiembro(rs.getInt("idMiembro"));

            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
        }

        return equipoM;
    }
    
    
}
