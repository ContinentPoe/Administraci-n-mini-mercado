public class Compra{
    private double costo;
    private int cantidad;

    public Compra(double costo,int cantidad){
        this.costo=costo;
        this.cantidad=cantidad;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void ejecutarCompra(Producto producto){
        producto.setDisponibilidad(true);
        System.out.println("Compra realizada:");
        System.out.println("Producto: "+producto.getName());
        System.out.println("Cantidad ingresada: "+cantidad);
        System.out.println("Costo total: "+costo);
    }
}