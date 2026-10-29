package mx.desarrollo.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "auto_equipamiento", schema = "autos_lee")
public class AutoEquipamiento {
    @EmbeddedId
    private AutoEquipamientoId id;

    @MapsId("autoIdAutoSistema")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "Auto_Id_Auto_Sistema", nullable = false, referencedColumnName = "Id_Auto_Sistema")
    private Auto autoIdAutoSistema;

    public AutoEquipamientoId getId() {
        return id;
    }

    public void setId(AutoEquipamientoId id) {
        this.id = id;
    }

    public Auto getAutoIdAutoSistema() {
        return autoIdAutoSistema;
    }

    public void setAutoIdAutoSistema(Auto autoIdAutoSistema) {
        this.autoIdAutoSistema = autoIdAutoSistema;
    }

}