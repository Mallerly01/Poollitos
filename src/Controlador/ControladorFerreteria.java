package Controlador;

import Modelo.*;

import java.util.ArrayList;

public class ControladorFerreteria {
    private static ControladorFerreteria instance= null;
    private static ArrayList<Cliente> clientes;
    private static ArrayList<Producto> productos;
    private static ArrayList<Venta> ventas;

    private ControladorFerreteria(){
        clientes = new ArrayList<>();
        productos = new ArrayList<>();
        ventas = new ArrayList<>();
    }
    public static ControladorFerreteria getInstance() {
        if (instance==null){
            instance= new ControladorFerreteria();
        }
        return instance;
    }

    public void creaCliente(Cliente nuevo){
        clientes.add(nuevo);
    }
    public void creaProducto(Producto nuevo){
        productos.add(nuevo);
    }
    public Cliente[] listaClientes(){
        Cliente[] arrayClientes = new Cliente[clientes.size()];
        int i=0;
        for (Cliente cliente : clientes){
            arrayClientes[i]=cliente;
            i++;
        }
        return arrayClientes;
    }
    public Producto[] listaProductos(){
        Producto[] arrayProductos = new Producto[productos.size()];
        int i=0;
        for (Producto producto : productos){
            arrayProductos[i] = producto;
            i++;
        }
        return arrayProductos;
    }

    public Venta[] listaVentas(){
        Venta[] arrayVentas = new Venta[ventas.size()];
        int i=0;
        for (Venta venta : ventas){
            arrayVentas[i] = venta;
            i++;
        }
        return arrayVentas;
    }
}
