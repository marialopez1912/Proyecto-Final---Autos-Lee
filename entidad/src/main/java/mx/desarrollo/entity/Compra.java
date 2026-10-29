package mx.desarrollo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "compra", schema = "autos_lee")
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

    @NotNull
    @Column(name = "Fecha", nullable = false)
    private LocalDate fecha;

    @NotNull
    @Column(name = "Precio_Final", nullable = false, precision = 10, scale = 2)
    private BigDecimal precioFinal;

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

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(BigDecimal precioFinal) {
        this.precioFinal = precioFinal;
    }

}