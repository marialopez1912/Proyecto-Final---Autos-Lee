package mx.desarrollo.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "auto_seguridad")
public class AutoSeguridad {
    @EmbeddedId
    private AutoSeguridadId id;


    public AutoSeguridadId getId() {
        return id;
    }

    public void setId(AutoSeguridadId id) {
        this.id = id;
    }

}