/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import helper.AutoHelper;
import helper.LoginHelper;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import jakarta.inject.Inject;
import mx.desarrollo.entity.Administrador;
import mx.desarrollo.entity.Auto;
import mx.desarrollo.entity.AutoId;
import org.primefaces.event.FlowEvent;
import java.util.*;
import java.io.Serializable;


@Named("AutoBeanUI")
@SessionScoped
public class AutoBeanUI implements Serializable {
    @Inject
    private LoginBeanUI loginUI;

    private LoginHelper loginHelper;
    private Auto auto;
    private List<Auto> listaAutos;
    private String vinBusqueda;
    private Auto autoSeleccionado;
    private String vinRegistrado;
    private boolean autoGuardado;

    public AutoBeanUI() {
        loginHelper = new LoginHelper();
    }

    /**
     * Metodo postconstructor todo lo que este dentro de este metodo
     * sera la primero que haga cuando cargue la pagina
     */

    @PostConstruct
    public void init() {
        auto = new Auto();
        auto.setId(new AutoId());
    }

    public String onFlowProcess(FlowEvent event){
        return event.getNewStep();
    }

    public void guardar() {
        try {
            Administrador administrador = loginUI.getAdministrador();

            if (administrador == null) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(
                                FacesMessage.SEVERITY_ERROR,
                                "Error",
                                "No se encontró el administrador que inició sesión"
                        ));
                return;
            }

            Integer administradorId = administrador.getId();

            if (auto.getId() == null) {
                auto.setId(new AutoId());
            }

            AutoHelper.saveAuto(auto, administradorId);

            vinRegistrado = auto.getVin();
            autoGuardado = true;

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(
                            FacesMessage.SEVERITY_INFO,
                            "Auto registrado",
                            "Se guardó correctamente"
                    ));

            auto = new Auto();
            auto.setId(new AutoId());

        } catch (Exception e) {
            e.printStackTrace();

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(
                            FacesMessage.SEVERITY_ERROR,
                            "Error",
                            "No se pudo registrar el auto"
                    ));
        }
    }

    public void nuevoRegistro(){
        autoGuardado = false;
        vinRegistrado = null;

    }

    public void consultarAutos() {
        try {
            listaAutos = AutoHelper.obtenerTodos();

            if (listaAutos.isEmpty()) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(
                                FacesMessage.SEVERITY_INFO,
                                "Consulta",
                                "No hay autos registrados"
                        ));
            }

        } catch (Exception e) {
            e.printStackTrace();

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(
                            FacesMessage.SEVERITY_ERROR,
                            "Error",
                            "No se pudieron consultar los autos"
                    ));
        }
    }


    public void consultarAutosDisponibles() {
        try {
            listaAutos = AutoHelper.obtenerDisponibles();

            if (listaAutos.isEmpty()) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(
                                FacesMessage.SEVERITY_INFO,
                                "Consulta",
                                "No hay autos registrados a la venta"
                        ));
            }

        } catch (Exception e) {
            e.printStackTrace();

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(
                            FacesMessage.SEVERITY_ERROR,
                            "Error",
                            "No se pudieron consultar los autos disponibles"
                    ));
        }
    }

    public void buscar() {
        System.out.println("Entro a buscar"); //solo para asegurar q funciona pq no quiere funcionar
        try {
            if (vinBusqueda == null || vinBusqueda.trim().isEmpty()) {
                listaAutos = AutoHelper.obtenerTodos();
            } else {
                Auto encontrado = AutoHelper.lookForVIN(vinBusqueda.trim());
                listaAutos = new ArrayList<>();

                if (encontrado == null) {
                    FacesContext.getCurrentInstance().addMessage(null,
                            new FacesMessage(FacesMessage.SEVERITY_WARN,
                                    "Error", "No se encontro el auto"));
                } else {
                    listaAutos.add(encontrado);
                }
            }

            autoSeleccionado = null;

        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                            "No se pudo realizar la busqueda"));
        }
    }


    public void darDeBajaAuto(){
       System.out.println("Intento de dar de baja");
        try{
           if(autoSeleccionado == null) {
               FacesContext.getCurrentInstance().addMessage(null,
                       new FacesMessage(FacesMessage.SEVERITY_INFO, "Error",
                               "Seleccione un auto primero"));
           }else if(autoSeleccionado.getDisponible() == false){
               FacesContext.getCurrentInstance().addMessage(null,
                       new FacesMessage(FacesMessage.SEVERITY_INFO, "Error",
                               "El auto ya esta dado de baja"));
           }else{
                AutoHelper.deactivateAuto(autoSeleccionado.getVin());
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito",
                                "Auto dado de baja"));
                buscar();
            }



       }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                            "Error al realizar la operacion"));
       }

    }




    public List<Auto> getListaAutos() {
        return listaAutos;
    }
    public Auto getAuto() { return auto; }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }

    public String getVinBusqueda() {
        return vinBusqueda;
    }

    public void setVinBusqueda(String vinBusqueda) {
        this.vinBusqueda = vinBusqueda;
    }

    public Auto getAutoSeleccionado() {
        return autoSeleccionado;
    }

    public void setAutoSeleccionado(Auto autoSeleccionado) {
        this.autoSeleccionado = autoSeleccionado;
    }

    public String getVinRegistrado(){return vinRegistrado;}

    public boolean isAutoGuardado(){ return autoGuardado;}
}