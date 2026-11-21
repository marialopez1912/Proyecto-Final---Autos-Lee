package mx.desarrollo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;

@Embeddable
public class CompraId implements java.io.Serializable {
    private static final long serialVersionUID = -1L;
    @NotNull
    @Column(name = "Id_Compra", nullable = false)
    private java.lang.Integer idCompra;

    @NotNull
    @Column(name = "Auto_Id_Auto_Sistema", nullable = false)
    private java.lang.Integer autoIdAutoSistema;

    @NotNull
    @Column(name = "Auto_Administrador_Id_Administrador", nullable = false)
    private java.lang.Integer autoAdministradorIdAdministrador;

    @NotNull
    @Column(name = "Usuario_Id_Usuario", nullable = false)
    private java.lang.Integer usuarioIdUsuario;

    public java.lang.Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(java.lang.Integer idCompra) {
        this.idCompra = idCompra;
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

    public java.lang.Integer getUsuarioIdUsuario() {
        return usuarioIdUsuario;
    }

    public void setUsuarioIdUsuario(java.lang.Integer usuarioIdUsuario) {
        this.usuarioIdUsuario = usuarioIdUsuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompraId entity = (CompraId) o;
        return java.util.Objects.equals(this.idCompra, entity.idCompra) &&
                java.util.Objects.equals(this.autoIdAutoSistema, entity.autoIdAutoSistema) &&
                java.util.Objects.equals(this.autoAdministradorIdAdministrador, entity.autoAdministradorIdAdministrador) &&
                java.util.Objects.equals(this.usuarioIdUsuario, entity.usuarioIdUsuario);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(idCompra, autoIdAutoSistema, autoAdministradorIdAdministrador, usuarioIdUsuario);
    }
}