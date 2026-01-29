package PjDataAcces.PjDAOs;

import PjDataAcces.Helpers.DataHelperSQLiteDAO;
import PjDataAcces.PjDTOs.PjTipoArmaDTO;
import PjInfraestructure.AppException;

public class PjTipoArmaDAO extends DataHelperSQLiteDAO<PjTipoArmaDTO> {
    public PjTipoArmaDAO() throws AppException {
        super(PjTipoArmaDTO.class, "PjTipoArma", "PjIdTipoArma");
    }
}
