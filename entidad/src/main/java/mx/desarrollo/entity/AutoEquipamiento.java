package mx.desarrollo.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "auto_equipamiento")
public class AutoEquipamiento {
    @EmbeddedId
    private AutoEquipamientoId id;


    public AutoEquipamientoId getId() {
        return id;
    }

    public void setId(AutoEquipamientoId id) {
        this.id = id;
    }


}