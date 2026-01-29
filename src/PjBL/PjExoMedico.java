package PjBL;

public class PjExoMedico extends PjEXOBOT {

    public PjExoMedico() {
        super(); // Importante: Esto crea los brazos y las piernas definidos en el padre
    }

    @Override
    public boolean entrenar() {
        // Lógica de entrenamiento
        return true;
    }

    @Override
    public String realizarAccion() {

        this.setPjNAccion(this.getPjNAccion() + 1);

        PjArma herramienta = new PjBioSensor();
        PjMunicion energia = new PjEnergiaBioSensor();

        return this.brazoDerecho.pjUsarArma(energia, herramienta);
    }

    @Override
    public boolean Asistir() {
        return true;
    }
}