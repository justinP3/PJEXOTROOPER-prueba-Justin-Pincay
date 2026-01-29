package PjDataAcces.PjDAOs;

import PjDataAcces.Helpers.DataHelperSQLiteDAO;
import PjDataAcces.PjDTOs.PjTipoMunicionDTO;
import PjInfraestructure.AppException;

public class PjTipoMunicionDAO extends DataHelperSQLiteDAO<PjTipoMunicionDTO> {
    public PjTipoMunicionDAO() throws AppException {
        super(PjTipoMunicionDTO.class, "PjTipoMunicion", "PjIdTipoMunicion");
    }
}
