package Modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
//guardar archivos y recuperar archivos
public class Venta implements Serializable {
    private long codigoVenta;
    private LocalDate fecha;
    private ArrayList<DetalleVenta> misDetalles;
    private Cliente elCliente;

    public Venta(long codigoVenta, LocalDate fecha, Cliente elCliente){
        this.codigoVenta = codigoVenta;
        this.fecha = fecha;
        this.misDetalles = new ArrayList<>();
        this.elCliente = elCliente;
    }

    public long getCodigoVenta() {
        return codigoVenta;
    }

    public void setCodigoVenta(int codigoVenta) {
        this.codigoVenta = codigoVenta;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Cliente getElCliente() {
        return elCliente;
    }

    public void setElCliente(Cliente elCliente) {
        this.elCliente = elCliente;
    }

    public DetalleVenta[] getDetallestoString(){
        DetalleVenta[] arrayDetalles = new DetalleVenta[misDetalles.size()];
        int i = 0;
        for (DetalleVenta detalle : misDetalles) {
            arrayDetalles[i] = detalle;
            i++;
        }
        return arrayDetalles;
    }
    public void agregarDetalleVenta(Producto p, int cant){
        misDetalles.add(new DetalleVenta(cant,p,this));
    }
}
