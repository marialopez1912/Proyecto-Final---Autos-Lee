package mx.desarrollo.estadisticas.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class MargenAuto implements Serializable {
    private final String vin;
    private final String vehiculo;
    private final BigDecimal precioVenta;
    private final BigDecimal precioCompra;
    private final BigDecimal gastos;
    private final BigDecimal costoTotal;
    private final BigDecimal margen;

    public MargenAuto(String vin, String vehiculo, BigDecimal precioVenta, BigDecimal precioCompra, BigDecimal gastos) {
        this.vin = vin;
        this.vehiculo = vehiculo;
        this.precioVenta = precioVenta == null ? BigDecimal.ZERO : precioVenta;
        this.precioCompra = precioCompra == null ? BigDecimal.ZERO : precioCompra;
        this.gastos = gastos == null ? BigDecimal.ZERO : gastos;
        this.costoTotal = this.precioCompra.add(this.gastos);
        this.margen = this.precioVenta.subtract(this.costoTotal);
    }

    public String getVin() { return vin; }
    public String getVehiculo() { return vehiculo; }
    public BigDecimal getPrecioVenta() { return precioVenta; }
    public BigDecimal getPrecioCompra() { return precioCompra; }
    public BigDecimal getGastos() { return gastos; }
    public BigDecimal getCostoTotal() { return costoTotal; }
    public BigDecimal getMargen() { return margen; }
    public boolean isNegativo() { return margen.signum() < 0; }
}