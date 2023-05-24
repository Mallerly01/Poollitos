package Controlador;

import Excepciones.*;
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

    public void creaCliente(Cliente nuevo) throws ClienteException {
        Cliente cli = buscaCliente(nuevo.getRut());
        if (cli==null){
            clientes.add(nuevo);
            System.out.println("Cliente creado con exito ");
        }else {
            throw new ClienteException("El cliente ya existe");
        }
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
            arrayProductos[i]=producto;
            i++;
        }
        return arrayProductos;
    }
    private Cliente buscaCliente(String rut){
        for (Cliente cliente :  clientes){
            if (rut.equals(cliente.getRut())){
                return cliente;
            }
        }
        return null;
    }
}
