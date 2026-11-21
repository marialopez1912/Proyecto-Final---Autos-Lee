package mx.desarrollo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;

@Embeddable
public class CitaId implements java.io.Serializable {
    private static final long serialVersionUID = -1L;
    @NotNull
    @Column(name = "Id_Cita", nullable = false)
    private java.lang.Integer idCita;

    @NotNull
    @Column(name = "Usuario_Id_Usuario", nullable = false)
    private java.lang.Integer usuarioIdUsuario;

    @NotNull
    @Column(name = "Auto_Id_Auto_Sistema", nullable = false)
    private java.lang.Integer autoIdAutoSistema;

    @NotNull
    @Column(name = "Auto_Administrador_Id_Administrador", nullable = false)
    private java.lang.Integer autoAdministradorIdAdministrador;

    @NotNull
    @Column(name = "Administrador_Id_Administrador", nullable = false)
    private java.lang.Integer administradorIdAdministrador;

    public java.lang.Integer getIdCita() {
        return idCita;
    }

    public void setIdCita(java.lang.Integer idCita) {
        this.idCita = idCita;
    }

    public java.lang.Integer getUsuarioIdUsuario() {
        return usuarioIdUsuario;
    }

    public void setUsuarioIdUsuario(java.lang.Integer usuarioIdUsuario) {
        this.usuarioIdUsuario = usuarioIdUsuario;
    }

    public java.lang.Integer getAutoIdAutoSistema() {
        return autoIdAutoSistema;
    }

    public void setAutoIdAutoSistema(java.lang.Integer autoIdAutoSistema) {
        this.autoIdAutoSistema = autoIdAutoSistema;
    }

    public java.lang.Integer getAutoAdministradorIdAdministrador() {
        return autoAdministradorIdAdministrador;
    }

    public void setAutoAdministradorIdAdministrador(java.lang.Integer autoAdministradorIdAdministrador) {
        this.autoAdministradorIdAdministrador = autoAdministradorIdAdministrador;
    }

    public java.lang.Integer getAdministradorIdAdministrador() {
        return administradorIdAdministrador;
    }

    public void setAdministradorIdAdministrador(java.lang.Integer administradorIdAdministrador) {
        this.administradorIdAdministrador = administradorIdAdministrador;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CitaId entity = (CitaId) o;
        return java.util.Objects.equals(this.idCita, entity.idCita) &&
                java.util.Objects.equals(this.usuarioIdUsuario, entity.usuarioIdUsuario) &&
                java.util.Objects.equals(this.autoIdAutoSistema, entity.autoIdAutoSistema) &&
                java.util.Objects.equals(this.autoAdministradorIdAdministrador, entity.autoAdministradorIdAdministrador) &&
                java.util.Objects.equals(this.administradorIdAdministrador, entity.administradorIdAdministrador);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(idCita, usuarioIdUsuario, autoIdAutoSistema, autoAdministradorIdAdministrador, administradorIdAdministrador);
    }
}