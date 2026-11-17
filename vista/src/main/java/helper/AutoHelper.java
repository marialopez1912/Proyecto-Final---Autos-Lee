package helper;

import mx.desarrollo.autenticacion.integration.ServiceFacadeLocator;
import mx.desarrollo.entity.Auto;
import mx.desarrollo.persistence.integration.ServiceLocator;

import java.util.List;


public class AutoHelper {

    public static void saveAuto(Auto auto, Integer administradorId) {
        ServiceFacadeLocator.getInstanceFacadeAuto()
                .saveAuto(auto, administradorId);
    }

    public static void deactivateAuto(String VIN){
        ServiceFacadeLocator.getInstanceFacadeAuto().deactivateAuto(VIN);
    }

    public static Auto lookForVIN(String VIN){ return ServiceFacadeLocator.getInstanceFacadeAuto().lookForVIN(VIN);}

    public static List<Auto> obtenerTodos() {
        return ServiceFacadeLocator.getInstanceFacadeAuto().obtenerTodos();
    }

    public static List<Auto> obtenerDisponibles(){ return ServiceFacadeLocator.getInstanceFacadeAuto().obtenerDisponibles();}

    public static void guardarEquipamiento(String VIN, List<String> elementos){
        ServiceFacadeLocator.getInstanceFacadeAuto().guardarEquipamiento(VIN, elementos);
    }
}