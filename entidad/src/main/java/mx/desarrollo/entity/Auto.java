package mx.desarrollo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

@Entity
@Table(name = "auto", schema = "autos_lee")
public class Auto {
    @EmbeddedId
    private AutoId id;

    @MapsId("administradorIdAdministrador")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Administrador_Id_Administrador", nullable = false)
    private Administrador administradorIdAdministrador;

    @Size(max = 60)
    @NotNull
    @Column(name = "Marca", nullable = false, length = 60)
    private String marca;

    @Size(max = 60)
    @NotNull
    @Column(name = "Modelo", nullable = false, length = 60)
    private String modelo;

    @Size(max = 60)
    @NotNull
    @Column(name = "Version", nullable = false, length = 60)
    private String version;

    @NotNull
    @Column(name = "Anio", nullable = false)
    private Integer anio;

    @Size(max = 17)
    @NotNull
    @Column(name = "VIN", nullable = false, length = 17)
    private String vin;

    @Size(max = 45)
    @NotNull
    @Column(name = "Placa", nullable = false, length = 45)
    private String placa;

    @Size(max = 200)
    @NotNull
    @Column(name = "Carroceria", nullable = false, length = 200)
    private String carroceria;

    @Size(max = 200)
    @NotNull
    @Column(name = "Tipo_Motor", nullable = false, length = 200)
    private String tipoMotor;

    @NotNull
    @Column(name = "Cilindros", nullable = false)
    private Integer cilindros;

    @Size(max = 45)
    @NotNull
    @Column(name = "Potencia_Maxima", nullable = false, length = 45)
    private String potenciaMaxima;

    @Size(max = 200)
    @NotNull
    @Column(name = "Transmision", nullable = false, length = 200)
    private String transmision;

    @Size(max = 200)
    @NotNull
    @Column(name = "Frenos", nullable = false, length = 200)
    private String frenos;

    @Size(max = 200)
    @NotNull
    @Column(name = "Suspension", nullable = false, length = 200)
    private String suspension;

    @NotNull
    @Column(name = "Precio_Compra", nullable = false, precision = 10, scale = 2)
    private BigDecimal precioCompra;

    @NotNull
    @Column(name = "Porcentaje_Ganancia", nullable = false, precision = 5, scale = 2)
    private BigDecimal porcentajeGanancia;

    @NotNull
    @Column(name = "Precio_Venta", nullable = false, precision = 10, scale = 2)
    private BigDecimal precioVenta;

    @Size(max = 60)
    @NotNull
    @Column(name = "Tipo_Combustible", nullable = false, length = 60)
    private String tipoCombustible;

    public AutoId getId() {
        return id;
    }

    public void setId(AutoId id) {
        this.id = id;
    }

    public Administrador getAdministradorIdAdministrador() {
        return administradorIdAdministrador;
    }

    public void setAdministradorIdAdministrador(Administrador administradorIdAdministrador) {
        this.administradorIdAdministrador = administradorIdAdministrador;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCarroceria() {
        return carroceria;
    }

    public void setCarroceria(String carroceria) {
        this.carroceria = carroceria;
    }

    public String getTipoMotor() {
        return tipoMotor;
    }

    public void setTipoMotor(String tipoMotor) {
        this.tipoMotor = tipoMotor;
    }

    public Integer getCilindros() {
        return cilindros;
    }

    public void setCilindros(Integer cilindros) {
        this.cilindros = cilindros;
    }

    public String getPotenciaMaxima() {
        return potenciaMaxima;
    }

    public void setPotenciaMaxima(String potenciaMaxima) {
        this.potenciaMaxima = potenciaMaxima;
    }

    public String getTransmision() {
        return transmision;
    }

    public void setTransmision(String transmision) {
        this.transmision = transmision;
    }

    public String getFrenos() {
        return frenos;
    }

    public void setFrenos(String frenos) {
        this.frenos = frenos;
    }

    public String getSuspension() {
        return suspension;
    }

    public void setSuspension(String suspension) {
        this.suspension = suspension;
    }

    public BigDecimal getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(BigDecimal precioCompra) {
        this.precioCompra = precioCompra;
    }

    public BigDecimal getPorcentajeGanancia() {
        return porcentajeGanancia;
    }

    public void setPorcentajeGanancia(BigDecimal porcentajeGanancia) {
        this.porcentajeGanancia = porcentajeGanancia;
    }

    public BigDecimal getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(BigDecimal precioVenta) {
        this.precioVenta = precioVenta;
    }

    public String getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

}