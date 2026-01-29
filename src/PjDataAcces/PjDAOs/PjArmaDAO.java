package PjDataAcces.PjDAOs;

import PjDataAcces.Helpers.DataHelperSQLiteDAO;
import PjDataAcces.PjDTOs.PjArmaDTO;
import PjInfraestructure.AppException;

public class PjArmaDAO extends DataHelperSQLiteDAO<PjArmaDTO> {
    public PjArmaDAO() throws AppException {
        super(PjArmaDTO.class, "PjArma", "PjIdArma");
    }
}
