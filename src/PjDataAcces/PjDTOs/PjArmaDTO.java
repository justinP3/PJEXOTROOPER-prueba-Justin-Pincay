package PjDataAcces.PjDTOs;

public class PjArmaDTO {

    private Integer PjIdArma;
    private Integer PjIdTipoArma;
    private String PjNombre;
    private String Estado;
    private String FechaCreacion;
    private String FechaModifica;

    public PjArmaDTO() {
    }

    public PjArmaDTO(Integer pjIdTipoArma, String pjNombre) {
        PjIdArma = 0;
        PjIdTipoArma = pjIdTipoArma;
        PjNombre = pjNombre;
    }

    public PjArmaDTO(Integer pjIdArma, Integer pjIdTipoArma, String pjNombre, String estado, String fechaCreacion,
            String fechaModifica) {
        PjIdArma = pjIdArma;
        PjIdTipoArma = pjIdTipoArma;
        PjNombre = pjNombre;
        Estado = estado;
        FechaCreacion = fechaCreacion;
        FechaModifica = fechaModifica;
    }

    public Integer getPjIdArma() {
        return PjIdArma;
    }

    public void setPjIdArma(Integer pjIdArma) {
        PjIdArma = pjIdArma;
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
                + "\n PjIdArma   : " + getPjIdArma()
                + "\n PjIdTipoArma: " + getPjIdTipoArma()
                + "\n PjNombre: " + getPjNombre()
                + "\n Estado        : " + getEstado()
                + "\n FechaCreacion : " + getFechaCreacion()
                + "\n FechaModifica : " + getFechaModifica()
                + "\n --------------------------- ";
    }

}
