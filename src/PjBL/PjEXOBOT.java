package PjBL;

public abstract class PjEXOBOT extends PjIAEXO {

    // Atributos definidos en tu diagrama (Imagen 1)
    private Integer PjIdExobot;
    private Integer PjIdTipoExobot;
    private Boolean PjEntrenamiento; // En diagrama dice Boolean
    private Integer PjNAccion;

    // COMPOSICIÓN (Los rombos negros de tu diagrama)
    // Se declaran como 'protected' o tienen getters para que los hijos (ExoMedico)
    // los usen.
    protected PjBrazoDerecho brazoDerecho;
    protected PjBrazoIzquierdo brazoIzquierdo;
    protected PjPierna pierna;

    public PjEXOBOT() {
        // En la composición, el ciclo de vida de las partes depende del todo.
        // Las instanciamos aquí mismo.
        this.brazoDerecho = new PjBrazoDerecho();
        this.brazoIzquierdo = new PjBrazoIzquierdo();
        this.pierna = new PjPierna();

        // Inicialización por defecto
        this.PjNAccion = 0;
        this.PjEntrenamiento = false;
    }

    // Métodos abstractos para obligar a definir comportamiento
    public abstract boolean entrenar();

    public abstract String realizarAccion();

    // Getters y Setters según tu diagrama
    public Integer getPjNAccion() {
        return PjNAccion;
    }

    public void setPjNAccion(Integer pjNAccion) {
        PjNAccion = pjNAccion;
    }

    // ... resto de getters y setters ...
}