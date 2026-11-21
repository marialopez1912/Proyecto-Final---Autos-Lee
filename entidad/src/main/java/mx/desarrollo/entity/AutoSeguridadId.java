package mx.desarrollo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Embeddable
public class AutoSeguridadId implements java.io.Serializable {
    private static final long serialVersionUID = -1L;
    @Size(max = 1000)
    @NotNull
    @Column(name = "Sistema_Seguridad", nullable = false, length = 1000)
    private java.lang.String sistemaSeguridad;

    @NotNull
    @Column(name = "Auto_Id_Auto_Sistema", nullable = false)
    private java.lang.Integer autoIdAutoSistema;

    public java.lang.String getSistemaSeguridad() {
        return sistemaSeguridad;
    }

    public void setSistemaSeguridad(java.lang.String sistemaSeguridad) {
        this.sistemaSeguridad = sistemaSeguridad;
    }

    public java.lang.Integer getAutoIdAutoSistema() {
        return autoIdAutoSistema;
    }

    public void setAutoIdAutoSistema(java.lang.Integer autoIdAutoSistema) {
        this.autoIdAutoSistema = autoIdAutoSistema;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AutoSeguridadId entity = (AutoSeguridadId) o;
        return java.util.Objects.equals(this.sistemaSeguridad, entity.sistemaSeguridad) &&
                java.util.Objects.equals(this.autoIdAutoSistema, entity.autoIdAutoSistema);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(sistemaSeguridad, autoIdAutoSistema);
    }
}