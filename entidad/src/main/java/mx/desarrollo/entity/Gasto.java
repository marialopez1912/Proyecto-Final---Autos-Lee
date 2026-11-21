package mx.desarrollo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "gasto")
public class Gasto {
    @EmbeddedId
    private GastoId id;

    @MapsId("id")
    @JoinColumns({
            @JoinColumn(name = "Auto_Id_Auto_Sistema",
                    referencedColumnName = "Id_Auto_Sistema",
                    nullable = false),
            @JoinColumn(name = "Auto_Administrador_Id_Administrador",
                    referencedColumnName = "Administrador_Id_Administrador",
                    nullable = false)})
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Auto auto;

    @Size(max = 1000)
    @NotNull
    @Column(name = "Descripcion", nullable = false, length = 1000)
    private java.lang.String descripcion;

    @NotNull
    @Lob
    @Column(name = "Tipo", nullable = false)
    private java.lang.String tipo;

    @NotNull
    @Column(name = "Monto", nullable = false, precision = 10, scale = 2)
    private java.math.BigDecimal monto;

    public GastoId getId() {
        return id;
    }

    public void setId(GastoId id) {
        this.id = id;
    }

    public Auto getAuto() {
        return auto;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }

    public java.lang.String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(java.lang.String descripcion) {
        this.descripcion = descripcion;
    }

    public java.lang.String getTipo() {
        return tipo;
    }

    public void setTipo(java.lang.String tipo) {
        this.tipo = tipo;
    }

    public java.math.BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(java.math.BigDecimal monto) {
        this.monto = monto;
    }

}