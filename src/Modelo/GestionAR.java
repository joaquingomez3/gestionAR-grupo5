package Modelo;

import Control.ComentariosData;
import Control.EquipoData;
import Control.MiembroData;
import Control.ProyectoData;
import Control.TareaData;
import java.time.LocalDate;
import Control.EquipoMiembrosData;

public class GestionAR {

    public static void main(String[] args) {
        
        Proyecto proyec = new Proyecto(1,"WINDOWS", "Creacion de software", LocalDate.of(2023, 5, 31),true);
        Proyecto proy = new Proyecto("Linux", "Creacion de software", LocalDate.of(2023, 5, 22),true);
        ProyectoData p = new ProyectoData();
//        p.guardarProyecto(proy);


        Miembro mie = new Miembro(1, 43567921, "Perez", "Juan",true);
        Miembro miem = new Miembro(4, 32333222, "Messi", "Lionel",true);
        MiembroData m = new MiembroData();
//        m.crearMiembro(miem);

        Equipo equi = new Equipo(1, proyec, "ABC", LocalDate.of(2023, 6, 9),true);
        Equipo equip = new Equipo(4, proyec, "DHC", LocalDate.of(2023, 5, 22),true);
        EquipoData e = new EquipoData();
//        e.crearEquipo(equip);
        
        EquipoMiembros equipom = new EquipoMiembros(4, LocalDate.of(2023, 5, 31),equi,mie);
        EquipoMiembrosData em = new EquipoMiembrosData();
//        em.crearEquipoMiembros(equipom);

        Tarea tarea = new Tarea(7, "correcion", LocalDate.of(2023, 5, 31), LocalDate.of(2023, 6, 30), true, equipom);
        TareaData t = new TareaData();
//        t.asignarTarea(tarea);

        Comentarios com = new Comentarios("actualizar etapa 2",LocalDate.of(2023, 6, 15),tarea);
        ComentariosData c = new ComentariosData();
//        c.registrarComentario(com);

        Tarea tar = new Tarea(7, "correcion completada", LocalDate.of(2023, 5, 31), LocalDate.of(2023, 6, 30), false, equipom);
        TareaData ta = new TareaData();
//        t.actualizarTarea(tar);
    }
    
}
