package ui;

import helper.EstadisticasHelper;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import mx.desarrollo.estadisticas.dto.VentaAnual;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Named("estadisticasUI")
@SessionScoped
public class EstadisticasBeanUI implements Serializable {

    @Inject
    private LoginBeanUI loginUI;

    private final EstadisticasHelper helper = new EstadisticasHelper();
    private List<VentaAnual> anuales = new ArrayList<>();
    private BigDecimal maximo = BigDecimal.ZERO;
    private BigDecimal total = BigDecimal.ZERO;
    private long cantidad;

    public String iniciar() {
        String r = loginUI.validarAdmin();
        if (r != null) return r;
        anuales = helper.ventasAnuales();
        maximo = BigDecimal.ZERO; total = BigDecimal.ZERO; cantidad = 0;
        for (VentaAnual v : anuales) {
            total = total.add(v.getTotal());
            cantidad += v.getCantidad();
            if (v.getTotal().compareTo(maximo) > 0) maximo = v.getTotal();
        }
        return null;
    }

    public String porcentaje(VentaAnual v) {
        if (maximo.signum() == 0) return "0";
        double p = v.getTotal().doubleValue() * 100 / maximo.doubleValue();
        return String.format(Locale.ROOT, "%.1f", Math.max(p, 1));
    }

    public List<VentaAnual> getAnuales() { return anuales; }
    public BigDecimal getTotal() { return total; }
    public long getCantidad() { return cantidad; }
}