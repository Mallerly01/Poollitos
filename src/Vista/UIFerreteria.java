package Vista;
import Controlador.ControladorFerreteria;
import Modelo.Cliente;
import Modelo.Producto;

import java.util.Scanner;

public class UIFerreteria {
    private static UIFerreteria instance = null;
    private UIFerreteria(){

    }
    public static UIFerreteria getInstance(){
        if (instance==null){
            instance=new UIFerreteria();
        }
        return instance;
    }
    Scanner sc = new Scanner(System.in);

     public void menu(){
        int opcion = 0;
        do{
            System.out.println("** MENU DE OPCIONES **");
            System.out.println("1. Crear cliente");
            System.out.println("2. Crear producto");
            System.out.println("3. Listar a todos los clientes");
            System.out.println("4. Listar todos los productos");
            System.out.println("5. Salir");
            System.out.print("Elija una opción: ");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1 -> creaCliente();
                case 2 -> creaProducto();
                case 3 -> listaCliente();
                case 4 -> listaProductos();
                case 5 ->System.out.println("Saliendo del menú...");
                default -> System.out.println("Opción inválida, por favor ingrese una opción válida");
            }
        }while(opcion != 5);
    }
    public void creaCliente(){
        System.out.println("--------Ingresar cliente-------");
        System.out.print("Rut: ");
        String rut = sc.next();
        System.out.print("Nombre: ");
        String nombre = sc.next();
        System.out.print("Domicilio: ");
        String direccion = sc.next();
        System.out.print("Teléfono: ");
        String telefono = sc.next();
        Cliente nuevoCliente = new Cliente(rut, nombre, direccion, telefono);
        ControladorFerreteria.getInstance().creaCliente(nuevoCliente);
        System.out.println("Cliente creado con éxito");
    }
    public void creaProducto() {
        System.out.println("---------Crear un producto--------");
        System.out.print("Codigo: ");
        long nombreProducto = sc.nextLong();
        System.out.print("Marca: ");
        String marca = sc.next();
        System.out.print("Descripcion: ");
        String descripcion = sc.next();
        System.out.print("Precio: ");
        int precioProducto = sc.nextInt();
        Producto nuevoProducto = new Producto(nombreProducto, marca, descripcion, precioProducto);
        ControladorFerreteria.getInstance().creaProducto(nuevoProducto);
        System.out.println("Producto creado con éxito");
    }
    public void listaProductos(){
         Producto[] prod = ControladorFerreteria.getInstance().listaProductos();
         System.out.println("Lista de productos: ");
         System.out.printf("%-15s %-15s %-20s %-15s %n","Codigo","Marca","Descripcion","Precio");
         for (Producto p : prod){
             System.out.printf("%-15s %-15s %-20s %-15s %n",p.getCodigo(), p.getMarca(),p.getDescripcion(),p.getPrecio());
         }
    }
    public void listaCliente(){
        Cliente[] clientes = ControladorFerreteria.getInstance().listaClientes();
        System.out.println("Lista de clientes: ");
        System.out.printf("%-12s %-25s %-30s %-12s %n","Rut","Nombre","Domicilio","Telefono");
        for (Cliente c : clientes){
            System.out.printf("%-12s %-25s %-30s %-12s %n",c.getRut(),c.getNombre(),c.getDireccion(),c.getTelefono());
        }

    }//llave final






}