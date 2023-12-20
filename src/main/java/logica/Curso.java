package logica;

import logica.dto.DTOCurso;
import logica.enumerado.Area;

import java.util.List;

public class Curso {
    private String nombre;
    private String codigo;
    private int creditos;

    private boolean obligatorio;
    private int semestre;

    private Area area;

    private List<Curso> previas; // Lista de cursos previos


    public Curso(String nombre, String codigo, int creditos, Area area, List<Curso> previas) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.creditos = creditos;
        this.area = area;
        this.previas = previas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public List<Curso> getPrevias() {
        return previas;
    }

    public void setPrevias(List<Curso> previas) {
        this.previas = previas;
    }

    public boolean isObligatorio() {
        return obligatorio;
    }

    public void setObligatorio(boolean obligatorio) {
        this.obligatorio = obligatorio;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "nombre='" + nombre + '\'' +
                ", codigo='" + codigo + '\'' +
                ", creditos=" + creditos +
                ", area=" + area +
                ", previas=" + previas +
                '}';
    }

    public DTOCurso obtenerDTO() {
        DTOCurso dtoCurso = new DTOCurso();
        dtoCurso.setNombre(this.nombre);
        dtoCurso.setCodigo(this.codigo);
        dtoCurso.setCreditos(this.creditos);
        dtoCurso.setObligatorio(this.obligatorio);
        dtoCurso.setSemestre(this.semestre);
        dtoCurso.setArea(this.area);

        // Convertir la lista de objetos Curso a una lista de nombres
        if (this.previas != null) {
            List<String> nombresPrevias = previas.stream().map(Curso::getNombre).toList();
            dtoCurso.setPrevias(nombresPrevias);
        }

        return dtoCurso;
    }
}
