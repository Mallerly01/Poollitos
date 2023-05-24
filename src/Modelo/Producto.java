package Modelo;

public class Producto {

    private long codigo;
    private String marca;
    private String descripcion;
    private int precio;
    private int cantidad;

    public Producto(long code, String marc, String desc, int precio, int cantidad){
        codigo = code;
        marca = marc;
        descripcion = desc;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }


    public int getCantidad() {
        return cantidad;
    }


    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
