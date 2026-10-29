package mx.desarrollo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "cita", schema = "autos_lee")
public class Cita {
    @EmbeddedId
    private CitaId id;

    @MapsId("id")
    @JoinColumns({
            @JoinColumn(name = "Auto_Id_Auto_Sistema",
                    referencedColumnName = "Id_Auto_Sistema",
                    nullable = false),
            @JoinColumn(name = "Auto_Administrador_Id_Administrador",
                    referencedColumnName = "Administrador_Id_Administrador",
                    nullable = false)})
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Auto auto;

    @MapsId("administradorIdAdministrador")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Administrador_Id_Administrador", nullable = false)
    private Administrador administradorIdAdministrador;

    @NotNull
    @Column(name = "Fecha", nullable = false)
    private LocalDate fecha;

    @NotNull
    @Column(name = "Hora", nullable = false)
    private LocalTime hora;

    public CitaId getId() {
        return id;
    }

    public void setId(CitaId id) {
        this.id = id;
    }

    public Auto getAuto() {
        return auto;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }

    public Administrador getAdministradorIdAdministrador() {
        return administradorIdAdministrador;
    }

    public void setAdministradorIdAdministrador(Administrador administradorIdAdministrador) {
        this.administradorIdAdministrador = administradorIdAdministrador;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

}