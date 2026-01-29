package PjBL;

public class PjBrazoDerecho {

    public PjBrazoDerecho() {
    }

    public String PjUsarArma(PjMunicion municion, PjArma arma) {
        if (municion == null || arma == null) {
            return "Error: Falta arma o munición";
        }
        return "Disparando " + arma.getPjNombre() + " usando " + municion.getPjNombre();
    }
}