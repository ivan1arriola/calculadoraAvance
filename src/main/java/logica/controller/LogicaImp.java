package logica.controller;

import logica.Curso;
import logica.enumerado.Area;
import logica.manejador.ManejadorCursos;
import logica.dto.DTOCurso;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LogicaImp implements Logica {
    private final ManejadorCursos manejadorCursos;

    public LogicaImp(ManejadorCursos manejadorCursos) {
        this.manejadorCursos = manejadorCursos;
    }

    @Override
    public List<String> obtenerNombreCursos() {
        List<String> nombresCursos = new ArrayList<>();
        for (Curso curso : manejadorCursos.getCursos()) {
            nombresCursos.add(curso.getNombre());
        }
        return nombresCursos;
    }

    @Override
    public List<String> obtenerCursosPorSemestre(int semestre) {
        List<String> cursosPorSemestre = new ArrayList<>();
        for (Curso curso : manejadorCursos.getCursos()) {
            if (curso.getSemestre() == semestre) {
                cursosPorSemestre.add(curso.getNombre());
            }
        }
        return cursosPorSemestre;
    }

    @Override
    public List<String> obtenerCursosPorSemestreOpcionales(int semestre) {
        List<String> cursosOpcionales = new ArrayList<>();
        for (Curso curso : manejadorCursos.getCursos()) {
            if (curso.getSemestre() == semestre && !curso.isObligatorio()) {
                cursosOpcionales.add(curso.getNombre());
            }
        }
        return cursosOpcionales;
    }

    @Override
    public List<String> obtenerCursosPorSemestreObligatorios(int semestre) {
        List<String> cursosObligatorios = new ArrayList<>();
        for (Curso curso : manejadorCursos.getCursos()) {
            if (curso.getSemestre() == semestre && curso.isObligatorio()) {
                cursosObligatorios.add(curso.getNombre());
            }
        }
        return cursosObligatorios;
    }

    @Override
    public DTOCurso obtenerDatosCurso(String nombreCurso) {
        Curso curso = buscarCursoPorNombre(nombreCurso);
        if (curso != null) {
            return curso.obtenerDTO();
        }
        return null;
    }

    @Override
    public boolean cumplePrevia(List<String> cursosAprobados, String nombreCurso) {
        Curso curso = buscarCursoPorNombre(nombreCurso);
        if (curso != null) {
            List<String> previas = curso.getPrevias().stream().map(Curso::getNombre).toList();
            return new HashSet<>(cursosAprobados).containsAll(previas);
        }
        return false;
    }

    @Override
    public void crearCurso(String nombre, String codigo, int creditos, Area area, List<String> previas) {
        Curso nuevoCurso = new Curso(nombre, codigo, creditos, area, convertirNombresACursos(previas));
        manejadorCursos.agregarCurso(nuevoCurso);
    }

    private List<Curso> convertirNombresACursos(List<String> nombres) {
        List<Curso> cursos = new ArrayList<>();
        for (String nombre : nombres) {
            Curso curso = buscarCursoPorNombre(nombre);
            if (curso != null) {
                cursos.add(curso);
            }
        }
        return cursos;
    }

    private Curso buscarCursoPorNombre(String nombreCurso) {
        for (Curso curso : manejadorCursos.getCursos()) {
            if (curso.getNombre().equals(nombreCurso)) {
                return curso;
            }
        }
        return null;
    }
}
