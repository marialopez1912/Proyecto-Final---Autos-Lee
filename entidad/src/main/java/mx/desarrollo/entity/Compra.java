package mx.desarrollo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "compra")
public class Compra {
    @EmbeddedId
    private CompraId id;

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

    @MapsId("usuarioIdUsuario")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Usuario_Id_Usuario", nullable = false)
    private Usuario usuarioIdUsuario;

    @NotNull
    @Column(name = "Fecha", nullable = false)
    private java.time.LocalDate fecha;

    @NotNull
    @Column(name = "Precio_Final", nullable = false, precision = 10, scale = 2)
    private java.math.BigDecimal precioFinal;

    public CompraId getId() {
        return id;
    }

    public void setId(CompraId id) {
        this.id = id;
    }

    public Auto getAuto() {
        return auto;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }

    public Usuario getUsuarioIdUsuario() {
        return usuarioIdUsuario;
    }

    public void setUsuarioIdUsuario(Usuario usuarioIdUsuario) {
        this.usuarioIdUsuario = usuarioIdUsuario;
    }

    public java.time.LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(java.time.LocalDate fecha) {
        this.fecha = fecha;
    }

    public java.math.BigDecimal getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(java.math.BigDecimal precioFinal) {
        this.precioFinal = precioFinal;
    }

}