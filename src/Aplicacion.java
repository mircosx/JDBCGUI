import Controlador.Controlador;
import Modelo.Modelo;
import Vista.Vista;

public class Aplicacion {
    public static void main(String[] args) {
        Modelo modelo = new Modelo();
        Vista vista = new Vista();
        Controlador controlador = new Controlador(vista, modelo);
        vista.setControlador(controlador);
        vista.arranca();
    }
}