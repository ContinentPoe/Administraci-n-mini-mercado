public class Venta{

    private double precioVenta;
    private int cantidad;

    public Venta(double precioVenta,int cantidad){
        this.precioVenta=precioVenta;
        this.cantidad=cantidad;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void ejecutarVenta(Producto producto){
        if (!producto.isDisponibilidad()){
            System.out.println("El producto no está disponible.");
            return;
        }

        System.out.println("Venta realizada:");
        System.out.println("Producto: "+producto.getName());
        System.out.println("Cantidad vendida: "+cantidad);
        System.out.println("Total a pagar: "+(precioVenta*cantidad));
    }
}