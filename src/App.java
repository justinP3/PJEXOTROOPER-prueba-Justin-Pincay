import PjBL.PjAppExotrooper;
import PjInfraestructure.CMD;

public class App {
    public static void main(String[] args) {
        try {
            PjAppExotrooper appSystem = new PjAppExotrooper();

            appSystem.start();

        } catch (Exception e) {
            CMD.printlnError("Error crítico al iniciar ExoTrooper: " + e.getMessage());
            e.printStackTrace();
        }
    }
}