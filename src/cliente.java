public class cliente extends persona {

    private int puntosCliente;

    public cliente(int tipoAcceso, String nombre, String idPersona) {
        super(tipoAcceso, nombre, idPersona);
        this.puntosCliente = 0; //gracias por ayudarme
        /*de nada :D */
    }

    public int getPuntosCliente() {
        return puntosCliente;
    }

    public void setPuntosCliente(int puntosCliente) {
        this.puntosCliente = puntosCliente;
    }
}
