package Modelo;

import java.util.ArrayList;
//guardar archivos y recuperar archivos
public class Venta {
    private long codigoVenta;
    private String fecha;
    private ArrayList<Producto> misProductos;
    private Cliente elCliente;

    public Venta(long codigoVenta,String fecha, ArrayList<Producto> misProductos, Cliente elCliente){
        this.codigoVenta = codigoVenta;
        this.fecha = fecha;
        this.misProductos = new ArrayList<>();
        this.elCliente = elCliente;
    }

    public long getCodigoVenta() {
        return codigoVenta;
    }

    public void setCodigoVenta(int codigoVenta) {
        this.codigoVenta = codigoVenta;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public ArrayList<Producto> getMisProductos() {
        return misProductos;
    }

    public void setMisProductos(ArrayList<Producto> misProductos) {
        this.misProductos = misProductos;
    }

    public Cliente getElCliente() {
        return elCliente;
    }

    public void setElCliente(Cliente elCliente) {
        this.elCliente = elCliente;
    }
}
