package unlar.edu.ar.parcial1prg3riojatech.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unlar.edu.ar.parcial1prg3riojatech.services.AlquilerService;
import unlar.edu.ar.parcial1prg3riojatech.exceptions.*;

@RestController // Esto le dice a Spring que esta clase va a manejar solicitudes HTTP y devolver respuestas HTTP
@RequestMapping("/api/alquileres") // La primera parte de la URL
public class AlquilerController {

    private AlquilerService alquilerService;

    
    public AlquilerController(AlquilerService alquilerService) {
        this.alquilerService = alquilerService;
    }

   
    @GetMapping("/desbloquear")
    public ResponseEntity<String> desbloquearVehiculo(@RequestBody DesbloqueoRequest request) {
        try {
            
            String mensajeExito = alquilerService.procesarDesbloqueo(
                request.getIdUsuario(),
                request.getPatente(),
                request.getMetodoPago()
            );
            return ResponseEntity.ok(mensajeExito);
            
        } catch (VehiculoNoEncontradoException | BateriaInsuficienteException e) {
            // Si salta una alarma atrapamos la excepción y devolvemos un error.
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
            
        } catch (Exception e) {
            // Si pasa cualquier otro error raro (ej: usuario no existe)
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}