package co.edu.uniquindio.preparcil2.universidad.utils;

import co.edu.uniquindio.preparcil2.universidad.model.Programa;
import co.edu.uniquindio.preparcil2.universidad.model.Universidad;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.io.FileInputStream;
import java.beans.XMLDecoder;

public class Persistencia {
    public static final String RUTA_ARCHIVO_MODELO_BILLETERA_BINARIO = "persistencia/model.dat";
    public static final String RUTA_ARCHIVO_PROGRAMA = "persistencia/archivoProgramas.txt";
    public static final String RUTA_ARCHIVO_LOG = "persistencia/log/BilleteraLog.txt";
    public static final String RUTA_ARCHIVO_MODELO_UNIVERSIDAD_XML = "persistencia/model.xml";
    public static final String RUTA_ARCHIVO_MODELO_PROPIEDADES = "persistencia/modalidades.txt";
    private String modalidadDistancia;
    private String modalidadPresencial;

    

    public String getModalidadDistancia() {
        return modalidadDistancia;
    }

    public String getModalidadPresencial() {
        return modalidadPresencial;
    }

    public static Universidad cargarRecursoUniversidadXML() {

        Universidad universidad = null;

        try {
            universidad = (Universidad) ArchivoUtil.cargarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_UNIVERSIDAD_XML);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return universidad;

    }
    public static void guardarRecursoUniversidadXML(Universidad universidad) {
        try {
            ArchivoUtil.salvarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_UNIVERSIDAD_XML, universidad);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public Persistencia(){
        modalidadesLoader();
    }
    private void modalidadesLoader() {
        Properties propiedades = new Properties();
        try {
            propiedades.load(new FileInputStream(RUTA_ARCHIVO_MODELO_PROPIEDADES));
            modalidadDistancia = propiedades.getProperty("modalidad.distancia");
            modalidadPresencial = propiedades.getProperty("modalidad.presencial");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<Programa> cargarProgramasComun(String nombre) {
        List<Programa> programasEnComun = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(RUTA_ARCHIVO_MODELO_UNIVERSIDAD_XML)) {
            // Deserializar el archivo XML
            XMLDecoder decoder = new XMLDecoder(fis);

            // Leer el objeto Universidad desde el XML
            Universidad universidad = (Universidad) decoder.readObject();
            decoder.close();

            // Recorrer los programas de la universidad y buscar el nombre
            for (Programa programa : universidad.getProgramas()) {
                if (programa.getNombre().equalsIgnoreCase(nombre)) {
                    programasEnComun.add(programa);
                }
            }

        } catch (Exception e) {
            System.err.println("Error al procesar el archivo XML: " + e.getMessage());
            e.printStackTrace();
        }

        return programasEnComun;
    }
}
