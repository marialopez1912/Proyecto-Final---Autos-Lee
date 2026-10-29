package mx.desarrollo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AutoId implements Serializable {
    @Serial
    private static final long serialVersionUID = 9036396734052601129L;
    @NotNull
    @Column(name = "Id_Auto_Sistema", nullable = false)
    private Integer idAutoSistema;

    @NotNull
    @Column(name = "Administrador_Id_Administrador", nullable = false)
    private Integer administradorIdAdministrador;

    public Integer getIdAutoSistema() {
        return idAutoSistema;
    }

    public void setIdAutoSistema(Integer idAutoSistema) {
        this.idAutoSistema = idAutoSistema;
    }

    public Integer getAdministradorIdAdministrador() {
        return administradorIdAdministrador;
    }

    public void setAdministradorIdAdministrador(Integer administradorIdAdministrador) {
        this.administradorIdAdministrador = administradorIdAdministrador;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AutoId entity = (AutoId) o;
        return Objects.equals(this.idAutoSistema, entity.idAutoSistema) &&
                Objects.equals(this.administradorIdAdministrador, entity.administradorIdAdministrador);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAutoSistema, administradorIdAdministrador);
    }
}