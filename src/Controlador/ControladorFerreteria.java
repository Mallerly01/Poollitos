package Controlador;

import Modelo.*;

public class ControladorFerreteria {
    private static ControladorFerreteria instance= null;
    private static Cliente[] arrayClientes;
    private int contClientes=0;
    private static Producto[] arrayProductos;
    private int contProductos=0;
    private ControladorFerreteria(){
        arrayClientes = new Cliente[100];
        arrayProductos =  new Producto[100];
    }
    public static ControladorFerreteria getInstance() {
        if (instance==null){
            instance= new ControladorFerreteria();
        }
        return instance;
    }

    public void creaCliente(Cliente nuevo){
        arrayClientes[contClientes]=nuevo;
        contClientes++;
    }
    public void creaProducto(Producto nuevo){
        arrayProductos[contProductos]=nuevo;
        contProductos++;
    }
    public Cliente[] listaClientes(){
        Cliente[] clientes = new Cliente[contClientes];
        for (int i =0 ; i<contClientes;i++){
            clientes[i]=arrayClientes[i];
        }
        return clientes;
    }
    public Producto[] listaProductos(){
        Producto[] productos = new Producto[contProductos];
        for (int i=0; i<contProductos;i++){
            productos[i]=arrayProductos[i];
        }
        return productos;
    }
}
