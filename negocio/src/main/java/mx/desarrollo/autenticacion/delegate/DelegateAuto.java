package mx.desarrollo.autenticacion.delegate;

import mx.desarrollo.entity.Auto;
import mx.desarrollo.entity.AutoEquipamiento;
import mx.desarrollo.entity.AutoSeguridad;
import mx.desarrollo.persistence.integration.ServiceLocator;

import java.util.ArrayList;
import java.util.List;

public class DelegateAuto {

    public void saveAuto(Auto auto, Integer administradorId) {

        ServiceLocator.getInstanceAutoDAO()
                .guardarAuto(auto, administradorId);
    }

    public Auto lookForVIN(String VIN){
        return ServiceLocator.getInstanceAutoDAO()
                .buscarPorVIN(VIN);
    }


    public void deactivateAuto(String VIN){
        ServiceLocator.getInstanceAutoDAO().darDeBajaAuto(VIN);
    }

    public List<Auto> obtenerTodos() {
        return ServiceLocator.getInstanceAutoDAO().obtenerTodos();
    }

    public List<Auto> obtenerDisponibles(){ return ServiceLocator.getInstanceAutoDAO().obtenerDisponibles();}

    public void guardarEquipamiento(String VIN, List<String> elementos) {
        Auto auto = ServiceLocator.getInstanceAutoDAO().buscarPorVIN(VIN);
        if(auto == null){
            throw new  IllegalStateException("No se encontro el auto");
        }
        Integer idAuto = auto.getId().getIdAutoSistema();

        if(elementos == null || elementos.isEmpty()) {
            return;
        }
        List<AutoEquipamiento> existentes = ServiceLocator.getInstanceAutoEquipamientoDAO().obtenerPorAuto(idAuto);
        List<String> listaNueva = new ArrayList<>();

        for(String texto : elementos){
            if(texto == null){
                continue;
            }

            String textoLimpio = texto.trim();
            if(textoLimpio.isEmpty()){
                continue;
            }

            boolean repetido = listaNueva.stream().anyMatch(t -> t.equalsIgnoreCase(textoLimpio));

            boolean yaExiste = existentes.stream().anyMatch(x -> x.getId().getEquipamiento().equalsIgnoreCase(textoLimpio));

            if(repetido || yaExiste){
                continue;
            }

            listaNueva.add(textoLimpio);


        }
        if(!listaNueva.isEmpty()){
            ServiceLocator.getInstanceAutoEquipamientoDAO().guardar(idAuto, listaNueva);
        }
    }


    public void guardarSeguridad(String VIN, List<String> elementos) {
        Auto auto = ServiceLocator.getInstanceAutoDAO().buscarPorVIN(VIN);
        if(auto == null){
            throw new  IllegalStateException("No se encontro el auto");
        }
        Integer idAuto = auto.getId().getIdAutoSistema();

        if(elementos == null || elementos.isEmpty()) {
            return;
        }
        List<AutoSeguridad> existentes = ServiceLocator.getInstanceAutoSeguridadDAO().obtenerPorAuto(idAuto);
        List<String> listaNueva = new ArrayList<>();

        for(String texto : elementos){
            if(texto == null){
                continue;
            }

            String textoLimpio = texto.trim();
            if(textoLimpio.isEmpty()){
                continue;
            }

            boolean repetido = listaNueva.stream().anyMatch(t -> t.equalsIgnoreCase(textoLimpio));

            boolean yaExiste = existentes.stream().anyMatch(x -> x.getId().getSistemaSeguridad().equalsIgnoreCase(textoLimpio));

            if(repetido || yaExiste){
                continue;
            }

            listaNueva.add(textoLimpio);


        }
        if(!listaNueva.isEmpty()){
            ServiceLocator.getInstanceAutoSeguridadDAO().guardar(idAuto, listaNueva);
        }
    }
}