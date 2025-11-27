import javax.swing.*;
import java.util.ArrayList;

public class principal {

    public static void main(String args[]) {

        ArrayList<Administrador> administradores = new ArrayList<>();
        ArrayList<cliente> clientes = new ArrayList<>();
        ArrayList<Producto> productos = new ArrayList<>();
        ArrayList<Trabajador> trabajadores = new ArrayList<>();

        Inventario inventario = new Inventario(productos);

        // Admin inicial
        administradores.add(new Administrador(
                1,
                "admin",
                "0001",
                "1234"
        ));

        while (true) {

            inventario.alertarBajos();

            String opc = JOptionPane.showInputDialog(
                    "===== SISTEMA DE TIENDA =====\n" +
                    "1. Administrador\n" +
                    "2. Trabajador\n" +
                    "3. Salir\n" +
                    "Seleccione opción:"
            );

            if (opc == null) continue;

            switch (opc) {
                case "1":
                    loginAdmin(administradores, clientes, inventario, trabajadores);
                    break;

                case "2":
                    menuTrabajador(clientes, inventario);
                    break;

                case "3":
                    System.exit(0);
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida");
            }
        }
    }

    // LOGIN ADMINISTRADOR
    public static void loginAdmin(ArrayList<Administrador> admins, ArrayList<cliente> clientes,
                                  Inventario inventario, ArrayList<Trabajador> trabajadores) {

        String id = JOptionPane.showInputDialog("Digite ID de administrador:");
        if (id == null) return;

        String pass = JOptionPane.showInputDialog("Digite contraseña:");
        if (pass == null) return;

        for (Administrador a : admins) {
            if (a.getIdPersona().equals(id) && a.getContraseña().equals(pass)) {
                menuAdmin(admins, clientes, inventario, trabajadores);
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "Datos incorrectos");
    }

    // MENÚ ADMINISTRADOR
    public static void menuAdmin(ArrayList<Administrador> admins, ArrayList<cliente> clientes,
                                 Inventario inventario, ArrayList<Trabajador> trabajadores) {

        while (true) {

            inventario.alertarBajos();

            String op = JOptionPane.showInputDialog(
                    "===== ADMINISTRADOR =====\n" +
                    "1. Registrar Trabajador\n" +
                    "2. Registrar Producto\n" +
                    "3. Registrar Administrador\n" +
                    "4. Mostrar Productos\n" +
                    "5. Mostrar Trabajadores\n" +
                    "6. Volver"
            );

            if (op == null) continue;

            switch (op) {

                case "1":
                    String nombT = JOptionPane.showInputDialog("Nombre del trabajador:");
                    if (nombT == null || nombT.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Nombre inválido.");
                        continue;
                    }

                    String idT = JOptionPane.showInputDialog("ID del trabajador:");
                    if (idT == null || idT.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "ID inválido.");
                        continue;
                    }

                    int horas = 0;
                    boolean validoH = false;
                    while (!validoH) {
                        String h = JOptionPane.showInputDialog("Horas trabajadas:");
                        if (h == null) break;

                        try {
                            horas = Integer.parseInt(h);
                            validoH = true;
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Ingrese un número válido.");
                        }
                    }

                    boolean asistencia = JOptionPane.showConfirmDialog(
                            null, "¿Asistió hoy?", "Asistencia", JOptionPane.YES_NO_OPTION
                    ) == JOptionPane.YES_OPTION;

                    trabajadores.add(new Trabajador(2, nombT, idT, horas, asistencia));
                    JOptionPane.showMessageDialog(null, "Trabajador registrado correctamente.");
                    break;

                case "2":
                    inventario.registrarProducto();
                    break;

                case "3":
                    String nombA = JOptionPane.showInputDialog("Nombre del administrador:");
                    if (nombA == null || nombA.trim().isEmpty()) continue;

                    String idA = JOptionPane.showInputDialog("ID del administrador:");
                    if (idA == null || idA.trim().isEmpty()) continue;

                    String contra = JOptionPane.showInputDialog("Contraseña:");
                    if (contra == null || contra.trim().isEmpty()) continue;

                    admins.add(new Administrador(1, nombA, idA, contra));
                    JOptionPane.showMessageDialog(null, "Administrador registrado correctamente.");
                    break;

                case "4":
                    if (inventario.getProductos().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No hay productos registrados.");
                        break;
                    }

                    String listaP = "PRODUCTOS REGISTRADOS:\n\n";

                    for (Producto p : inventario.getProductos()) {
                        listaP += "- ID: " + p.getIdef()
                                + " | Nombre: " + p.getName()
                                + " | Precio: $" + p.getPrice()
                                + " | Cantidad: " + p.getCantidad()
                                + "\n";
                    }

                    JOptionPane.showMessageDialog(null, listaP);
                    break;

                case "5":
                    if (trabajadores.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No hay trabajadores registrados.");
                        break;
                    }

                    String listaT = "TRABAJADORES REGISTRADOS:\n\n";

                    for (Trabajador t : trabajadores) {

                        listaT += "Nombre: " + t.getNombre() + "\n";
                        listaT += "ID: " + t.getIdPersona() + "\n";
                        listaT += "Horas: " + t.getHoras() + "\n";
                        listaT += "Asistencia: " + (t.isAsistencia() ? "Sí" : "No") + "\n";
                        listaT += "-------------------------------------\n";
                    }

                    JOptionPane.showMessageDialog(null, listaT);
                    break;

                case "6":
                    return;

                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida.");
            }
        }
    }

    // MENÚ TRABAJADOR
    public static void menuTrabajador(ArrayList<cliente> clientes, Inventario inventario) {

        while (true) {

            inventario.alertarBajos();

            String op = JOptionPane.showInputDialog(
                    "===== TRABAJADOR =====\n" +
                    "1. Registrar Cliente\n" +
                    "2. Venta\n" +
                    "3. Volver"
            );

            if (op == null) continue;

            switch (op) {

                case "1":
                    String n = JOptionPane.showInputDialog("Nombre cliente:");
                    if (n == null || n.trim().isEmpty()) continue;

                    String id = JOptionPane.showInputDialog("ID:");
                    if (id == null || id.trim().isEmpty()) continue;

                    clientes.add(new cliente(3, n, id));
                    JOptionPane.showMessageDialog(null, "Cliente registrado.");
                    break;

                case "2":
                    inventario.realizarVenta();
                    break;

                case "3":
                    return;

                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida.");
            }
        }
    }
}
