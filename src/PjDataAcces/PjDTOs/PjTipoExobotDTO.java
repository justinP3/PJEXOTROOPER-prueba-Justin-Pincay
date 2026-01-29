package PjDataAcces.PjDTOs;

public class PjTipoExobotDTO {

    private Integer PjIdTipoExoBot;
    private String PjNombre;
    private String Estado;
    private String FechaCreacion;
    private String FechaModifica;

    public PjTipoExobotDTO() {
    }

    public PjTipoExobotDTO(String pjNombre) {
        PjIdTipoExoBot = 0;
        PjNombre = pjNombre;
    }

    public PjTipoExobotDTO(Integer pjIdTipoExoBot, String pjNombre, String estado, String fechaCreacion,
            String fechaModifica) {
        PjIdTipoExoBot = pjIdTipoExoBot;
        PjNombre = pjNombre;
        Estado = estado;
        FechaCreacion = fechaCreacion;
        FechaModifica = fechaModifica;
    }

    public Integer getPjIdTipoExoBot() {
        return PjIdTipoExoBot;
    }

    public void setPjIdTipoExoBot(Integer pjIdTipoExoBot) {
        PjIdTipoExoBot = pjIdTipoExoBot;
    }

    public String getPjNombre() {
        return PjNombre;
    }

    public void setPjNombre(String pjNombre) {
        PjNombre = pjNombre;
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
                + "\n PjIdTipoExoBot: " + getPjIdTipoExoBot()
                + "\n PjNombre     : " + getPjNombre()
                + "\n Estado        : " + getEstado()
                + "\n FechaCreacion : " + getFechaCreacion()
                + "\n FechaModifica : " + getFechaModifica()
                + "\n --------------------------- ";
    }

}
