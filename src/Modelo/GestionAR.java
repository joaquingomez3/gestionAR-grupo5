package Modelo;

import Control.ProyectoData;
import java.time.LocalDate;


public class GestionAR {

    public static void main(String[] args) {
        
        Proyecto proy = new Proyecto("Linux", "Creacion de software", LocalDate.of(2023, 5, 22),true);
        ProyectoData p = new ProyectoData();
        p.guardarProyecto(proy);
    }
    
}
