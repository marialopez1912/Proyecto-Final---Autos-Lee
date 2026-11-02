package ui;

import helper.EstadisticasHelper;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import mx.desarrollo.estadisticas.dto.AutoResumen;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Named("inicioUI")
@SessionScoped
public class InicioBeanUI implements Serializable {

    @Inject
    private LoginBeanUI loginUI;

    private final EstadisticasHelper helper = new EstadisticasHelper();
    private List<AutoResumen> autos = new ArrayList<>();
    private AutoResumen seleccionado;
    private BigDecimal nuevoPrecio;

    public String iniciarUsuario() {
        String r = loginUI.validarSesion();
        if (r != null) return r;
        autos = helper.autos();
        return null;
    }


    public void seleccionar(AutoResumen a) {
        seleccionado = a;
        nuevoPrecio = a.getPrecio();
    }

    public void guardar() {
        FacesContext ctx = FacesContext.getCurrentInstance();
        if (nuevoPrecio == null || nuevoPrecio.signum() <= 0) {
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Precio no válido", "Escribe un precio mayor a 0."));
            return;
        }
        if (helper.actualizarPrecio(seleccionado.getVin(), nuevoPrecio)) {
            autos = helper.autos();
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Información actualizada", "El precio se guardó correctamente."));
        } else {
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "No se pudo guardar", "No se encontró el auto."));
        }
    }

    public List<AutoResumen> getAutos() { return autos; }
    public AutoResumen getSeleccionado() { return seleccionado; }
    public BigDecimal getNuevoPrecio() { return nuevoPrecio; }
    public void setNuevoPrecio(BigDecimal nuevoPrecio) { this.nuevoPrecio = nuevoPrecio; }
}