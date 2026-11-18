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

    private List<String> opcionesSeguridad;
    private List<String> seguridadSeleccionado;
    private List<String> seguridadExtra;

    /**
     * Metodo postconstructor todo lo que este dentro de este metodo
     * sera la primero que haga cuando cargue la pagina
     */

    @PostConstruct
    public void init() {
        opcionesEquipamiento = new ArrayList<>(List.of(
                "Aire Acondicionado", "Vidrios electricos", "Bluetooth",
                "Controles al volante", "Freno de emergencia", "Camara de reversa",
                "Pantallas tactiles"));

        equipamientoSeleccionado = new ArrayList<>();
        equipamientoExtra = new ArrayList<>();

        opcionesSeguridad = new ArrayList<>(List.of(
                "Bolsas de aire", "Sistema de frenos", "Iluminacion",
                "Asistencia de conduccion", "Seguro para niños"
        ));

        seguridadSeleccionado = new ArrayList<>();
        seguridadExtra = new ArrayList<>();
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
                                    "Elementos tecnologicos registrados"
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

    public void guardarSeguridad(){

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
                List<String> listaSeguridad = new ArrayList<>();
                if(seguridadSeleccionado != null){
                    listaSeguridad.addAll(seguridadSeleccionado);
                }
                if(seguridadExtra != null){
                    listaSeguridad.addAll(seguridadExtra);
                }

                if(listaSeguridad.isEmpty()){

                    FacesContext.getCurrentInstance().addMessage(null,
                            new FacesMessage(
                                    FacesMessage.SEVERITY_WARN,
                                    "Aviso",
                                    "No hay elementos seleccionados"
                            ));
                    return;
                }else{
                    AutoHelper.guardarSeguridad(vin, listaSeguridad);
                    FacesContext.getCurrentInstance().addMessage(null,
                            new FacesMessage(
                                    FacesMessage.SEVERITY_INFO,
                                    "Exito",
                                    "Elementos de seguridad registrados"
                            ));
                    seguridadExtra = new ArrayList<>();
                    seguridadSeleccionado = new ArrayList<>();
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

    public List<String> getOpcionesSeguridad() {
        return opcionesSeguridad;
    }

    public void setOpcionesSeguridad(List<String> opcionesSeguridad) {
        this.opcionesSeguridad = opcionesSeguridad;
    }

    public List<String> getSeguridadSeleccionado() {
        return seguridadSeleccionado;
    }

    public void setSeguridadSeleccionado(List<String> seguridadSeleccionado) {
        this.seguridadSeleccionado = seguridadSeleccionado;
    }

    public List<String> getSeguridadExtra() {
        return seguridadExtra;
    }

    public void setSeguridadExtra(List<String> seguridadExtra) {
        this.seguridadExtra = seguridadExtra;
    }
}