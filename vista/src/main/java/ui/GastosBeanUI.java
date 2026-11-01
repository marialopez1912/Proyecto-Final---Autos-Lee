package ui;

import helper.EstadisticasHelper;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import mx.desarrollo.estadisticas.dto.TotalCategoria;
import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.bar.BarChartDataSet;
import org.primefaces.model.charts.bar.BarChartModel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Named("gastosUI")
@SessionScoped
public class GastosBeanUI implements Serializable {

    @Inject
    private LoginBeanUI loginUI;

    private final EstadisticasHelper helper = new EstadisticasHelper();
    private String tipo = "tipo";                 // "tipo" o "marca"
    private List<TotalCategoria> filas = new ArrayList<>();
    private BigDecimal totalGeneral = BigDecimal.ZERO;
    private BarChartModel modelo;

    public String iniciar() {

        if (loginUI.getUsuario() == null || loginUI.getUsuario().getId() == null) {
            return "login?faces-redirect=true";
        }
        cargar();
        return null;
    }

    public void cargar() {
        filas = helper.totalesGastos(tipo);

        totalGeneral = BigDecimal.ZERO;
        List<String> etiquetas = new ArrayList<>();
        List<Object> valores = new ArrayList<>();
        for (TotalCategoria t : filas) {
            totalGeneral = totalGeneral.add(t.getTotal());
            etiquetas.add(t.getEtiqueta());
            valores.add(t.getTotal());
        }

        BarChartDataSet datos = new BarChartDataSet();
        datos.setLabel("Gastos (MXN)");
        datos.setData(valores);
        datos.setBackgroundColor("rgb(192, 0, 0)");

        ChartData data = new ChartData();
        data.addChartDataSet(datos);
        data.setLabels(etiquetas);

        modelo = new BarChartModel();
        modelo.setData(data);
    }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public List<TotalCategoria> getFilas() { return filas; }
    public BigDecimal getTotalGeneral() { return totalGeneral; }
    public BarChartModel getModelo() { return modelo; }
}