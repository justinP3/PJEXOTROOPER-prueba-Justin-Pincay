package PjDataAcces.PjDTOs;

public class PjTipoMunicionDTO {

    private Integer PjIdTipoMunicion;
    private String PjNombre;
    private String Estado;
    private String FechaCreacion;
    private String FechaModifica;

    public PjTipoMunicionDTO() {
    }

    public PjTipoMunicionDTO(String pjNombre) {
        PjIdTipoMunicion = 0;
        PjNombre = pjNombre;
    }

    public PjTipoMunicionDTO(Integer pjIdTipoMunicion, String pjNombre, String estado, String fechaCreacion,
            String fechaModifica) {
        PjIdTipoMunicion = pjIdTipoMunicion;
        PjNombre = pjNombre;
        Estado = estado;
        FechaCreacion = fechaCreacion;
        FechaModifica = fechaModifica;
    }

    public Integer getPjIdTipoMunicion() {
        return PjIdTipoMunicion;
    }

    public void setPjIdTipoMunicion(Integer pjIdTipoMunicion) {
        PjIdTipoMunicion = pjIdTipoMunicion;
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
                + "\n PjIdTipoMunicion: " + getPjIdTipoMunicion()
                + "\n PjNombre     : " + getPjNombre()
                + "\n Estado        : " + getEstado()
                + "\n FechaCreacion : " + getFechaCreacion()
                + "\n FechaModifica : " + getFechaModifica()
                + "\n --------------------------- ";
    }
}
