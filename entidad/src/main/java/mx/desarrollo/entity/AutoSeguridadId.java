package mx.desarrollo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AutoSeguridadId implements Serializable {
    @Serial
    private static final long serialVersionUID = -133698412827595955L;
    @Size(max = 1000)
    @NotNull
    @Column(name = "Sistema_Seguridad", nullable = false, length = 1000)
    private String sistemaSeguridad;

    @NotNull
    @Column(name = "Auto_Id_Auto_Sistema", nullable = false)
    private Integer autoIdAutoSistema;

    public String getSistemaSeguridad() {
        return sistemaSeguridad;
    }

    public void setSistemaSeguridad(String sistemaSeguridad) {
        this.sistemaSeguridad = sistemaSeguridad;
    }

    public Integer getAutoIdAutoSistema() {
        return autoIdAutoSistema;
    }

    public void setAutoIdAutoSistema(Integer autoIdAutoSistema) {
        this.autoIdAutoSistema = autoIdAutoSistema;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AutoSeguridadId entity = (AutoSeguridadId) o;
        return Objects.equals(this.sistemaSeguridad, entity.sistemaSeguridad) &&
                Objects.equals(this.autoIdAutoSistema, entity.autoIdAutoSistema);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sistemaSeguridad, autoIdAutoSistema);
    }
}