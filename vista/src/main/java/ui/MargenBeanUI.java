package ui;

import helper.EstadisticasHelper;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import mx.desarrollo.estadisticas.dto.MargenAuto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("margenUI")
@SessionScoped
public class MargenBeanUI implements Serializable {

    @Inject
    private LoginBeanUI loginUI;

    private final EstadisticasHelper helper = new EstadisticasHelper();
    private List<MargenAuto> todos = new ArrayList<>();
    private List<MargenAuto> mostrados = new ArrayList<>();
    private String vin = "";

    public String iniciar() {
        if (loginUI.getAdministrador() == null) {
            return "login?faces-redirect=true";
        }
        vin = "";
        cargar();
        return null;
    }

    public void cargar() {
        todos = helper.margenes();
        mostrados = new ArrayList<>();
        for (MargenAuto m : todos) {
            if (vin == null || vin.isBlank() || vin.equals(m.getVin())) mostrados.add(m);
        }
    }

    public List<MargenAuto> getTodos() { return todos; }
    public List<MargenAuto> getMostrados() { return mostrados; }
    public String getVin() { return vin; }
    public void setVin(String vin) { this.vin = vin; }
}