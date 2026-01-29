package PjBL;

import java.util.List;
import java.util.ArrayList;
import PjDataAcces.PjDAOs.PjTipoExoBotDAO;
import PjDataAcces.PjDTOs.PjTipoExobotDTO;
import PjInfraestructure.AppMSG;

public class PjBuscadorExobot {

    public PjBuscadorExobot() {
    }

    public List<PjTipoExobotDTO> PjBuscarExobot() {
        try {
            PjTipoExoBotDAO dao = new PjTipoExoBotDAO();

            return dao.readAll();

        } catch (Exception e) {
            AppMSG.showError("Error al buscar en BD: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}