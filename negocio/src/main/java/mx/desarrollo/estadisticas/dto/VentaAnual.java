package mx.desarrollo.estadisticas.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class VentaAnual implements Serializable {
    private final int anio;
    private final long cantidad;
    private final BigDecimal total;

    public VentaAnual(int anio, long cantidad, BigDecimal total) {
        this.anio = anio; this.cantidad = cantidad; this.total = total;
    }
    public int getAnio() { return anio; }
    public long getCantidad() { return cantidad; }
    public BigDecimal getTotal() { return total; }
}