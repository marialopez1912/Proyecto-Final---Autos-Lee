package ui;

import helper.EstadisticasHelper;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import mx.desarrollo.estadisticas.dto.TotalCategoria;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Named("gastosUI")
@SessionScoped
public class GastosBeanUI implements Serializable {

    @Inject
    private LoginBeanUI loginUI;

    private final EstadisticasHelper helper = new EstadisticasHelper();
    private String tipo = "tipo";
    private List<TotalCategoria> filas = new ArrayList<>();
    private BigDecimal totalGeneral = BigDecimal.ZERO;
    private BigDecimal maximo = BigDecimal.ZERO;
    private String mayor = "-";

    public String iniciar() {
        // TODO: cuando exista el rol de administrador, validarlo aquí
        if (loginUI.getUsuario() == null || loginUI.getUsuario().getId() == null) {
            return "login?faces-redirect=true";
        }
        cargar();
        return null;
    }

    public void cargar() {
        filas = helper.totalesGastos(tipo);
        totalGeneral = BigDecimal.ZERO;
        maximo = BigDecimal.ZERO;
        mayor = "-";
        for (TotalCategoria t : filas) {
            totalGeneral = totalGeneral.add(t.getTotal());
            if (t.getTotal().compareTo(maximo) > 0) {
                maximo = t.getTotal();
                mayor = t.getEtiqueta();
            }
        }
    }

    public void verPorTipo()  { tipo = "tipo";  cargar(); }
    public void verPorMarca() { tipo = "marca"; cargar(); }

    public String porcentaje(TotalCategoria t) {
        if (maximo.signum() == 0) return "0";
        double p = t.getTotal().doubleValue() * 100 / maximo.doubleValue();
        return String.format(Locale.ROOT, "%.1f", Math.max(p, 1));
    }

    public int getCantidad() { return filas.size(); }
    public String getMayor() { return mayor; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public List<TotalCategoria> getFilas() { return filas; }
    public BigDecimal getTotalGeneral() { return totalGeneral; }
}