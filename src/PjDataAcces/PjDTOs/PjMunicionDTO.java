package PjDataAcces.PjDTOs;

public class PjMunicionDTO {

    private Integer PjIdMunicion;
    private Integer PjIdTipoMunicion;
    private String PjNombre;
    private String Estado;
    private String FechaCreacion;
    private String FechaModifica;

    public PjMunicionDTO() {
    }

    public PjMunicionDTO(Integer pjIdTipoMunicion, String pjNombre) {
        PjIdMunicion = 0;
        PjIdTipoMunicion = pjIdTipoMunicion;
        PjNombre = pjNombre;
    }

    public PjMunicionDTO(Integer pjIdMunicion, Integer pjIdTipoMunicion, String pjNombre, String estado,
            String fechaCreacion, String fechaModifica) {
        PjIdMunicion = pjIdMunicion;
        PjIdTipoMunicion = pjIdTipoMunicion;
        PjNombre = pjNombre;
        Estado = estado;
        FechaCreacion = fechaCreacion;
        FechaModifica = fechaModifica;
    }

    public Integer getPjIdMunicion() {
        return PjIdMunicion;
    }

    public void setPjIdMunicion(Integer pjIdMunicion) {
        PjIdMunicion = pjIdMunicion;
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
                + "\n PjIdMunicion   : " + getPjIdMunicion()
                + "\n PjIdTipoMunicion: " + getPjIdTipoMunicion()
                + "\n PjNombre: " + getPjNombre()
                + "\n Estado        : " + getEstado()
                + "\n FechaCreacion : " + getFechaCreacion()
                + "\n FechaModifica : " + getFechaModifica()
                + "\n --------------------------- ";
    }
}
