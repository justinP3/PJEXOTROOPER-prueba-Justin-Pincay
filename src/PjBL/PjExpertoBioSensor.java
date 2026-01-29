package PjBL;

public class PjExpertoBioSensor {

    public PjExpertoBioSensor() {
    }

    public String PjEntrenar(PjIEntrenoSensor alumno) {
        // El experto ordena al alumno usar el sensor
        alumno.PjUsarSensor();
        return "Soldado Experto (BioSensor): Entrenamiento completado.";
    }
}