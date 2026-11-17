/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import helper.AutoHelper;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



@Named("AutoExtrasBeanUI")
@SessionScoped
public class AutoExtrasBeanUI implements Serializable {

    @Inject
    private AutoBeanUI autoBeanUI;

    private List<String> opcionesEquipamiento;
    private List<String> equipamientoSeleccionado;
    private List<String> equipamientoExtra;

    /**
     * Metodo postconstructor todo lo que este dentro de este metodo
     * sera la primero que haga cuando cargue la pagina
     */

    @PostConstruct
    public void init() {
        opcionesEquipamiento = new ArrayList<>(List.of(
                "Aire Acondicionado", "Vidrios electricos"));

        equipamientoSeleccionado = new ArrayList<>();
        equipamientoExtra = new ArrayList<>();
    }

    public void guardarEquipamiento(){

        try{
            String vin = autoBeanUI.getVinRegistrado();
            if(autoBeanUI.getVinRegistrado() == null || vin.trim().isEmpty()) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(
                                FacesMessage.SEVERITY_WARN,
                                "Aviso",
                                "No se ha encontrado el auto"
                        ));
                return;


            }else{
                List<String> listaEquipamiento = new ArrayList<>();
                if(equipamientoSeleccionado != null){
                    listaEquipamiento.addAll(equipamientoSeleccionado);
                }
                if(equipamientoExtra != null){
                    listaEquipamiento.addAll(equipamientoExtra);
                }

                if(listaEquipamiento.isEmpty()){

                    FacesContext.getCurrentInstance().addMessage(null,
                            new FacesMessage(
                                    FacesMessage.SEVERITY_WARN,
                                    "Aviso",
                                    "No hay elementos seleccionados"
                            ));
                    return;
                }else{
                    AutoHelper.guardarEquipamiento(vin, listaEquipamiento);
                    FacesContext.getCurrentInstance().addMessage(null,
                            new FacesMessage(
                                    FacesMessage.SEVERITY_INFO,
                                    "Exito",
                                    "Elementos registrados"
                            ));
                    equipamientoExtra = new ArrayList<>();
                    equipamientoSeleccionado = new ArrayList<>();
                }
            }
        }catch (IllegalStateException e){
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(
                            FacesMessage.SEVERITY_WARN,
                            "Aviso",
                            "Error al registrar los datos"
                    ));

        }catch(Exception e){
            e.printStackTrace();

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(
                            FacesMessage.SEVERITY_ERROR,
                            "Error",
                            "No se pudo realizar el registro de elementos"
                    ));
        }
    }

    public List<String> getOpcionesEquipamiento() {
        return opcionesEquipamiento;
    }

    public void setOpcionesEquipamiento(List<String> opcionesEquipamiento) {
        this.opcionesEquipamiento = opcionesEquipamiento;
    }

    public List<String> getEquipamientoSeleccionado() {
        return equipamientoSeleccionado;
    }

    public void setEquipamientoSeleccionado(List<String> equipamientoSeleccionado) {
        this.equipamientoSeleccionado = equipamientoSeleccionado;
    }

    public List<String> getEquipamientoExtra() {
        return equipamientoExtra;
    }

    public void setEquipamientoExtra(List<String> equipamientoExtra) {
        this.equipamientoExtra = equipamientoExtra;
    }
}