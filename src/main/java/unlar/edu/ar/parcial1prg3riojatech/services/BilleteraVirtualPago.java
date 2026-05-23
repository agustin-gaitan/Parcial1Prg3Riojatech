package unlar.edu.ar.parcial1prg3riojatech.services;

public class BilleteraVirtualPago implements ProcesadorPago {
    @Override
    public void procesarCobro(double monto) {
        System.out.println("Cobro exitoso de $" + monto + " realizado con Billetera Virtual");
    }
}