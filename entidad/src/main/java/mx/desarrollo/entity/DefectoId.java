package mx.desarrollo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;

@Embeddable
public class DefectoId implements java.io.Serializable {
    private static final long serialVersionUID = -1L;
    @NotNull
    @Column(name = "Id_Defecto", nullable = false)
    private java.lang.Integer idDefecto;

    @NotNull
    @Column(name = "Auto_Id_Auto_Sistema", nullable = false)
    private java.lang.Integer autoIdAutoSistema;

    @NotNull
    @Column(name = "Auto_Administrador_Id_Administrador", nullable = false)
    private java.lang.Integer autoAdministradorIdAdministrador;

    public java.lang.Integer getIdDefecto() {
        return idDefecto;
    }

    public void setIdDefecto(java.lang.Integer idDefecto) {
        this.idDefecto = idDefecto;
    }

    public java.lang.Integer getAutoIdAutoSistema() {
        return autoIdAutoSistema;
    }

    public void setAutoIdAutoSistema(java.lang.Integer autoIdAutoSistema) {
        this.autoIdAutoSistema = autoIdAutoSistema;
    }

    public java.lang.Integer getAutoAdministradorIdAdministrador() {
        return autoAdministradorIdAdministrador;
    }

    public void setAutoAdministradorIdAdministrador(java.lang.Integer autoAdministradorIdAdministrador) {
        this.autoAdministradorIdAdministrador = autoAdministradorIdAdministrador;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefectoId entity = (DefectoId) o;
        return java.util.Objects.equals(this.idDefecto, entity.idDefecto) &&
                java.util.Objects.equals(this.autoIdAutoSistema, entity.autoIdAutoSistema) &&
                java.util.Objects.equals(this.autoAdministradorIdAdministrador, entity.autoAdministradorIdAdministrador);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(idDefecto, autoIdAutoSistema, autoAdministradorIdAdministrador);
    }
}