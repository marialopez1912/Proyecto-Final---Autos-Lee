package mx.desarrollo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CitaId implements Serializable {
    @Serial
    private static final long serialVersionUID = 4009292946921923247L;
    @NotNull
    @Column(name = "Id_Cita", nullable = false)
    private Integer idCita;

    @NotNull
    @Column(name = "Usuario_Id_Usuario", nullable = false)
    private Integer usuarioIdUsuario;

    @NotNull
    @Column(name = "Auto_Id_Auto_Sistema", nullable = false)
    private Integer autoIdAutoSistema;

    @NotNull
    @Column(name = "Auto_Administrador_Id_Administrador", nullable = false)
    private Integer autoAdministradorIdAdministrador;

    @NotNull
    @Column(name = "Administrador_Id_Administrador", nullable = false)
    private Integer administradorIdAdministrador;

    public Integer getIdCita() {
        return idCita;
    }

    public void setIdCita(Integer idCita) {
        this.idCita = idCita;
    }

    public Integer getUsuarioIdUsuario() {
        return usuarioIdUsuario;
    }

    public void setUsuarioIdUsuario(Integer usuarioIdUsuario) {
        this.usuarioIdUsuario = usuarioIdUsuario;
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
        CitaId entity = (CitaId) o;
        return Objects.equals(this.idCita, entity.idCita) &&
                Objects.equals(this.usuarioIdUsuario, entity.usuarioIdUsuario) &&
                Objects.equals(this.autoIdAutoSistema, entity.autoIdAutoSistema) &&
                Objects.equals(this.autoAdministradorIdAdministrador, entity.autoAdministradorIdAdministrador) &&
                Objects.equals(this.administradorIdAdministrador, entity.administradorIdAdministrador);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCita, usuarioIdUsuario, autoIdAutoSistema, autoAdministradorIdAdministrador, administradorIdAdministrador);
    }
}