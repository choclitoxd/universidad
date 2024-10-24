package co.edu.uniquindio.preparcil2.universidad.controller;

import co.edu.uniquindio.preparcil2.universidad.model.Programa;

import java.util.List;

public class UniversidadController {
    ModelFactoryController modelFactoryController;

    public UniversidadController() {
        modelFactoryController = ModelFactoryController.getInstance();
    }
    public List<Programa> obteneProgramas() {
        return modelFactoryController.obtenerProgramas();
    }
    public String obtenerModalidad(String nombrePrograma) {
        return modelFactoryController.obtenerModalidadPresencial(nombrePrograma);
    }

    public List<Programa> bucarProgramas(String text) {
        return modelFactoryController.buscarProgramas(text);
    }
}
