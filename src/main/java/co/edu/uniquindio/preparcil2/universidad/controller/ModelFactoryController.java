package co.edu.uniquindio.preparcil2.universidad.controller;

import co.edu.uniquindio.preparcil2.universidad.model.Programa;
import co.edu.uniquindio.preparcil2.universidad.model.Universidad;
import co.edu.uniquindio.preparcil2.universidad.utils.Persistencia;
import co.edu.uniquindio.preparcil2.universidad.utils.UniversidadUtils;

import java.io.IOException;
import java.util.List;

public class ModelFactoryController {

    Universidad universidad;
    private static class SingletonHolder {
        private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
    }
    public static ModelFactoryController getInstance() {
        return SingletonHolder.eINSTANCE;
    }
    public ModelFactoryController(){
        cargarResourceXML();
        guardarResourceXML();
    }private void cargarDatosBase(){
        universidad = UniversidadUtils.inicializarDatos();
    }
    public List<Programa> obtenerProgramas() {
        return universidad.getProgramas();
    }
    private void cargarResourceXML() {
        universidad = Persistencia.cargarRecursoUniversidadXML();
    }
    private void guardarResourceXML() {
        Persistencia.guardarRecursoUniversidadXML(universidad);
    }
    public String obtenerModalidadPresencial(String nombre){
        String modalidad = null;
        Persistencia persistencia = new Persistencia();
        for (String programa : universidad.getNombreProgramasPresencial()) {
            if (programa.equals(nombre)) {
                modalidad = persistencia.getModalidadPresencial();
            }
        }
        if (modalidad == null) {
            modalidad = persistencia.getModalidadDistancia();
        }
        return modalidad;
    }
    public List<Programa> buscarProgramas(String nombre){
        return Persistencia.cargarProgramasComun(nombre);
    }
}
