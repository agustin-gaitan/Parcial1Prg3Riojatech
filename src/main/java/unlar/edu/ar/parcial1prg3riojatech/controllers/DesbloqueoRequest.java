package unlar.edu.ar.parcial1prg3riojatech.controllers;

public class DesbloqueoRequest {
    private String idUsuario;
    private String patente;
    private String metodoPago;

    // Getters
    public String getIdUsuario() { return idUsuario; }
    public String getPatente() { return patente; }
    public String getMetodoPago() { return metodoPago; }

    // Setters 
    public void setIdUsuario(String idUsuario) { this.idUsuario = idUsuario; }
    public void setPatente(String patente) { this.patente = patente; }
    public void setMetodoPago(String metodoPago) { this.metodoPago = metodoPago; }
}