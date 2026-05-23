package unlar.edu.ar.parcial1prg3riojatech.exceptions;

public class VehiculoNoEncontradoException extends RuntimeException {
    
    public VehiculoNoEncontradoException(String mensaje) {
        
        super(mensaje); 
    }
}