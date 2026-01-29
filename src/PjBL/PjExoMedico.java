package PjBL;

public class PjExoMedico extends PjEXOBOT implements PjIEntrenoSensor, PjIEntrenoScanner {

    public PjExoMedico() {
        super();
    }

    @Override
    public boolean Asistir() {
        this.pjNAccion++;

        PjArma herramienta = new PjBioEscanner();
        PjMunicion energia = new PjEnergiaBioEscanner();

        String resultado = this.brazoDerecho.PjUsarArma(energia, herramienta);

        System.out.println("ACCION: " + resultado);
        return true;
    }

    @Override
    public void PjUsarSensor() {
        System.out.println("ExoMedico: Entrenando con SENSOR...");
        this.setPjEntrenamiento("SI");
    }

    @Override
    public void PjUsarScanner() {
        System.out.println("ExoMedico: Entrenando con SCANNER...");
        this.setPjEntrenamiento("SI");
    }
}