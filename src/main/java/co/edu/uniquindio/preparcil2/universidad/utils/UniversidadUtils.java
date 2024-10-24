package co.edu.uniquindio.preparcil2.universidad.utils;

import co.edu.uniquindio.preparcil2.universidad.model.Programa;
import co.edu.uniquindio.preparcil2.universidad.model.Universidad;

public class UniversidadUtils {
    public static Universidad inicializarDatos(){
        Universidad universidad = new Universidad();
        Programa programa = new Programa();
        programa.setAdscritos(25);
        programa.setNombre("Matematicas");
        universidad.getProgramas().add(programa);
        universidad.getNombreProgramasPresencial().add(programa.getNombre());

        programa = new Programa();
        programa.setAdscritos(35);
        programa.setNombre("Programacion");
        universidad.getProgramas().add(programa);

        programa = new Programa();
        programa.setAdscritos(15);
        programa.setNombre("Calculo");
        universidad.getProgramas().add(programa);
        universidad.getNombreProgramasPresencial().add(programa.getNombre());
        return universidad;
    }
}
