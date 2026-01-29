package PjDataAcces.PjDAOs;

import PjDataAcces.Helpers.DataHelperSQLiteDAO;
import PjDataAcces.PjDTOs.PjMunicionDTO;
import PjInfraestructure.AppException;

public class PjMunicionDAO extends DataHelperSQLiteDAO<PjMunicionDTO> {
    public PjMunicionDAO() throws AppException {
        super(PjMunicionDTO.class, "PjMunicion", "PjIdMunicion");
    }
}
