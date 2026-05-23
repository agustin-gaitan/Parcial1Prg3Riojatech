package unlar.edu.ar.parcial1prg3riojatech.services;

public class TarjetaCreditoPago implements ProcesadorPago {
    @Override
    public void procesarCobro(double monto) {
        System.out.println("Cobro exitoso de $" + monto + " realizado con Tarjeta de Crédito");
    }
}