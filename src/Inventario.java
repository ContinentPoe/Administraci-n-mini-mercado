import java.util.ArrayList;

public class Inventario {

    private ArrayList<Producto> productos;

    public Inventario() {
        productos = new ArrayList<>();
    }

    // Agregar producto al inventario
    public void agregarProducto(Producto p) {
        productos.add(p);
        System.out.println("Producto agregado: " + p.getName());
    }

    // Mostrar todos los productos
    public void mostrarProductos() {
        if (productos.isEmpty()) {
            System.out.println("El inventario está vacío.");
            return;
        }

        for (Producto p : productos) {
            System.out.println("----------------------------");
            System.out.println("ID: " +p.getIdef());
            System.out.println("Nombre: " +p.getName());
            System.out.println("Precio: " +p.getPrice());
            System.out.println("Disponible: " +(p.isDisponibilidad() ? "Sí" : "No"));
            System.out.println("----------------------------");
        }
    }

    // Buscar un producto por id
    public Producto buscarPorID(String id) {
        for (Producto p : productos) {
            if (p.getIdef().equals(id)) {
                return p;
            }
        }
        return null;
    }

    //Eliminar un producto por id
    public boolean eliminarProducto(String id) {
        Producto p = buscarPorID(id);
        if (p != null) {
            productos.remove(p);
            return true;
        }
        return false;
    }
}
