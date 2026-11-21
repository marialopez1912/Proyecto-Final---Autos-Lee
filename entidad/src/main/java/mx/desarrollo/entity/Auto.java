package mx.desarrollo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "auto")
public class Auto {
    @EmbeddedId
    private AutoId id;


    @Size(max = 60)
    @NotNull
    @Column(name = "Marca", nullable = false, length = 60)
    private java.lang.String marca;

    @Size(max = 60)
    @NotNull
    @Column(name = "Modelo", nullable = false, length = 60)
    private java.lang.String modelo;

    @Size(max = 60)
    @NotNull
    @Column(name = "Version", nullable = false, length = 60)
    private java.lang.String version;

    @NotNull
    @Column(name = "Anio", nullable = false)
    private java.lang.Integer anio;

    @Size(max = 17)
    @NotNull
    @Column(name = "VIN", nullable = false, length = 17)
    private java.lang.String vin;

    @Size(max = 45)
    @NotNull
    @Column(name = "Placa", nullable = false, length = 45)
    private java.lang.String placa;

    @Size(max = 200)
    @NotNull
    @Column(name = "Carroceria", nullable = false, length = 200)
    private java.lang.String carroceria;

    @Size(max = 200)
    @NotNull
    @Column(name = "Tipo_Motor", nullable = false, length = 200)
    private java.lang.String tipoMotor;

    @NotNull
    @Column(name = "Cilindros", nullable = false)
    private java.lang.Integer cilindros;

    @Size(max = 45)
    @NotNull
    @Column(name = "Potencia_Maxima", nullable = false, length = 45)
    private java.lang.String potenciaMaxima;

    @Size(max = 200)
    @NotNull
    @Column(name = "Transmision", nullable = false, length = 200)
    private java.lang.String transmision;

    @Size(max = 200)
    @NotNull
    @Column(name = "Frenos", nullable = false, length = 200)
    private java.lang.String frenos;

    @Size(max = 200)
    @NotNull
    @Column(name = "Suspension", nullable = false, length = 200)
    private java.lang.String suspension;

    @NotNull
    @Column(name = "Precio_Compra", nullable = false, precision = 10, scale = 2)
    private java.math.BigDecimal precioCompra;

    @NotNull
    @Column(name = "Porcentaje_Ganancia", nullable = false, precision = 5, scale = 2)
    private java.math.BigDecimal porcentajeGanancia;

    @NotNull
    @Column(name = "Precio_Venta", nullable = false, precision = 10, scale = 2)
    private java.math.BigDecimal precioVenta;

    @Size(max = 60)
    @NotNull
    @Column(name = "Tipo_Combustible", nullable = false, length = 60)
    private java.lang.String tipoCombustible;

    @Column(name = "Id_Auto_Sistema", insertable = false, updatable = false)
    private java.lang.Integer idAutoSistema;

    public java.lang.Integer getIdAutoSistema() {
        return idAutoSistema;
    }

    @NotNull
    @ColumnDefault("1")
    @Column(name = "Disponible", nullable = false)
    private java.lang.Boolean disponible = true;

    public AutoId getId() {
        return id;
    }

    public void setId(AutoId id) {
        this.id = id;
    }

    public java.lang.String getMarca() {
        return marca;
    }

    public void setMarca(java.lang.String marca) {
        this.marca = marca;
    }

    public java.lang.String getModelo() {
        return modelo;
    }

    public void setModelo(java.lang.String modelo) {
        this.modelo = modelo;
    }

    public java.lang.String getVersion() {
        return version;
    }

    public void setVersion(java.lang.String version) {
        this.version = version;
    }

    public java.lang.Integer getAnio() {
        return anio;
    }

    public void setAnio(java.lang.Integer anio) {
        this.anio = anio;
    }

    public java.lang.String getVin() {
        return vin;
    }

    public void setVin(java.lang.String vin) {
        this.vin = vin;
    }

    public java.lang.String getPlaca() {
        return placa;
    }

    public void setPlaca(java.lang.String placa) {
        this.placa = placa;
    }

    public java.lang.String getCarroceria() {
        return carroceria;
    }

    public void setCarroceria(java.lang.String carroceria) {
        this.carroceria = carroceria;
    }

    public java.lang.String getTipoMotor() {
        return tipoMotor;
    }

    public void setTipoMotor(java.lang.String tipoMotor) {
        this.tipoMotor = tipoMotor;
    }

    public java.lang.Integer getCilindros() {
        return cilindros;
    }

    public void setCilindros(java.lang.Integer cilindros) {
        this.cilindros = cilindros;
    }

    public java.lang.String getPotenciaMaxima() {
        return potenciaMaxima;
    }

    public void setPotenciaMaxima(java.lang.String potenciaMaxima) {
        this.potenciaMaxima = potenciaMaxima;
    }

    public java.lang.String getTransmision() {
        return transmision;
    }

    public void setTransmision(java.lang.String transmision) {
        this.transmision = transmision;
    }

    public java.lang.String getFrenos() {
        return frenos;
    }

    public void setFrenos(java.lang.String frenos) {
        this.frenos = frenos;
    }

    public java.lang.String getSuspension() {
        return suspension;
    }

    public void setSuspension(java.lang.String suspension) {
        this.suspension = suspension;
    }

    public java.math.BigDecimal getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(java.math.BigDecimal precioCompra) {
        this.precioCompra = precioCompra;
    }

    public java.math.BigDecimal getPorcentajeGanancia() {
        return porcentajeGanancia;
    }

    public void setPorcentajeGanancia(java.math.BigDecimal porcentajeGanancia) {
        this.porcentajeGanancia = porcentajeGanancia;
    }

    public java.math.BigDecimal getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(java.math.BigDecimal precioVenta) {
        this.precioVenta = precioVenta;
    }

    public java.lang.String getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(java.lang.String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    public java.lang.Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(java.lang.Boolean disponible) {
        this.disponible = disponible;
    }

}