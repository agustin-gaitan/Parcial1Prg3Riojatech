package unlar.edu.ar.parcial1prg3riojatech.models;

public abstract class Usuario {
    private String idUsuario; 
    private String nombre;    
    public Usuario(String idUsuario, String nombre) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
    }

    public String getIdUsuario() { return idUsuario; } 
    public String getNombre() { return nombre; }       

    public abstract double calcularCostoFinal(double tarifaBase);
}