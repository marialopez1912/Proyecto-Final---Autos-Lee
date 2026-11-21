package mx.desarrollo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Embeddable
public class AutoEquipamientoId implements java.io.Serializable {
    private static final long serialVersionUID = -1L;
    @Size(max = 1000)
    @NotNull
    @Column(name = "Equipamiento", nullable = false, length = 1000)
    private java.lang.String equipamiento;

    @NotNull
    @Column(name = "Auto_Id_Auto_Sistema", nullable = false)
    private java.lang.Integer autoIdAutoSistema;

    public java.lang.String getEquipamiento() {
        return equipamiento;
    }

    public void setEquipamiento(java.lang.String equipamiento) {
        this.equipamiento = equipamiento;
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
        AutoEquipamientoId entity = (AutoEquipamientoId) o;
        return java.util.Objects.equals(this.equipamiento, entity.equipamiento) &&
                java.util.Objects.equals(this.autoIdAutoSistema, entity.autoIdAutoSistema);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(equipamiento, autoIdAutoSistema);
    }
}