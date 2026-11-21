package mx.desarrollo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "cita")
public class Cita {
    @EmbeddedId
    private CitaId id;

    @MapsId("usuarioIdUsuario")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Usuario_Id_Usuario", nullable = false)
    private Usuario usuarioIdUsuario;

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
    private java.time.LocalDate fecha;

    @NotNull
    @Column(name = "Hora", nullable = false)
    private java.time.LocalTime hora;

    public CitaId getId() {
        return id;
    }

    public void setId(CitaId id) {
        this.id = id;
    }

    public Usuario getUsuarioIdUsuario() {
        return usuarioIdUsuario;
    }

    public void setUsuarioIdUsuario(Usuario usuarioIdUsuario) {
        this.usuarioIdUsuario = usuarioIdUsuario;
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

    public java.time.LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(java.time.LocalDate fecha) {
        this.fecha = fecha;
    }

    public java.time.LocalTime getHora() {
        return hora;
    }

    public void setHora(java.time.LocalTime hora) {
        this.hora = hora;
    }

}