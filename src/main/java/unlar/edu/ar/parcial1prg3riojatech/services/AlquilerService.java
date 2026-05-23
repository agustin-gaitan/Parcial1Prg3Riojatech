package unlar.edu.ar.parcial1prg3riojatech.services;

import unlar.edu.ar.parcial1prg3riojatech.models.*;
import unlar.edu.ar.parcial1prg3riojatech.exceptions.*;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service 
public class AlquilerService {
// Colecciones para cumplir con la "Gestión de Datos en Memoria" pedida en la consigna
    private List<EstacionAnclaje> estaciones;
    private List<Usuario> usuariosRegistrados;
    private FabricaPagos fabricaPagos; // La dependencia de nuestra fábrica

    // El Constructor: Spring Boot nos inyecta la fábrica automáticamente
    public AlquilerService(FabricaPagos fabricaPagos) {
        this.fabricaPagos = fabricaPagos;
        this.estaciones = new ArrayList<>();
        this.usuariosRegistrados = new ArrayList<>();
        cargarDatosDePrueba(); // Llamamos a esto para tener datos en memoria
    }

    // EL MÉTODO PRINCIPAL 
    public String procesarDesbloqueo(String idUsuario, String patente, String medioPago) {
        
        // Buscamos al usuario que quiere alquilar el vehículo
        Usuario usuario = buscarUsuario(idUsuario);
        if (usuario == null) {
            throw new RuntimeException("Error: Usuario no registrado.");
        }

        // 1. Localizar el vehículo dentro de la estación a través de su patente
        Vehiculo vehiculoADesbloquear = null;
        for (EstacionAnclaje estacion : estaciones) {
            Vehiculo v = estacion.buscarVehiculoPorPatente(patente);
            if (v != null) {
                vehiculoADesbloquear = v;
                break; // Lo encontramos, cortamos el bucle
            }
        }

        // Lanzamos la Alarma 1 si no está
        if (vehiculoADesbloquear == null) {
            throw new VehiculoNoEncontradoException("Vehículo No Encontrado. Patente: " + patente);
        }

        // 2. Validar que el nivel de batería sea apto para circular 
        if (vehiculoADesbloquear.getPorcentajeBateria() < 15) {
            // Lanzamos la Alarma 2
            throw new BateriaInsuficienteException("Batería Insuficiente. Tiene solo " + vehiculoADesbloquear.getPorcentajeBateria() + "%");
        }

        // 3. Calcular importe final (aplicando descuentos si es Premium)
        double costoFinal = usuario.calcularCostoFinal(vehiculoADesbloquear.getTarifaBase());

        // 4. Obtener medio de pago adecuado a través de la fábrica
        ProcesadorPago procesador = fabricaPagos.obtenerProcesador(medioPago);

        // 5. Efectuar el cobro
        procesador.procesarCobro(costoFinal);

        // 6. Retornar mensaje de éxito
        return "Desbloqueo exitoso. Rodado: " + patente + " | Monto cobrado: $" + costoFinal;
    }

    // Método auxiliar con bucle tradicional (for) para buscar usuario por ID
    private Usuario buscarUsuario(String idUsuario) {
        for (Usuario u : usuariosRegistrados) {
            if (u.getIdUsuario().equalsIgnoreCase(idUsuario)) {
                return u;
            }
        }
        return null;
    }

    // "Gestión de Datos en Memoria"
    private void cargarDatosDePrueba() {
        // Metemos un par de usuarios
        usuariosRegistrados.add(new UsuarioRegular("U001", "Juan Perez"));
        usuariosRegistrados.add(new UsuarioPremium("U002", "Ana Gomez", 15.0)); // 15% desc

        // Metemos una estación y vehículos
        EstacionAnclaje est1 = new EstacionAnclaje("Estacion Centro");
        est1.agregarVehiculo(new Monopatin("MONO-123", 100, 500.0, true)); // Todo OK
        est1.agregarVehiculo(new Monopatin("MONO-999", 10, 500.0, false)); // Bateria baja para forzar error
        
        estaciones.add(est1);
    }
}