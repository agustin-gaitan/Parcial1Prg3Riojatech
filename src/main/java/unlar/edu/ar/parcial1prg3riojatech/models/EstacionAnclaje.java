package unlar.edu.ar.parcial1prg3riojatech.models;
import java.util.ArrayList;
import java.util.List;

public class EstacionAnclaje { 
    private String nombre;
    private List<Vehiculo> vehiculosDisponibles;

    public EstacionAnclaje(String nombre) {
        this.nombre = nombre;
        this.vehiculosDisponibles = new ArrayList<>();
    }

    public void agregarVehiculo(Vehiculo v) {
        this.vehiculosDisponibles.add(v);
    }

    public String getNombre() { return nombre; }
    public List<Vehiculo> getVehiculosDisponibles() { return vehiculosDisponibles; }

    // Metodo para buscar dentro de la lista
    public Vehiculo buscarVehiculoPorPatente(String patente) {
        for (Vehiculo v : vehiculosDisponibles) {
            if (v.getPatente().equalsIgnoreCase(patente)) {
                return v;
            }
        }
        return null; // Si no lo encuentra en esta estación
    }
}