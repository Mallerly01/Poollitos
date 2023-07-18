package Modelo;

import java.io.Serializable;

public class Cliente implements Serializable {
    private String rut;
    private String nombre;
    private String direccion;
    private String telefono;

    public Cliente(String rut, String nom, String dir, String fono){
        this.rut = rut;
        nombre = nom;
        direccion = dir;
        telefono = fono;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}
