package PjDataAcces.PjDAOs;

import PjDataAcces.Helpers.DataHelperSQLiteDAO;
import PjDataAcces.PjDTOs.PjTipoExobotDTO;
import PjInfraestructure.AppException;

public class PjTipoExoBotDAO extends DataHelperSQLiteDAO<PjTipoExobotDTO> {
    public PjTipoExoBotDAO() throws AppException {
        super(PjTipoExobotDTO.class, "PjTipoExoBot", "PjIdTipoExoBot");
    }
}
