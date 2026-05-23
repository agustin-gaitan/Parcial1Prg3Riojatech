package unlar.edu.ar.parcial1prg3riojatech.models;


public class BicicletaElectrica extends Vehiculo {
    private int capacidadCanastoCm3; 

    public BicicletaElectrica(String patente, int porcentajeBateria, double tarifaBase, int capacidadCanastoCm3) {
        super(patente, porcentajeBateria, tarifaBase);
        this.capacidadCanastoCm3 = capacidadCanastoCm3;
    }

    public int getCapacidadCanastoCm3() { return capacidadCanastoCm3; } 
}
