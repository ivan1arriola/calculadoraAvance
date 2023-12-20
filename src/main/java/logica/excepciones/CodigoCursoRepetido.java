package logica.excepciones;

public class CodigoCursoRepetido extends RuntimeException {

    public CodigoCursoRepetido(String mensaje) {
        super(mensaje);
    }

    // Puedes agregar más constructores o métodos según sea necesario
}
