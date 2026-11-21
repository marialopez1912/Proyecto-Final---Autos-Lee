package mx.desarrollo.estadisticas.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class TotalCategoria implements Serializable {
    private String etiqueta;
    private BigDecimal total;

    public TotalCategoria(String etiqueta, BigDecimal total) {
        this.etiqueta = etiqueta;
        this.total = total;
    }
    public String getEtiqueta() { return etiqueta; }
    public BigDecimal getTotal() { return total; }
}