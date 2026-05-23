package unlar.edu.ar.parcial1prg3riojatech.exceptions;

public class BateriaInsuficienteException extends RuntimeException {
    
    public BateriaInsuficienteException(String mensaje) {
        super(mensaje);
    }
}