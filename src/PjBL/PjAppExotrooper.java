package PjBL;

import javax.swing.SwingUtilities;
import PjInfraestructure.CMD;
import PjInfraestructure.CMDInput;
import PjInfraestructure.AppMSG;
import PjGUI.PjPAlumnos;

public class PjAppExotrooper {

    public PjAppExotrooper() {
    }

    public void start() {
        CMD.clear();

        boolean accesoConcedido = this.autenticar();

        if (accesoConcedido) {
            CMD.println("\nGOOD : Acceso concedido");
            CMD.println("🚀 Cargando interfaz gráfica...");

            SwingUtilities.invokeLater(() -> {
                try {
                    PjPAlumnos frame = new PjPAlumnos();
                    frame.setVisible(true);
                } catch (Exception e) {
                    CMD.printlnError("Error al abrir la GUI: " + e.getMessage());
                }
            });

        } else {
            CMD.printlnError("\nERROR : Acceso denegado.");
            AppMSG.showError("Has excedido el número de intentos. Cerrando sistema.");
            System.exit(0);
        }
    }

    private boolean autenticar() {
        int intentos = 3;
        final String USR_VALIDO = "patmic";
        final String PWD_VALIDO = "123";

        CMD.println("=== 🛡️ EXOTROOPER SECURITY SYSTEM 🛡️ ===");

        while (intentos > 0) {
            String usuario = CMDInput.getCaracteres("Usuario: ");
            String clave = CMDInput.getCaracteres("Clave:   ");

            if (usuario.equals(USR_VALIDO) && clave.equals(PWD_VALIDO)) {
                return true;
            } else {
                intentos--;
                CMD.printlnError("⛔ Credenciales incorrectas. Intentos restantes: " + intentos);
            }
        }
        return false;
    }
}