package PjDataAcces.PjDAOs;

import PjDataAcces.Helpers.DataHelperSQLiteDAO;
import PjDataAcces.PjDTOs.PjIExobotDTO;
import PjInfraestructure.AppException;

public class PjIExoBotDAO extends DataHelperSQLiteDAO<PjIExobotDTO> {
    public PjIExoBotDAO() throws AppException {
        super(PjIExobotDTO.class, "PjIExoBot", "PjIdIExoBot");
    }
}
