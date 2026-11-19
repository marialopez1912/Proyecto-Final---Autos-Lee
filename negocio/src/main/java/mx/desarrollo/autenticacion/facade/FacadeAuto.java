package mx.desarrollo.autenticacion.facade;

import mx.desarrollo.autenticacion.delegate.DelegateAuto;
import mx.desarrollo.entity.Auto;

import java.math.BigDecimal;
import java.util.List;

public class FacadeAuto {

    private final DelegateAuto delegateAuto;

    public FacadeAuto() {
        this.delegateAuto = new DelegateAuto();
    }

    public void saveAuto(Auto auto, Integer administradorId) {
        delegateAuto.saveAuto(auto, administradorId);
    }

    public void deactivateAuto(String VIN){delegateAuto.deactivateAuto(VIN);}

    public Auto lookForVIN(String VIN){return delegateAuto.lookForVIN(VIN);}

    public List<Auto> obtenerTodos() {
        return delegateAuto.obtenerTodos();
    }

    public List<Auto> obtenerDisponibles(){ return delegateAuto.obtenerDisponibles();}

    public void guardarEquipamiento(String VIN, List<String> elementos){
        delegateAuto.guardarEquipamiento(VIN, elementos);
    }

    public void guardarSeguridad(String VIN, List<String> elementos){

        delegateAuto.guardarSeguridad(VIN, elementos);
    }

    public BigDecimal calcularPrecioVenta(BigDecimal precioCompra, BigDecimal porcentaje){
        return delegateAuto.calcularPrecioVenta(precioCompra, porcentaje);
    }
}