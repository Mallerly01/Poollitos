package Controlador;

import Excepciones.ClienteException;
import Excepciones.ProductoException;
import Excepciones.VentaException;
import Modelo.*;

import java.time.LocalDate;
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
    public void creaProducto(Producto nuevo) throws ProductoException {
        Producto p= buscaProducto(nuevo.getCodigo());
        if (p==null){
            productos.add(nuevo);
        }else {
            throw new ProductoException("el producto ya existe");
        }
    }
    public Venta creaVenta(String rut) throws ClienteException{
        Cliente cli = buscaCliente(rut);
        if (cli!=null){
            long cod=ventas.size();
            Venta v=new Venta(cod, LocalDate.now(), cli);
            ventas.add(v);
            return v;
        }else {
            throw new ClienteException("el cliente no existe");
        }
    }

    public void agregarProductoALaVenta(long cod, Venta v, int cant)throws ProductoException{
        Producto prod = buscaProducto(cod);
        if (prod!=null){
            v.agregarDetalleVenta(prod,cant);
            System.out.println("Producto ingresado con exito");
        }else {
            throw new ProductoException("el producto ingresado no existe");
        }
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

    private Cliente buscaCliente(String rut){
        for (Cliente cliente :  clientes){
            if (rut.equals(cliente.getRut())){
                return cliente;
            }
        }
        return null;
    }

    private Producto buscaProducto(long codigo){
        for (Producto producto : productos){
            if (codigo==producto.getCodigo()){
                return producto;
            }
        }
        return null;
    }

    private Venta buscaVenta(long codigo){
        for (Venta venta : ventas){
            if (codigo==venta.getCodigoVenta()){
                return venta;
            }
        }
        return null;
    }

    public Venta[] listarVentas(){
        Venta[] arrayVentas = new Venta[ventas.size()];
        int i=0;
        for (Venta venta : ventas){
            arrayVentas[i]=venta;
            i++;
        }
        return arrayVentas;
    }

    public DetalleVenta[] listarDetalleVenta(long codigoVenta) throws VentaException {
        Venta v = buscaVenta(codigoVenta);
        if (v!=null){
            DetalleVenta[] detallesVenta =v.getDetallestoString();
            return detallesVenta;
        }
        throw new VentaException("La venta ingresada no existe");

    }




}
