package ui;

import helper.EstadisticasHelper;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import mx.desarrollo.estadisticas.dto.VentaReporte;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Named("ventasUI")
@SessionScoped
public class VentasBeanUI implements Serializable {

    @Inject
    private LoginBeanUI loginUI;

    private final EstadisticasHelper helper = new EstadisticasHelper();
    private List<VentaReporte> ventas = new ArrayList<>();
    private BigDecimal total = BigDecimal.ZERO;

    public String iniciar() {
        // TODO: cuando exista el rol de administrador, validarlo aquí
        if (loginUI.getUsuario() == null || loginUI.getUsuario().getId() == null) {
            return "login?faces-redirect=true";
        }
        ventas = helper.ventas();
        total = BigDecimal.ZERO;
        for (VentaReporte v : ventas) total = total.add(v.getImporte());
        return null;
    }

    public List<VentaReporte> getVentas() { return ventas; }
    public int getCantidad() { return ventas.size(); }
    public BigDecimal getTotal() { return total; }
}