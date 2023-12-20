package main;
import logica.controller.Logica;
import logica.controller.LogicaImp;
import logica.dto.DTOCurso;
import logica.enumerado.Area;
import logica.manejador.ManejadorCursos;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Creamos una instancia de la implementación de Logica
        Logica logica = new LogicaImp(ManejadorCursos.obtenerInstancia());

        // Prueba de operaciones
        List<String> nombresCursos = logica.obtenerNombreCursos();
        System.out.println("Nombres de cursos: " + nombresCursos);

        int semestre = 1;
        List<String> cursosPorSemestre = logica.obtenerCursosPorSemestre(semestre);
        System.out.println("Cursos del semestre " + semestre + ": " + cursosPorSemestre);

        List<String> cursosOpcionales = logica.obtenerCursosPorSemestreOpcionales(semestre);
        System.out.println("Cursos opcionales del semestre " + semestre + ": " + cursosOpcionales);

        List<String> cursosObligatorios = logica.obtenerCursosPorSemestreObligatorios(semestre);
        System.out.println("Cursos obligatorios del semestre " + semestre + ": " + cursosObligatorios);

        String nombreCurso = "Curso 1";
        DTOCurso datosCurso = logica.obtenerDatosCurso(nombreCurso);
        System.out.println("Datos del curso " + nombreCurso + ": " + datosCurso);

        List<String> cursosAprobados = Arrays.asList("Curso 2", "Curso 3");
        String curso = "Curso 1";
        boolean cumplePrevia = logica.cumplePrevia(cursosAprobados, curso);
        System.out.println("¿El curso " + curso + " cumple las previas? " + cumplePrevia);

        // Crear un nuevo curso y probar la operación
        logica.crearCurso("Nuevo Curso", "NC001", 3, Area.I, List.of("Curso 1"));
        nombresCursos = logica.obtenerNombreCursos();
        System.out.println("Nombres de cursos después de agregar uno nuevo: " + nombresCursos);
    }
}
