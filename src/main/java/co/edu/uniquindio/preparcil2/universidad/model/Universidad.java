package co.edu.uniquindio.preparcil2.universidad.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Universidad implements Serializable {
    private List<Programa> programas  = new ArrayList<>();
    private List<String> nombreProgramasPresencial = new ArrayList<>();
    public List<Programa> getProgramas() {
        return programas;
    }

    public void setProgramas(List<Programa> programas) {
        this.programas = programas;
    }

    public List<String> getNombreProgramasPresencial() {
        return nombreProgramasPresencial;
    }

    public void setNombreProgramasPresencial(List<String> nombreProgramas) {
        this.nombreProgramasPresencial = nombreProgramas;
    }
}
