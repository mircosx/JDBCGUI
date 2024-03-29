package Modelo;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;

public class Modelo {

    private Connection conn;
    private List tabla1 = new ArrayList();
    private Map<Integer, Persona> listaPersonas = new HashMap<Integer, Persona>();
    private Map<Integer, Curso> impartidos = new HashMap<Integer, Curso>();
    private Map<Integer, Evaluacion> evaluacionesMod = new HashMap<Integer, Evaluacion>();

    public Modelo() {
    }

    public void conecta() {
        System.out.println("Conectando al DB...");
        conn = conexion();
    }

    public Connection conexion() {
        String url = "jdbc:mysql://localhost/simple";
        String userName = "root";
        String password = "";

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(url, userName, password);
            System.out.println("Coneccion a BD establecida");
        } catch (SQLException ex1) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex1);
        } catch (IllegalAccessException ex2) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex2);
        } catch (InstantiationException ex3) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex3);
        } catch (ClassNotFoundException ex3) {
            System.err.println("ClassNotFoundException");
        } catch (Exception ex4) {
            System.err.println("Exception");
        }
        return conn;
    }

    public void inicializaModeloDesdeDB() {
        inicializaTabla1();
        inicializaPersonas();
        inicializaImpartidos();
        inicializaCursoEvaluaciones();
        inicializaPersonaEvaluaciones();
        inicializaEvaluacionesDesdeBD();

        //-------------------------
        Persona p = new Persona(6088863, "Mirco");
        Curso c = new Curso(9, "UML", new Date(2011, 1, 10), 200);
        Evaluacion e = new Evaluacion(c.getNumeroExpediente(), p.getDni(), new Date(2011, 1, 10), 7);
        c.agregaEvaluacion(e);
        p.agregaEvaluacion(e);
        addCursoAlDB(c);
        addPersonaAlDB(p);
        addEvaluacionAlDB(e);
        //-------------------------
    }

    private void inicializaTabla1() {
        Statement s;
        try {
            s = conn.createStatement();

            String query = "SELECT * FROM Tabla1";
            System.err.println(query);
            s.executeQuery(query);
            ResultSet rs = s.getResultSet();

            int campoEntero;
            String campoTexto;
            float campoFloat;

            while (rs.next()) {
                campoEntero = rs.getInt("campoEntero");
                campoTexto = rs.getString("campoTexto");
                campoFloat = rs.getFloat("campoFloat");
                System.out.println(campoEntero + "," + campoTexto + "," + campoFloat);
                tabla1.add(new FilaTabla1(campoEntero, campoTexto, campoFloat));
            }
        } catch (Exception ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void inicializaPersonas() {
        Statement s;
        try {
            s = conn.createStatement();

            String query = "SELECT * FROM Persona";
            System.err.println(query);
            s.executeQuery(query);
            ResultSet rs = s.getResultSet();

            int dni;
            String nombre;

            while (rs.next()) {
                dni = rs.getInt("dni");
                nombre = rs.getString("nombre");
                System.out.println(dni + "," + nombre);
                listaPersonas.put(new Integer(dni), new Persona(dni, nombre));
            }
        } catch (Exception ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void inicializaImpartidos() {
        Statement s;
        try {
            s = conn.createStatement();

            String query = "SELECT * FROM Curso";
            System.err.println(query);
            s.executeQuery(query);
            ResultSet rs = s.getResultSet();

            int numeroExpediente;
            String nombreCurso;
            Date fechaComienzo;
            int horas;

            Curso curso;

            while (rs.next()) {
                numeroExpediente = rs.getInt("numeroExpediente");
                nombreCurso = rs.getString("nombreCurso");
                fechaComienzo = rs.getDate("fechaComienzo");
                horas = rs.getInt("horas");
                System.out.println(numeroExpediente + "," + nombreCurso + ", " + fechaComienzo + "," + horas);
                curso = new Curso(numeroExpediente, nombreCurso, fechaComienzo, horas);

                impartidos.put(numeroExpediente, curso);
            }
        } catch (Exception ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void addEvaluacionesACursoDesdeBD(Curso curso) {
        Statement s;

        try {
            s = conn.createStatement();

            String query = "SELECT * FROM Evaluacion WHERE numExpedienteCurso=" + curso.getNumeroExpediente();
            System.err.println(query);
            s.executeQuery(query);
            ResultSet rs = s.getResultSet();

            Curso cursoEv;
            Persona persona;
            Date fecha;
            float puntuacion;
            int dniPersona;

            Evaluacion evaluacion = null;
            List<Evaluacion> evaluaciones = curso.getEvaluaciones();

            while (rs.next()) {
                fecha = rs.getDate("fecha");
                puntuacion = rs.getFloat("puntuacion");
                dniPersona = rs.getInt("dniPersona");

                evaluacion = new Evaluacion(curso, listaPersonas.get(dniPersona), fecha, puntuacion);
                evaluaciones.add(evaluacion);
                //System.out.println(numExpediente + "," + nombreCurso + "," + fechaComienzo + "," + horas);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void inicializaEvaluacionesDesdeBD() {
        Statement s;

        try {
            s = conn.createStatement();

            String query = "SELECT * FROM Evaluacion";
            System.err.println(query);
            s.executeQuery(query);
            ResultSet rs = s.getResultSet();

            Evaluacion evAux;
            Date fecha;
            float puntuacion;
            int dniPersona;
            int numExp;

            while (rs.next()) {
                numExp = rs.getInt("numExpedienteCurso");
                fecha = rs.getDate("fecha");
                puntuacion = rs.getFloat("puntuacion");
                dniPersona = rs.getInt("dniPersona");

                evAux = new Evaluacion(numExp, dniPersona, fecha, puntuacion);
                evaluacionesMod.put(evAux.getDniPersona(), evAux);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void inicializaCursoEvaluaciones() {
        Collection<Curso> listaCursos = impartidos.values();
        for (Iterator<Curso> i = listaCursos.iterator(); i.hasNext();) {
            addEvaluacionesACursoDesdeBD(i.next());
        }
    }

    private void addEvaluacionesAPersonaDesdeBD(Persona persona) {
        Statement s;

        try {
            s = conn.createStatement();

            String query = "SELECT * FROM Evaluacion WHERE dniPersona=" + persona.getDni();
            System.err.println(query);
            s.executeQuery(query);
            ResultSet rs = s.getResultSet();

            int numExpedienteCurso;
            Date fecha;
            float puntuacion;
            int dniPersona;

            Evaluacion evaluacion = null;
            List<Evaluacion> evaluaciones = persona.getEvaluaciones();

            while (rs.next()) {
                fecha = rs.getDate("fecha");
                puntuacion = rs.getFloat("puntuacion");
                numExpedienteCurso = rs.getInt("numExpedienteCurso");
                dniPersona = rs.getInt("dniPersona");

                evaluacion = new Evaluacion(impartidos.get(numExpedienteCurso), listaPersonas.get(dniPersona), fecha, puntuacion);
                evaluaciones.add(evaluacion);
                //System.out.println(numExpediente + "," + nombreCurso + "," + fechaComienzo + "," + horas);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void inicializaPersonaEvaluaciones() {
        Collection<Persona> listaPersonasAux = listaPersonas.values();
        for (Iterator<Persona> i = listaPersonasAux.iterator(); i.hasNext();) {
            addEvaluacionesAPersonaDesdeBD(i.next());
        }
    }

    public void addCursoAlDB(Curso curso) {
        Statement s;
        try {
            s = conn.createStatement();

            Date fecha = curso.getFechaComienzo();
            String fechaStr = fecha.getYear() + "-" + (fecha.getMonth() + 1) + "-" + fecha.getDate();

            String query = "INSERT INTO Curso (numeroExpediente, nombreCurso, fechaComienzo, horas) "
                    + " VALUES(" + curso.getNumeroExpediente() + ",'" + curso.getNombreCurso() + "','" + fechaStr + "'," + curso.getHoras() + ")";
            System.err.println(query);
            s.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addPersonaAlDB(Persona persona) {
        Statement s;
        try {
            s = conn.createStatement();

            int dni = persona.getDni();
            String nombre = persona.getNombre();

            String query = "INSERT INTO Persona (dni, nombre) "
                    + " VALUES(" + dni + ",'" + nombre + "')";
            System.err.println(query);
            s.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addEvaluacionAlDB(Evaluacion evaluacion) {
        Statement s;
        try {
            s = conn.createStatement();

            int evCurso = evaluacion.getNumExpedienteCurso();
            int dni = evaluacion.getDniPersona();
            Date fecha = evaluacion.getFecha();
            float punt = evaluacion.getPuntuacion();
            String fechaStr = fecha.getYear() + "-" + (fecha.getMonth() + 1) + "-" + fecha.getDate();

            String query = "INSERT INTO Evaluacion (numExpedienteCurso, dniPersona,fecha, puntuacion) "
                    + " VALUES(" + evCurso + "," + dni + ",'" + fechaStr + "'," + punt + ")";
            System.err.println(query);
            s.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Map<Integer, Curso> getImpartidos() {
        return impartidos;
    }

    public Map<Integer, Persona> getListaPersonas() {
        return listaPersonas;
    }

    public Map<Integer, Evaluacion> getEvaluacionesMod() {
        return evaluacionesMod;
    }

    public List getTabla1() {
        return tabla1;
    }
}
