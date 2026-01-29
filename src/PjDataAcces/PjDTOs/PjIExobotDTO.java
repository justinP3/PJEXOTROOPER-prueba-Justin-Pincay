package PjDataAcces.PjDTOs;

public class PjIExobotDTO {

    private Integer PjIdIExoBot;
    private Integer PjIdTipoExoBot;
    private String PjEntrenamiento;
    private Integer PjNAccion;
    private String Estado;
    private String FechaCreacion;
    private String FechaModifica;

    public PjIExobotDTO() {
    }

    public PjIExobotDTO(Integer pjIdTipoExoBot, String pjEntrenamiento,
            Integer pjNAccion) {
        PjIdIExoBot = 0;
        PjIdTipoExoBot = pjIdTipoExoBot;
        PjEntrenamiento = pjEntrenamiento;
        PjNAccion = pjNAccion;
    }

    public PjIExobotDTO(Integer pjIdIExoBot, Integer pjIdTipoExoBot, String pjEntrenamiento,
            Integer pjNAccion, String estado, String fechaCreacion, String fechaModifica) {
        PjIdIExoBot = pjIdIExoBot;
        PjIdTipoExoBot = pjIdTipoExoBot;
        PjEntrenamiento = pjEntrenamiento;
        PjNAccion = pjNAccion;
        Estado = estado;
        FechaCreacion = fechaCreacion;
        FechaModifica = fechaModifica;
    }

    public Integer getPjIdIExoBot() {
        return PjIdIExoBot;
    }

    public void setPjIdIExoBot(Integer pjIdIExoBot) {
        PjIdIExoBot = pjIdIExoBot;
    }

    public Integer getPjIdTipoExoBot() {
        return PjIdTipoExoBot;
    }

    public void setPjIdTipoExoBot(Integer pjIdTipoExoBot) {
        PjIdTipoExoBot = pjIdTipoExoBot;
    }

    public String getPjEntrenamiento() {
        return PjEntrenamiento;
    }

    public void setPjEntrenamiento(String pjEntrenamiento) {
        PjEntrenamiento = pjEntrenamiento;
    }

    public Integer getPjNAccion() {
        return PjNAccion;
    }

    public void setPjNAccion(Integer pjNAccion) {
        PjNAccion = pjNAccion;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public String getFechaCreacion() {
        return FechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        FechaCreacion = fechaCreacion;
    }

    public String getFechaModifica() {
        return FechaModifica;
    }

    public void setFechaModifica(String fechaModifica) {
        FechaModifica = fechaModifica;
    }

    @Override
    public String toString() {
        return getClass().getName()
                + "\n PjIdIExoBot   : " + getPjIdIExoBot()
                + "\n PjIdTipoExoBot: " + getPjIdTipoExoBot()
                + "\n PjEntrenamiento: " + getPjEntrenamiento()
                + "\n PjNAccion     : " + getPjNAccion()
                + "\n Estado        : " + getEstado()
                + "\n FechaCreacion : " + getFechaCreacion()
                + "\n FechaModifica : " + getFechaModifica()
                + "\n --------------------------- ";
    }

}
