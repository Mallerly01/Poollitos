package Vista;
import Controlador.ControladorFerreteria;
import Excepciones.ClienteException;
import Excepciones.ProductoException;
import Modelo.Cliente;
import Modelo.Producto;
import Modelo.Venta;

import java.util.Scanner;

public class UIFerreteria {
    private static UIFerreteria instance = null;

    private UIFerreteria() {
    }

    public static UIFerreteria getInstance() {
        if (instance == null) {
            instance = new UIFerreteria();
        }
        return instance;
    }

    Scanner sc = new Scanner(System.in);

    public void menu() {
        int opcion = 0;
        do {
            System.out.println("** MENU DE OPCIONES **");
            System.out.println("1. Crear cliente");
            System.out.println("2. Crear producto");
            System.out.println("3. Agregar una venta");
            System.out.println("4. Listar a todos los clientes");
            System.out.println("5. Listar todos los productos");
            System.out.println("6. Listar ventas");
            System.out.println("7. Guardar datos");
            System.out.println("8. Leer datos");
            System.out.println("9. Salir");
            System.out.print("Elija una opción: ");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1 -> creaCliente();
                case 2 -> creaProducto();
                case 3 -> crearVenta();
                case 4 -> listaCliente();
                case 5 -> listaProductos();
                case 5 -> listarVentas();
                case 7 -> guardarDatos();
                case 8 -> leerDatos();
                case 9 -> System.out.println("Saliendo del menú...");
                default -> System.out.println("Opción inválida, por favor ingrese una opción válida");
            }
        } while (opcion != 5);
    }

    public void creaVenta() {
        try {
            System.out.println("---------Creando una Venta----------");
            System.out.print("Rut del Cliente: ");
            String rut = sc.next();
            Venta v = ControladorFerreteria.getInstance().creaVenta(rut);
            System.out.println("nombre del cliente: " + v.getElCliente().getNombre());
            System.out.println("Ingresando productos a la venta");
            System.out.println("codigo: ");
            long codProd;
            do {
                codProd = sc.nextLong();
                if (codProd != -1) {
                    System.out.println("ingrese ls cantidad del producto: ");
                    int cant = sc.nextInt();
                    ControladorFerreteria.getInstance().agregarProductoALaVenta(codProd, v, cant);
                    System.out.println("Ingrese -1 para finalizar");
                    System.out.println("codigo: ");
                }
            } while (codProd != -1);
        } catch (ClienteException | ProductoException e) {
            System.out.println(e.getMessage());
        }
    }
    public void creaCliente() {
        try {
            System.out.println("--------Ingresar cliente-------");
            System.out.print("Rut: ");
            sc.nextLine();
            String rut = sc.nextLine();
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Domicilio: ");
            String direccion = sc.nextLine();
            System.out.print("Teléfono: ");
            String telefono = sc.next();
            Cliente nuevoCliente = new Cliente(rut, nombre, direccion, telefono);
            ControladorFerreteria.getInstance().creaCliente(nuevoCliente);
        }catch (ClienteException e){
            System.out.println(e.getMessage());
        }
    }

    public void creaProducto() {
        try {
            System.out.println("---------Crear un producto--------");
            System.out.print("Codigo: ");
            long codigo = sc.nextLong();
            System.out.print("Marca: ");
            sc.nextLine();
            String marca = sc.nextLine();
            System.out.print("Descripcion: ");
            String descripcion = sc.nextLine();
            System.out.print("Precio: ");
            int precioProducto = sc.nextInt();
            Producto nuevoProducto = new Producto(codigo, marca, descripcion, precioProducto);
            ControladorFerreteria.getInstance().creaProducto(nuevoProducto);
        } catch (ProductoException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Producto creado con éxito");
    }

    public void listaProductos() {
        Producto[] prod = ControladorFerreteria.getInstance().listaProductos();
        System.out.println("Lista de productos: ");
        System.out.printf("%-15s %-15s %-20s %-15s %n", "Codigo", "Marca", "Descripcion", "Precio");
        for (Producto p : prod) {
            System.out.printf("%-15s %-15s %-20s %-15s %n", p.getCodigo(), p.getMarca(), p.getDescripcion(), p.getPrecio());
        }
    }

    public void listaCliente() {
        Cliente[] clientes = ControladorFerreteria.getInstance().listaClientes();
        System.out.println("Lista de clientes: ");
        System.out.printf("%-12s %-25s %-30s %-12s %n", "Rut", "Nombre", "Domicilio", "Telefono");
        for (Cliente c : clientes) {
            System.out.printf("%-12s %-25s %-30s %-12s %n", c.getRut(), c.getNombre(), c.getDireccion(), c.getTelefono());
        }

    }

    public void listaVentas(){

    }
}
