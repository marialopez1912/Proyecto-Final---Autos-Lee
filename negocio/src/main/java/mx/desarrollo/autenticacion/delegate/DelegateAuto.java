package mx.desarrollo.autenticacion.delegate;

import mx.desarrollo.entity.Auto;
import mx.desarrollo.entity.AutoEquipamiento;
import mx.desarrollo.entity.AutoSeguridad;
import mx.desarrollo.persistence.integration.ServiceLocator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class DelegateAuto {

    public void saveAuto(Auto auto, Integer administradorId) {

        BigDecimal precioCalculadoVenta = calcularPrecioVenta(auto.getPrecioCompra(), auto.getPorcentajeGanancia());
        if(precioCalculadoVenta == null){
            throw new IllegalStateException("Rellena todos los campos");
        }
        auto.setPrecioVenta(precioCalculadoVenta);

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

    public BigDecimal calcularPrecioVenta(BigDecimal precioCompra, BigDecimal porcentaje){
        if(precioCompra == null || porcentaje == null){
            return null;
        }
        return
        precioCompra.multiply(BigDecimal
                .ONE.add(porcentaje.divide(BigDecimal.valueOf(100))))
                .setScale(2, RoundingMode.HALF_UP);
    }
}