package mx.desarrollo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;

@Embeddable
public class AutoId implements java.io.Serializable {
    private static final long serialVersionUID = -1L;
    @NotNull
    @Column(name = "Id_Auto_Sistema", nullable = false)
    private java.lang.Integer idAutoSistema;

    @NotNull
    @Column(name = "Administrador_Id_Administrador", nullable = false)
    private java.lang.Integer administradorIdAdministrador;

    public java.lang.Integer getIdAutoSistema() {
        return idAutoSistema;
    }

    public void setIdAutoSistema(java.lang.Integer idAutoSistema) {
        this.idAutoSistema = idAutoSistema;
    }

    public java.lang.Integer getAdministradorIdAdministrador() {
        return administradorIdAdministrador;
    }

    public void setAdministradorIdAdministrador(java.lang.Integer administradorIdAdministrador) {
        this.administradorIdAdministrador = administradorIdAdministrador;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AutoId entity = (AutoId) o;
        return java.util.Objects.equals(this.idAutoSistema, entity.idAutoSistema) &&
                java.util.Objects.equals(this.administradorIdAdministrador, entity.administradorIdAdministrador);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(idAutoSistema, administradorIdAdministrador);
    }
}