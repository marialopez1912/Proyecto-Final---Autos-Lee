package mx.desarrollo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class GastoId implements Serializable {
    @Serial
    private static final long serialVersionUID = 5304078638588555619L;
    @NotNull
    @Column(name = "Id_Gasto", nullable = false)
    private Integer idGasto;

    @NotNull
    @Column(name = "Auto_Id_Auto_Sistema", nullable = false)
    private Integer autoIdAutoSistema;

    @NotNull
    @Column(name = "Auto_Administrador_Id_Administrador", nullable = false)
    private Integer autoAdministradorIdAdministrador;

    public Integer getIdGasto() {
        return idGasto;
    }

    public void setIdGasto(Integer idGasto) {
        this.idGasto = idGasto;
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
        GastoId entity = (GastoId) o;
        return Objects.equals(this.idGasto, entity.idGasto) &&
                Objects.equals(this.autoIdAutoSistema, entity.autoIdAutoSistema) &&
                Objects.equals(this.autoAdministradorIdAdministrador, entity.autoAdministradorIdAdministrador);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idGasto, autoIdAutoSistema, autoAdministradorIdAdministrador);
    }
}