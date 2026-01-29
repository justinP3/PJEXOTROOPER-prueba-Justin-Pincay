package PjBL;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import PjInfraestructure.AppMSG;

public class PjBuscadorDeMunicion {

    public PjBuscadorDeMunicion() {
    }

    public String PjBuscarMunicion(String nombreArma) {
        String rutaArchivo = "src/PjStorage/PjFile/PjExoMunision.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.contains(nombreArma)) {
                    return linea.trim();
                }
            }
        } catch (IOException e) {
            AppMSG.showError("Error al leer archivo de munición: " + e.getMessage());
        }

        return "Munición no encontrada";
    }
}