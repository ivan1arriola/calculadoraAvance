package logica.controller;

import logica.dto.DTOCurso;
import logica.enumerado.Area;

import java.util.List;

public interface Logica {

    List<String> obtenerNombreCursos();

    List<String> obtenerCursosPorSemestre(int semestre);

    List<String> obtenerCursosPorSemestreOpcionales(int semestre);

    List<String> obtenerCursosPorSemestreObligatorios(int semestre);

    DTOCurso obtenerDatosCurso(String nombreCurso);

    boolean cumplePrevia(List<String> cursosAprobados, String curso);

    void crearCurso(String nombre, String codigo, int creditos, Area area, List<String> previas);
}
