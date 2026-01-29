package PjBL;

public abstract class PjEXOBOT extends PjIAEXO {

    // Estos atributos recibirán los valores del DTO
    protected Integer pjIdExoBot;
    protected Integer pjIdTipoExoBot; // <-- Este se llena con el DTO
    protected String pjEntrenamiento;
    protected Integer pjNAccion;

    protected PjBrazoDerecho brazoDerecho;
    protected PjBrazoIzquierdo brazoIzquierdo;
    protected PjPierna pierna;

    public PjEXOBOT() {
        this.brazoDerecho = new PjBrazoDerecho();
        this.brazoIzquierdo = new PjBrazoIzquierdo();
        this.pierna = new PjPierna();
        this.pjNAccion = 0;
        this.pjEntrenamiento = "NO";
    }

    // Getters y Setters obligatorios para que funcione el código de arriba
    public void setPjIdExoBot(Integer id) {
        this.pjIdExoBot = id;
    }

    public Integer getPjIdExoBot() {
        return pjIdExoBot;
    }

    public void setPjIdTipoExoBot(Integer idTipo) {
        this.pjIdTipoExoBot = idTipo;
    }

    public Integer getPjIdTipoExoBot() {
        return pjIdTipoExoBot;
    }

    public String getPjEntrenamiento() {
        return pjEntrenamiento;
    }

    public void setPjEntrenamiento(String e) {
        this.pjEntrenamiento = e;
    }

    public Integer getPjNAccion() {
        return pjNAccion;
    }

    public void setPjNAccion(Integer n) {
        this.pjNAccion = n;
    }
}