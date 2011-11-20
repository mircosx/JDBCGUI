package Vista;

import Controlador.Controlador;
import java.awt.Dimension;
import java.awt.GridLayout;

import java.awt.event.KeyEvent;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class Vista {
    
    //Declaracion de todos los elementos que haran falta
    //para visualizar la interfaz grafica
    
    //JFrame principal
    //Va a contener todos los elementos de mi aplicacion
    private JFrame frame;
    
    //JMenuBar
    //Barra de menu que va a contener los menu de mi aplicacion
    private JMenuBar barraMenu;
    
    //JMenu
    //Los dos menu principales de mi aplicacion
    private JMenu menu1, menu2;
    
    //JMenuItem
    //Los items que componen los dos menu
    private JMenuItem vozMenu1, vozMenu2, vozMenu3, vozMenu4;
    
    //JPanel
    //Para visualizar los campos cargado desde el DataBase he utilizado
    //el layout GridBox, divide el JFrame en un numero determinado
    //de lineas por columnas, en mi caso 4 lineas y 4 columnas
    //por un total de 16 paneles
    private JPanel panelSX0, panelCT0, panelDX0, panelDX0b;
    private JPanel panelSX1, panelCT1, panelDX1, panelDX1b;
    private JPanel panelSX2, panelCT2, panelDX2, panelDX2b;
    private JPanel panelSX3, panelCT3, panelDX3, panelDX3b;
    
    //JScrollPane
    //Elemento que añade funcionalidad de scroll a los frames
    JScrollPane jsSX0;
    
    //TitledBorder 
    //Contenedores del nombre de los titulos de los JFrame
    private TitledBorder titulo1, titulo2, titulo3, titulo4;
    
    //Atributo que contiene el controlador de nuestro modelo MVC
    private Controlador controlador;

    public Vista() {
        //Titulo de la ventana principal de la aplicacion
        frame = new JFrame("Ejemplo practico de manipulacion de DB y layouts en Java");
        
        //Panel del GridBox 1,1
        //Contenedor del campo tabla1 -> campoEntero
        panelSX0 = new JPanel();
        //El panel alineara verticalmente los elementos que se les añadiran
        panelSX0.setLayout(new BoxLayout(panelSX0, BoxLayout.Y_AXIS));
        //Añade scroll al panel
        jsSX0 = new JScrollPane(panelSX0);
        jsSX0.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jsSX0.setWheelScrollingEnabled(true);
        
        //Panel del GridBox 1,2
        //Contenedor del campo tabal1 -> campoTexto
        panelCT0 = new JPanel();
        //El panel alineara verticalmente los elementos que se les añadiran
        panelCT0.setLayout(new BoxLayout(panelCT0, BoxLayout.Y_AXIS));

        //Panel del GridBox 1,3
        //Contenedor del campo tabla1 -> campoFloat
        panelDX0 = new JPanel();
        //El panel alineara verticalmente los elementos que se les añadiran
        panelDX0.setLayout(new BoxLayout(panelDX0, BoxLayout.Y_AXIS));

        //Panel del GridBox 1,4
        //Sin contenido, rellena la casilla del GridBox para mantener la estructura
        panelDX0b = new JPanel();
        //El panel alineara verticalmente los elementos que se les añadiran
        panelDX0b.setLayout(new BoxLayout(panelDX0b, BoxLayout.Y_AXIS));

        //Panel del Gridbox 2,1
        //Contenedor del campo Curso -> numeroExpediente
        panelSX1 = new JPanel();
        //El panel alineara verticalmente los elementos que se les añadiran
        panelSX1.setLayout(new BoxLayout(panelSX1, BoxLayout.Y_AXIS));
        
        //Panel del GridBox 2,2
        //Contenedor del campo Curso -> nombreCurso
        panelCT1 = new JPanel();
        //El panel alineara verticalmente los elementos que se les añadiran
        panelCT1.setLayout(new BoxLayout(panelCT1, BoxLayout.Y_AXIS));
        
        //Panel del GridBox 2,3
        //Contenedor del campo Curso -> fechaComienzo
        panelDX1 = new JPanel();
        //El panel alineara verticalmente los elementos que se les añadiran
        panelDX1.setLayout(new BoxLayout(panelDX1, BoxLayout.Y_AXIS));
        
        //Panel del GridBox 2,4
        //Contenedor del campo Curso -> horas
        panelDX1b = new JPanel();
        //El panel alineara verticalmente los elementos que se les añadiran
        panelDX1b.setLayout(new BoxLayout(panelDX1b, BoxLayout.Y_AXIS));

        //Panel del GridBox 3,1
        //Contenedor del campo Persona -> dni
        panelSX2 = new JPanel();
        //El panel alineara verticalmente los elementos que se les añadiran
        panelSX2.setLayout(new BoxLayout(panelSX2, BoxLayout.Y_AXIS));
        
        //Panel del GridBox 3,2
        //Contenedor del campo Persona -> nombre
        panelCT2 = new JPanel();
        //El panel alineara verticalmente los elementos que se les añadiran
        panelCT2.setLayout(new BoxLayout(panelCT2, BoxLayout.Y_AXIS));
        
        //Panel del GridBox 3,3
        //Sin contenido, rellena la casilla del GridBox para mantener la estructura
        panelDX2 = new JPanel();
        //El panel alineara verticalmente los elementos que se les añadiran
        panelDX2.setLayout(new BoxLayout(panelDX2, BoxLayout.Y_AXIS));
        
        //Panel del GridBox 3,4
        //Sin contenido, rellena la casilla del GridBox para mantener la estructura
        panelDX2b = new JPanel();
        //El panel alineara verticalmente los elementos que se les añadiran
        panelDX2b.setLayout(new BoxLayout(panelDX2b, BoxLayout.Y_AXIS));

        //Panel del GridBox 4,1
        //Contenedor del campo Evaluacion -> numExpedienteCurso
        panelSX3 = new JPanel();
        //El panel alineara verticalmente los elementos que se les añadiran
        panelSX3.setLayout(new BoxLayout(panelSX3, BoxLayout.Y_AXIS));
        
        //Panel del GridBox 4,2
        //Contenedor del campo Evaluacion -> dniPersona
        panelCT3 = new JPanel();
        //El panel alineara verticalmente los elementos que se les añadiran
        panelCT3.setLayout(new BoxLayout(panelCT3, BoxLayout.Y_AXIS));
        
        //Panel del GridBox 4,3
        //Contenedor del campo Evaluacion -> fecha
        panelDX3 = new JPanel();
        //El panel alineara verticalmente los elementos que se les añadiran
        panelDX3.setLayout(new BoxLayout(panelDX3, BoxLayout.Y_AXIS));
        
        //Panel del GridBox 4,4
        //Contenedor del campo Evaluacion -> fecha
        panelDX3b = new JPanel();
        //El panel alineara verticalmente los elementos que se les añadiran
        panelDX3b.setLayout(new BoxLayout(panelDX3b, BoxLayout.Y_AXIS));

        //Inicializo la barra del menu de la aplicacion
        barraMenu = new JMenuBar();
        
        //Inicializacion del menu "Acciones"
        menu1 = new JMenu("Acciones");
        //Asigno ALT-A como atajo de teclado
        menu1.setMnemonic(KeyEvent.VK_A);
       
        //Inicializacion del menu "Salir"
        menu2 = new JMenu("Salir");
        //Asigno ALT-S como atajo de teclado
        menu2.setMnemonic(KeyEvent.VK_S);
        
        //Agrego los dos menu "Acciones" y "Salir" a la barra del menu
        barraMenu.add(menu1);
        barraMenu.add(menu2);

        //Inicializo el MenuItem y asigno atajo de teclado (VK_F2)
        vozMenu1 = new JMenuItem("Conecta al DB", KeyEvent.VK_F2);
        //Inicializo el escuchador de teclado y lo asigno al MenuItem
        KeyStroke f2KeyStroke = KeyStroke.getKeyStroke("F2");
        vozMenu1.setAccelerator(f2KeyStroke);
        
        //Inicializo el MenuItem y asigno atajo de teclado (VK_F2)
        vozMenu2 = new JMenuItem("Carga datos del DB", KeyEvent.VK_F3);
        //Inicializo el escuchador de teclado y lo asigno al MenuItem
        KeyStroke f3KeyStroke = KeyStroke.getKeyStroke("F3");
        vozMenu2.setAccelerator(f3KeyStroke);
        
        //Inicializo el MenuItem y asigno atajo de teclado (VK_F2)
        vozMenu3 = new JMenuItem("Consulta general", KeyEvent.VK_F4);
        //Inicializo el escuchador de teclado y lo asigno al MenuItem
        KeyStroke f4KeyStroke = KeyStroke.getKeyStroke("F4");
        vozMenu3.setAccelerator(f4KeyStroke);
        
        //Inicializo el MenuItem y asigno atajo de teclado (VK_F2)
        vozMenu4 = new JMenuItem("Salir", KeyEvent.VK_F5);
        //Inicializo el escuchador de teclado y lo asigno al MenuItem
        KeyStroke f5KeyStroke = KeyStroke.getKeyStroke("F5");
        vozMenu4.setAccelerator(f5KeyStroke);

        //Agrego los MenuItems al menu "Acciones" (menu1 de la barra del menu) 
        menu1.add(vozMenu1);
        menu1.add(vozMenu2);
        menu1.add(vozMenu3);
        //Agrego el MenuItem al menu "Salir" (menu2 de la barra del menu)
        menu2.add(vozMenu4);

        //----- PANEL DE LOS CAMPOS DE TABLA1
        //Creacion de un border con leyenda que asignare a los contenedores
        //de JTextField de los campos que cargaremos del DataBase
        titulo1 = BorderFactory.createTitledBorder("Campos enteros");
        //Asigno el border al JPanel contenedor
        panelSX0.setBorder(titulo1);
        //Repito lo mismo para todos los contenedores de JTextField
        titulo2 = BorderFactory.createTitledBorder("Campos texto");
        panelCT0.setBorder(titulo2);
        titulo3 = BorderFactory.createTitledBorder("Campos float");
        panelDX0.setBorder(titulo3);

        //Especifico dimensiones del contenedor de los 4 JPanel
        panelSX0.setPreferredSize(new Dimension(150, 50));
        panelCT0.setPreferredSize(new Dimension(150, 50));
        panelDX0.setPreferredSize(new Dimension(150, 50));
        panelDX0b.setPreferredSize(new Dimension(150, 50));

        //----- PANEL DE LOS CURSOS
        titulo1 = BorderFactory.createTitledBorder("Numero expediente");
        panelSX1.setBorder(titulo1);
        titulo2 = BorderFactory.createTitledBorder("Nombre curso");
        panelCT1.setBorder(titulo2);
        titulo3 = BorderFactory.createTitledBorder("Fecha comienzo");
        panelDX1.setBorder(titulo3);
        titulo4 = BorderFactory.createTitledBorder("Horas duracion");
        panelDX1b.setBorder(titulo4);

        panelSX1.setPreferredSize(new Dimension(150, 50));
        panelCT1.setPreferredSize(new Dimension(150, 50));
        panelDX1.setPreferredSize(new Dimension(150, 50));
        panelDX1b.setPreferredSize(new Dimension(150, 50));

        //----- PANEL DE LAS PERSONAS
        titulo1 = BorderFactory.createTitledBorder("Dni");
        panelSX2.setBorder(titulo1);
        titulo2 = BorderFactory.createTitledBorder("Nombre");
        panelCT2.setBorder(titulo2);

        panelSX2.setPreferredSize(new Dimension(150, 50));
        panelCT2.setPreferredSize(new Dimension(150, 50));
        panelDX2.setPreferredSize(new Dimension(150, 50));
        panelDX2b.setPreferredSize(new Dimension(150, 50));

        //----- PANEL DE LAS EVALUACIONES
        titulo1 = BorderFactory.createTitledBorder("Numero expediente");
        panelSX3.setBorder(titulo1);
        titulo2 = BorderFactory.createTitledBorder("Dni");
        panelCT3.setBorder(titulo2);
        titulo3 = BorderFactory.createTitledBorder("Fecha");
        panelDX3.setBorder(titulo3);
        titulo4 = BorderFactory.createTitledBorder("Puntuacion");
        panelDX3b.setBorder(titulo4);

        panelSX3.setPreferredSize(new Dimension(150, 50));
        panelCT3.setPreferredSize(new Dimension(150, 50));
        panelDX3.setPreferredSize(new Dimension(150, 50));
        panelDX3b.setPreferredSize(new Dimension(150, 50));
        //----- FIN PANEL

        //Asigno la barraMenu que cree al frame
        frame.setJMenuBar(barraMenu);
        
        //Agregamos todos los componentes que he creado al frame
        frame.add(jsSX0);
        frame.add(panelCT0);
        frame.add(panelDX0);
        frame.add(panelDX0b);

        frame.add(panelSX1);
        frame.add(panelCT1);
        frame.add(panelDX1);
        frame.add(panelDX1b);

        frame.add(panelSX2);
        frame.add(panelCT2);
        frame.add(panelDX2);
        frame.add(panelDX2b);

        frame.add(panelSX3);
        frame.add(panelCT3);
        frame.add(panelDX3);
        frame.add(panelDX3b);

        //GridLayout
        //Mi aplicacion se visualizara con layout GridBox
        //Contrendra 4 lineas (4,...)
        // 4 columnas (..,4,..)
        //se distanciara horizontalmente 5 pixels (..,..,5,..)
        //y verticalmente 10 pixels (..,..,..,10)
        frame.setLayout(new GridLayout(4, 4, 5, 10));
        
        //Accion de default al cerrar la ventana: Salir de la aplicacion
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
        vozMenu1.addActionListener(controlador);
        vozMenu2.addActionListener(controlador);
        vozMenu3.addActionListener(controlador);
        vozMenu4.addActionListener(controlador);
    }

    public void arranca() {
        frame.pack();
        frame.setVisible(true);
    }

    public void setTexto1(String txt) {
        JTextField campo = new JTextField();
        campo.setText(txt);
        panelSX0.add(campo);
        jsSX0.validate();
    }

    public void setTexto2(String txt) {
        JTextField campo = new JTextField();
        campo.setText(txt);
        panelCT0.add(campo);
        panelCT0.validate();
    }

    public void setTexto3(String txt) {
        JTextField campo = new JTextField();
        campo.setText(txt);
        panelDX0.add(campo);
        panelDX0.validate();
    }

    public void agregaNumeroExpediente(String txt) {
        JTextField campo = new JTextField();
        campo.setText(txt);
        panelSX1.add(campo);
        panelSX1.validate();
    }

    public void agregaNombreCurso(String txt) {
        JTextField campo = new JTextField();
        campo.setText(txt);
        panelCT1.add(campo);
        panelCT1.validate();
    }

    public void agregaFechaComienzo(String txt) {
        JTextField campo = new JTextField();
        campo.setText(txt);
        panelDX1.add(campo);
        panelDX1.validate();
    }

    public void agregaHorasDuracion(String txt) {
        JTextField campo = new JTextField();
        campo.setText(txt);
        panelDX1b.add(campo);
        panelDX1b.validate();
    }

    public void agregaDniPersona(String txt) {
        JTextField campo = new JTextField();
        campo.setText(txt);
        panelSX2.add(campo);
        panelSX2.validate();
    }

    public void agregaNombrePersona(String txt) {
        JTextField campo = new JTextField();
        campo.setText(txt);
        panelCT2.add(campo);
        panelCT2.validate();
    }

    public void agregaNumeroExpedienteEvaluacion(String txt) {
        JTextField campo = new JTextField();
        campo.setText(txt);
        panelSX3.add(campo);
        panelSX3.validate();
    }

    public void agregaDniEvaluacion(String txt) {
        JTextField campo = new JTextField();
        campo.setText(txt);
        panelCT3.add(campo);
        panelCT3.validate();
    }

    public void agregaFechaEvaluacion(String txt) {
        JTextField campo = new JTextField();
        campo.setText(txt);
        panelDX3.add(campo);
        panelDX3.validate();
    }

    public void agregaPuntuacion(String txt) {
        JTextField campo = new JTextField();
        campo.setText(txt);
        panelDX3b.add(campo);
        panelDX3b.validate();
    }

    public void unsetMenu() {
        vozMenu3.isOpaque();
    }
}