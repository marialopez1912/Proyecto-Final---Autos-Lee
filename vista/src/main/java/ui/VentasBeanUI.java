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
    private List<String> marcas = new ArrayList<>();
    private List<String> modelos = new ArrayList<>();
    private String marca = "";
    private String modelo = "";
    private BigDecimal total = BigDecimal.ZERO;

    public String iniciar() {
        if (loginUI.getAdministrador() == null) {
            return "login?faces-redirect=true";
        }
        marca = "";
        modelo = "";
        marcas = helper.marcas();
        modelos = helper.modelos(null);
        buscar();
        return null;
    }

    public void buscar() {
        ventas = helper.ventasFiltradas(marca, modelo);
        total = BigDecimal.ZERO;
        for (VentaReporte v : ventas) total = total.add(v.getImporte());
    }

    public void cambiarMarca() {
        modelo = "";
        modelos = helper.modelos(marca);
        buscar();
    }

    public void limpiar() {
        marca = "";
        modelo = "";
        modelos = helper.modelos(null);
        buscar();
    }

    public boolean isHayFiltro() {
        return (marca != null && !marca.isBlank()) || (modelo != null && !modelo.isBlank());
    }

    public String getMensajeVacio() {
        return isHayFiltro() ? "No se encontraron ventas con ese filtro." : "No hay ventas registradas.";
    }

    public List<VentaReporte> getVentas() { return ventas; }
    public int getCantidad() { return ventas.size(); }
    public BigDecimal getTotal() { return total; }
    public List<String> getMarcas() { return marcas; }
    public List<String> getModelos() { return modelos; }
    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }
    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }
}