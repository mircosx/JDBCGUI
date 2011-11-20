package Controlador;

import Modelo.*;
import Vista.Vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

public class Controlador implements ActionListener {

    Vista vista;
    Modelo modelo;

    public Controlador(Vista vista, Modelo modelo) {
        this.vista = vista;
        this.modelo = modelo;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        System.out.println("Evento -> "+ae.getActionCommand().toString());

        if (ae.getActionCommand().equalsIgnoreCase("Conecta al DB")) {
            modelo.conecta();
        }

        if (ae.getActionCommand().equalsIgnoreCase("Carga datos del DB")) {
            modelo.inicializaModeloDesdeDB();
        }

        if (ae.getActionCommand().equalsIgnoreCase("Consulta general")) {

            List auxTabla = modelo.getTabla1();
            for (int i = 0; i < modelo.getTabla1().size(); i++) {
                FilaTabla1 auxFila = (FilaTabla1) auxTabla.get(i);
                System.out.println("auxFila.getCampoEntero():" + auxFila.getCampoEntero());
                vista.setTexto1(auxFila.getCampoEntero());
                System.out.println("auxFila.getCampoTexto():" + auxFila.getCampoTexto());
                vista.setTexto2(auxFila.getCampoTexto());
                System.out.println("auxFila.getCampoFloat():" + auxFila.getCampoFloat());
                vista.setTexto3(auxFila.getCampoFloat());
            }
            
            Map<Integer, Curso> auxCurso = modelo.getImpartidos();
            for (Map.Entry<Integer, Curso> entry : auxCurso.entrySet()) {
                vista.agregaNumeroExpediente(entry.getValue().getNumeroExpediente() + "");
                vista.agregaNombreCurso(entry.getValue().getNombreCurso());
                vista.agregaFechaComienzo(entry.getValue().getFechaComienzo() + "");
                vista.agregaHorasDuracion(entry.getValue().getHoras() + "");
            }
            
            Map<Integer, Persona> auxPersona = modelo.getListaPersonas();
            for (Map.Entry<Integer, Persona> entry : auxPersona.entrySet()) {
                vista.agregaDniPersona(entry.getValue().getDni() + "");
                vista.agregaNombrePersona(entry.getValue().getNombre());
            }

            Map<Integer, Evaluacion> auxEval = modelo.getEvaluacionesMod();
            for (Map.Entry<Integer, Evaluacion> entry : auxEval.entrySet()) {
                vista.agregaNumeroExpedienteEvaluacion(entry.getValue().getNumExpedienteCurso() + "");
                vista.agregaDniEvaluacion(entry.getValue().getDniPersona() + "");
                vista.agregaFechaEvaluacion(entry.getValue().getFecha() + "");
                vista.agregaPuntuacion(entry.getValue().getPuntuacion() + "");
            }
        
        }

        if (ae.getActionCommand().equalsIgnoreCase("Salir")) {
            System.exit(0);
        }
    }
}
