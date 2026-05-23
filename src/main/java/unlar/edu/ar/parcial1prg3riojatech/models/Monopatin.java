package unlar.edu.ar.parcial1prg3riojatech.models;

public class Monopatin extends Vehiculo {
    private boolean amortiguacionReforzada;

    public Monopatin(String patente, int porcentajeBateria, double tarifaBase, boolean amortiguacionReforzada) {
        super(patente, porcentajeBateria, tarifaBase);
        this.amortiguacionReforzada = amortiguacionReforzada;
    }

    public boolean tieneAmortiguacionReforzada() { return amortiguacionReforzada; } 
}