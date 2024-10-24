package co.edu.uniquindio.preparcil2.universidad.model;

import java.io.Serializable;

public class Programa implements Serializable {
    private static final long serialVersionUID = 1L;
    private static int contador = 0;
    private int codigo;
    private String nombre;
    private String modalidad;
    private int adscritos;
    public Programa() {
        this.codigo = ++contador;
    }

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        Programa.contador = contador;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public int getAdscritos() {
        return adscritos;
    }

    public void setAdscritos(int adscritos) {
        this.adscritos = adscritos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
