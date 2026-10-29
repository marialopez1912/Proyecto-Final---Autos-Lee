package mx.desarrollo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class DefectoId implements Serializable {
    @Serial
    private static final long serialVersionUID = -5433057653977169183L;
    @NotNull
    @Column(name = "Id_Defecto", nullable = false)
    private Integer idDefecto;

    @NotNull
    @Column(name = "Auto_Id_Auto_Sistema", nullable = false)
    private Integer autoIdAutoSistema;

    @NotNull
    @Column(name = "Auto_Administrador_Id_Administrador", nullable = false)
    private Integer autoAdministradorIdAdministrador;

    public Integer getIdDefecto() {
        return idDefecto;
    }

    public void setIdDefecto(Integer idDefecto) {
        this.idDefecto = idDefecto;
    }

    public Integer getAutoIdAutoSistema() {
        return autoIdAutoSistema;
    }

    public void setAutoIdAutoSistema(Integer autoIdAutoSistema) {
        this.autoIdAutoSistema = autoIdAutoSistema;
    }

    public Integer getAutoAdministradorIdAdministrador() {
        return autoAdministradorIdAdministrador;
    }

    public void setAutoAdministradorIdAdministrador(Integer autoAdministradorIdAdministrador) {
        this.autoAdministradorIdAdministrador = autoAdministradorIdAdministrador;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefectoId entity = (DefectoId) o;
        return Objects.equals(this.idDefecto, entity.idDefecto) &&
                Objects.equals(this.autoIdAutoSistema, entity.autoIdAutoSistema) &&
                Objects.equals(this.autoAdministradorIdAdministrador, entity.autoAdministradorIdAdministrador);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDefecto, autoIdAutoSistema, autoAdministradorIdAdministrador);
    }
}