package Modelo;

import java.io.Serializable;

public class DetalleVenta implements Serializable {

    private int cantidad;
    private Producto producto;
    private Venta venta;

    public DetalleVenta(int cantidad, Producto producto, Venta venta) {
        this.cantidad = cantidad;
        this.producto = producto;
        this.venta = venta;
    }

    public int getCantidad() {
        return cantidad;
    }


    public Producto getProducto() {
        return producto;
    }


    public Venta getVenta() {
        return venta;
    }

}
