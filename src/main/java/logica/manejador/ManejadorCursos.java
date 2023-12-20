package logica.manejador;

import java.util.ArrayList;
import java.util.List;
import logica.Curso;
import logica.excepciones.CodigoCursoRepetido;

public class ManejadorCursos {
    private static ManejadorCursos instancia = null;
    private List<Curso> cursos;

    private ManejadorCursos() {
        // Inicializa la colección de cursos
        this.cursos = new ArrayList<>();
    }

    public static ManejadorCursos obtenerInstancia() {
        if (instancia == null) {
            instancia = new ManejadorCursos();
        }
        return instancia;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void agregarCurso(Curso curso) throws CodigoCursoRepetido {
        if (!existeCursoConCodigo(curso.getCodigo())) {
            cursos.add(curso);
        } else {
            throw new CodigoCursoRepetido("El código del curso ya existe: " + curso.getCodigo());
        }
    }

    private boolean existeCursoConCodigo(String codigo) {
        for (Curso curso : cursos) {
            if (curso.getCodigo().equals(codigo)) {
                return true;
            }
        }
        return false;
    }



    public Curso buscarCursoPorCodigo(String codigo) {
        // Implementa la lógica para buscar un curso por su código
        for (Curso curso : cursos) {
            if (curso.getCodigo().equals(codigo)) {
                return curso;
            }
        }
        return null; // Retorna null si no se encuentra el curso
    }

}
