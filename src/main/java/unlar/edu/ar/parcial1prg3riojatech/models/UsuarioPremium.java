package unlar.edu.ar.parcial1prg3riojatech.models;


public class UsuarioPremium extends Usuario {
    private double descuentoPorcentaje; 

    public UsuarioPremium(String idUsuario, String nombre, double descuentoPorcentaje) {
        super(idUsuario, nombre);
        this.descuentoPorcentaje = descuentoPorcentaje;
    }

    @Override
    public double calcularCostoFinal(double tarifaBase) {
        return tarifaBase - (tarifaBase * (this.descuentoPorcentaje / 100));
    }
}