package Controlador;

import Excepciones.ClienteException;
import Excepciones.ProductoException;
import Excepciones.VentaException;
import Modelo.*;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class ControladorFerreteria {
    private static ControladorFerreteria instance = null;
    private static ArrayList<Cliente> clientes;
    private static ArrayList<Producto> productos;
    private static ArrayList<Venta> ventas;

    private ControladorFerreteria() {
        clientes = new ArrayList<>();
        productos = new ArrayList<>();
        ventas = new ArrayList<>();
    }

    public static ControladorFerreteria getInstance() {
        if (instance == null) {
            instance = new ControladorFerreteria();
        }
        return instance;
    }

    public void creaCliente(Cliente nuevo) throws ClienteException {
        Cliente cli = buscaCliente(nuevo.getRut());
        if (cli == null) {
            clientes.add(nuevo);
            System.out.println("Cliente creado con exito ");
        } else {
            throw new ClienteException("El cliente ya existe");
        }
    }

    public void creaProducto(Producto nuevo) throws ProductoException {
        Producto p = buscaProducto(nuevo.getCodigo());
        if (p == null) {
            productos.add(nuevo);
        } else {
            throw new ProductoException("el producto ya existe");
        }
    }

    public Venta creaVenta(String rut) throws ClienteException {
        Cliente cli = buscaCliente(rut);
        if (cli != null) {
            long cod = ventas.size();
            Venta v = new Venta(cod, LocalDate.now(), cli);
            ventas.add(v);
            return v;
        } else {
            throw new ClienteException("el cliente no existe");
        }
    }

    public void agregarProductoALaVenta(long cod, Venta v, int cant) throws ProductoException {
        Producto prod = buscaProducto(cod);
        if (prod != null) {
            v.agregarDetalleVenta(prod, cant);
            System.out.println("Producto ingresado con exito");
        } else {
            throw new ProductoException("el producto ingresado no existe");
        }
    }

    public Cliente[] listaClientes() {
        Cliente[] arrayClientes = new Cliente[clientes.size()];
        int i = 0;
        for (Cliente cliente : clientes) {
            arrayClientes[i] = cliente;
            i++;
        }
        return arrayClientes;
    }

    public Producto[] listaProductos() {
        Producto[] arrayProductos = new Producto[productos.size()];
        int i = 0;
        for (Producto producto : productos) {
            arrayProductos[i] = producto;
            i++;
        }
        return arrayProductos;
    }

    public Venta[] listaVentas() {
        Venta[] arrayVentas = new Venta[ventas.size()];
        int i = 0;
        for (Venta venta : ventas) {
            arrayVentas[i] = venta;
            i++;
        }
        return arrayVentas;
    }

    private static Cliente buscaCliente(String rut) {
        for (Cliente cliente : clientes) {
            if (rut.equals(cliente.getRut())) {
                return cliente;
            }
        }
        return null;
    }

    private Producto buscaProducto(long codigo) {
        for (Producto producto : productos) {
            if (codigo == producto.getCodigo()) {
                return producto;
            }
        }
        return null;
    }

    private Venta buscaVenta(long codigo) {
        for (Venta venta : ventas) {
            if (codigo == venta.getCodigoVenta()) {
                return venta;
            }
        }
        return null;
    }

    public Venta[] listarVentas() {
        Venta[] arrayVentas = new Venta[ventas.size()];
        int i = 0;
        for (Venta venta : ventas) {
            arrayVentas[i] = venta;
            i++;
        }
        return arrayVentas;
    }

    public DetalleVenta[] listarDetalleVenta(long codigoVenta) throws VentaException {
        Venta v = buscaVenta(codigoVenta);
        if (v != null) {
            DetalleVenta[] detallesVenta = v.getDetallestoString();
            return detallesVenta;
        }
        throw new VentaException("La venta ingresada no existe");

    }

    public void escribirArchivo(){
     PrintWriter pwClientes;
     PrintWriter pwProductos;
     PrintWriter pwVentas;
     PrintWriter pwDetallesVentas;
        try {
            pwClientes = new PrintWriter(new FileOutputStream(new File("Clientes.txt"),false));
            pwProductos = new PrintWriter(new FileOutputStream(new File("Productos.txt"),false));
            pwVentas = new PrintWriter(new FileOutputStream(new File("Ventas.txt"),false));
            pwDetallesVentas= new PrintWriter(new FileOutputStream(new File("DetallesVentas.txt"),false));
            //se coloca false si quieres que borre el archivo existente i vuelva a escribirlo y
            // true si se continua escribiendo el que ya existe
        }catch (IOException e){
            System.out.println("ha ocurrido un error al escribir el archivo");
            return;
        }
    for (Cliente c : clientes){
        pwClientes.println(c.getRut()+";"+c.getNombre()+";"+c.getDireccion()+";"+c.getTelefono());
    }
    pwClientes.flush();
    pwClientes.close();
    for (Producto p : productos){
        pwProductos.println(p.getCodigo()+";"+p.getMarca()+";"+p.getDescripcion()+";"+p.getPrecio());
    }
    pwProductos.flush();
    pwProductos.close();
    for (Venta v : ventas){
        pwVentas.println(v.getCodigoVenta()+";"+v.getFecha()+";"+v.getElCliente() .getRut());
        DetalleVenta[] detallesVenta = v.getDetallestoString();
        for (DetalleVenta d :  detallesVenta){
            pwDetallesVentas.println(d.getVenta() .getCodigoVenta()+";"+d.getCantidad()+";"+d.getProducto().getCodigo());
        }
    }
    pwDetallesVentas.flush();
    pwDetallesVentas.close();
    pwVentas.flush();
    pwVentas.close();



}
    public void leerArchivo() {
        Scanner fClientes;
        Scanner fProductos;
        Scanner fVentas;
        Scanner fDetallesVentas;
        try {
            fClientes = new Scanner(new File("Clientes.txt"));
            fProductos = new Scanner(new File("Productos.txt"));
            fVentas = new Scanner(new File("Ventas.txt"));
            fDetallesVentas = new Scanner(new File("DetallesVentas.txt"));
        } catch (FileNotFoundException e) {
            System.out.println(" error al abrir el archivo");
            return;
        }
        fClientes.useDelimiter("\r\n|;");
        fProductos.useDelimiter("\r\n|;");
        fVentas.useDelimiter("\r\n|;");
        fDetallesVentas.useDelimiter("\r\n|;");
        String rut, nombre, telefono, direccion;
        while (fClientes.hasNext()) {
            rut = fClientes.next();
            nombre = fClientes.next();
            direccion = fClientes.next();
            telefono = fClientes.next();
            clientes.add(new Cliente(rut, nombre, direccion, telefono));

        }
        fClientes.close();
        long codProd;
        String marca, descripcion;
        int precio;
        while (fProductos.hasNext()) {
            codProd = fProductos.nextLong();
            marca = fProductos.next();
            descripcion = fProductos.next();
            precio = fProductos.nextInt();
            productos.add(new Producto(codProd, marca, descripcion, precio));
        }
        fProductos.close();
        long codVenta;
        LocalDate fecha;
        String rutCliente;
        while (fVentas.hasNext()) {
            codVenta = fVentas.nextLong();
            fecha = LocalDate.parse(fVentas.next());
            rutCliente = fVentas.next();
            Cliente miCliente = buscaCliente(rutCliente);
            ventas.add(new Venta(codVenta, fecha, miCliente));
        }
        fVentas.close();
        int cantidad;
        while (fDetallesVentas.hasNext()) {
            codVenta = fDetallesVentas.nextLong();
            cantidad = fDetallesVentas.nextInt();
            codProd = fDetallesVentas.nextLong();
            Venta v = buscaVenta(codVenta);
            v.agregarDetalleVenta(buscaProducto(codProd), cantidad);
        }
        fDetallesVentas.close();

    }
}