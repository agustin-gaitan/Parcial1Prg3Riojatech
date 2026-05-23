package unlar.edu.ar.parcial1prg3riojatech.models;

public class UsuarioRegular extends Usuario {

    public UsuarioRegular(String idUsuario, String nombre) {
        super(idUsuario, nombre);
    }

    @Override
    public double calcularCostoFinal(double tarifaBase) {
        return tarifaBase;
    }
}