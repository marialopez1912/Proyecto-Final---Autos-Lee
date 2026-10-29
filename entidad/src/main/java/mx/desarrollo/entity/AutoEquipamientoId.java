package mx.desarrollo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AutoEquipamientoId implements Serializable {
    @Serial
    private static final long serialVersionUID = -7084555712607334444L;
    @Size(max = 1000)
    @NotNull
    @Column(name = "Equipamiento", nullable = false, length = 1000)
    private String equipamiento;

    @NotNull
    @Column(name = "Auto_Id_Auto_Sistema", nullable = false)
    private Integer autoIdAutoSistema;

    public String getEquipamiento() {
        return equipamiento;
    }

    public void setEquipamiento(String equipamiento) {
        this.equipamiento = equipamiento;
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
        AutoEquipamientoId entity = (AutoEquipamientoId) o;
        return Objects.equals(this.equipamiento, entity.equipamiento) &&
                Objects.equals(this.autoIdAutoSistema, entity.autoIdAutoSistema);
    }

    @Override
    public int hashCode() {
        return Objects.hash(equipamiento, autoIdAutoSistema);
    }
}