package logica.dto;

import logica.enumerado.Area;

import java.util.List;

public class DTOCurso {
    private String nombre;
    private String codigo;
    private int creditos;
    private boolean obligatorio;
    private int semestre;
    private Area area;
    private List<String> previas; // Lista de nombres de cursos previos

    public DTOCurso(String nombre, String codigo, int creditos, boolean obligatorio, int semestre, Area area, List<String> previas) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.creditos = creditos;
        this.obligatorio = obligatorio;
        this.semestre = semestre;
        this.area = area;
        this.previas = previas;
    }

    public DTOCurso(){}



    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getCreditos() {
        return creditos;
    }

    public boolean isObligatorio() {
        return obligatorio;
    }

    public int getSemestre() {
        return semestre;
    }

    public Area getArea() {
        return area;
    }

    public List<String> getPrevias() {
        return previas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public void setObligatorio(boolean obligatorio) {
        this.obligatorio = obligatorio;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public void setPrevias(List<String> previas) {
        this.previas = previas;
    }

    @Override
    public String toString() {
        return "DTOCurso{" +
                "nombre='" + nombre + '\'' +
                ", codigo='" + codigo + '\'' +
                ", creditos=" + creditos +
                ", obligatorio=" + obligatorio +
                ", semestre=" + semestre +
                ", area=" + area +
                ", previas=" + previas +
                '}';
    }
}
