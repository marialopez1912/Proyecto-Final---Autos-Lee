package mx.desarrollo.estadisticas.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class VentaReporte implements Serializable {
    private String vehiculo;
    private String fecha;
    private BigDecimal importe;

    public VentaReporte(String vehiculo, String fecha, BigDecimal importe) {
        this.vehiculo = vehiculo;
        this.fecha = fecha;
        this.importe = importe;
    }
    public String getVehiculo() { return vehiculo; }
    public String getFecha() { return fecha; }
    public BigDecimal getImporte() { return importe; }
}