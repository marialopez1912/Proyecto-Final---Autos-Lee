package mx.desarrollo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CompraId implements Serializable {
    @Serial
    private static final long serialVersionUID = 8750437680254667766L;
    @NotNull
    @Column(name = "Id_Compra", nullable = false)
    private Integer idCompra;

    @NotNull
    @Column(name = "Auto_Id_Auto_Sistema", nullable = false)
    private Integer autoIdAutoSistema;

    @NotNull
    @Column(name = "Auto_Administrador_Id_Administrador", nullable = false)
    private Integer autoAdministradorIdAdministrador;

    @NotNull
    @Column(name = "Usuario_Id_Usuario", nullable = false)
    private Integer usuarioIdUsuario;

    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
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

    public Integer getUsuarioIdUsuario() {
        return usuarioIdUsuario;
    }

    public void setUsuarioIdUsuario(Integer usuarioIdUsuario) {
        this.usuarioIdUsuario = usuarioIdUsuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompraId entity = (CompraId) o;
        return Objects.equals(this.idCompra, entity.idCompra) &&
                Objects.equals(this.autoIdAutoSistema, entity.autoIdAutoSistema) &&
                Objects.equals(this.autoAdministradorIdAdministrador, entity.autoAdministradorIdAdministrador) &&
                Objects.equals(this.usuarioIdUsuario, entity.usuarioIdUsuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCompra, autoIdAutoSistema, autoAdministradorIdAdministrador, usuarioIdUsuario);
    }
}