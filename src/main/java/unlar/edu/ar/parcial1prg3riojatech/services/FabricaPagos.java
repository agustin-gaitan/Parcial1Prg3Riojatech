package unlar.edu.ar.parcial1prg3riojatech.services;

import org.springframework.stereotype.Component;

@Component
public class FabricaPagos {
    
    
    public ProcesadorPago obtenerProcesador(String medioPago) { 
        if (medioPago.equalsIgnoreCase("TARJETA")) {
            return new TarjetaCreditoPago(); 
        } else if (medioPago.equalsIgnoreCase("BILLETERA")) {
            return new BilleteraVirtualPago(); 
        } else {
            throw new IllegalArgumentException("Medio de pago no válido: " + medioPago);
        }
    }
}