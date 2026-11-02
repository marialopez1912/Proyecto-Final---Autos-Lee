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
import mx.desarrollo.entity.Usuario;

import java.io.IOException;
import java.io.Serializable;

@Named("AutoBeanUI")
@SessionScoped
public class AutoBeanUI implements Serializable{
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
    public void init(){ auto= new Auto(); }

    public void guardar(){
        try{
            AutoHelper.saveAuto(auto);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Auto registrado", "Se guardo correctamente"));
            auto = new Auto();
        }catch(Exception e){
            e.printStackTrace();

        }
    }

    /* getters y setters*/

    public Auto getAuto() { return auto; }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }
}