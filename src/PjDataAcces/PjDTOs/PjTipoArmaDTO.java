package PjDataAcces.PjDTOs;

public class PjTipoArmaDTO {

    private Integer PjIdTipoArma;
    private String PjNombre;
    private String Estado;
    private String FechaCreacion;
    private String FechaModifica;

    public PjTipoArmaDTO() {
    }

    public PjTipoArmaDTO(String pjNombre) {
        PjIdTipoArma = 0;
        PjNombre = pjNombre;
    }

    public PjTipoArmaDTO(Integer pjIdTipoArma, String pjNombre, String estado, String fechaCreacion,
            String fechaModifica) {
        PjIdTipoArma = pjIdTipoArma;
        PjNombre = pjNombre;
        Estado = estado;
        FechaCreacion = fechaCreacion;
        FechaModifica = fechaModifica;
    }

    public Integer getPjIdTipoArma() {
        return PjIdTipoArma;
    }

    public void setPjIdTipoArma(Integer pjIdTipoArma) {
        PjIdTipoArma = pjIdTipoArma;
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
                + "\n PjIdTipoArma: " + getPjIdTipoArma()
                + "\n PjNombre     : " + getPjNombre()
                + "\n Estado        : " + getEstado()
                + "\n FechaCreacion : " + getFechaCreacion()
                + "\n FechaModifica : " + getFechaModifica()
                + "\n --------------------------- ";
    }

}
