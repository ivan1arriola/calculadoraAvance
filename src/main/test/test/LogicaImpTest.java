package test;

import logica.Curso;
import logica.controller.Logica;
import logica.controller.LogicaImp;
import logica.dto.DTOCurso;
import logica.enumerado.Area;
import logica.manejador.ManejadorCursos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class LogicaImpTest {
    private Logica logica;

    @BeforeEach
    public void setUp() {
        // Inicializar con datos de prueba en el manejador de cursos
        ManejadorCursos manejadorCursos = ManejadorCursos.obtenerInstancia();
        manejadorCursos.agregarCurso(new Curso("Curso1", "C001", 3, Area.AI, null));
        manejadorCursos.agregarCurso(new Curso("Curso2", "C002", 4, Area.IE, null));

        // Inicializar la lógica con el manejador de cursos
        logica = new LogicaImp(manejadorCursos);
    }

    @Test
    public void testObtenerNombreCursos() {
        List<String> nombresCursos = logica.obtenerNombreCursos();
        assertEquals(Arrays.asList("Curso1", "Curso2"), nombresCursos);
    }

    @Test
    public void testObtenerCursosPorSemestre() {
        List<String> cursosPorSemestre = logica.obtenerCursosPorSemestre(3);
        assertEquals(Arrays.asList("Curso1"), cursosPorSemestre);
    }

    @Test
    public void testObtenerCursosPorSemestreOpcionales() {
        List<String> cursosOpcionales = logica.obtenerCursosPorSemestreOpcionales(3);
        assertEquals(Arrays.asList("Curso1"), cursosOpcionales);
    }

    @Test
    public void testObtenerCursosPorSemestreObligatorios() {
        List<String> cursosObligatorios = logica.obtenerCursosPorSemestreObligatorios(4);
        assertEquals(Arrays.asList("Curso2"), cursosObligatorios);
    }

    @Test
    public void testObtenerDatosCurso() {
        DTOCurso dtoCurso = logica.obtenerDatosCurso("Curso1");
        assertNotNull(dtoCurso);
        assertEquals("C001", dtoCurso.getCodigo());
    }

    @Test
    public void testCumplePrevia() {
        assertTrue(logica.cumplePrevia(Arrays.asList("Curso1"), "Curso1"));
        assertFalse(logica.cumplePrevia(Arrays.asList("Curso2"), "Curso1"));
    }

    @Test
    public void testCrearCurso() {
        logica.crearCurso("NuevoCurso", "NC001", 5, Area.IE, Arrays.asList("Curso1"));
        List<String> nombresCursos = logica.obtenerNombreCursos();
        assertTrue(nombresCursos.contains("NuevoCurso"));
    }

}
