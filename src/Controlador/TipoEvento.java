package Controlador;

public enum TipoEvento {
   
    SALIR("Salir"),
    CONSULTA_GENERAL("Consulta catálogo general");
    private String tipoEvento;

    private TipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public String getTipoEvento() {
        return tipoEvento;
    } 
}
