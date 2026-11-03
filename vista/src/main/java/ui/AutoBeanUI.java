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
import mx.desarrollo.entity.Auto;
import jakarta.inject.Inject;
import mx.desarrollo.entity.Administrador;
import mx.desarrollo.entity.AutoId;

import java.io.Serializable;

@Named("AutoBeanUI")
@SessionScoped
public class AutoBeanUI implements Serializable{
    @Inject
private LoginBeanUI loginUI;

    private LoginHelper loginHelper;
    private Auto auto;

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

            // Obtener el ID del administrador que inició sesión
            Integer administradorId = administrador.getId();

            // Asegurar que el auto tenga su llave compuesta
            if (auto.getId() == null) {
                auto.setId(new AutoId());
            }

            // Guardar mediante AutoHelper, enviando ambos argumentos
            AutoHelper.saveAuto(auto, administradorId);

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

    /* getters y setters*/

    public Auto getAuto() { return auto; }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }
}