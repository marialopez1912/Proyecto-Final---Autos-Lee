package helper;

import mx.desarrollo.entity.Auto;
import mx.desarrollo.autenticacion.integration.ServiceFacadeLocator;

import java.util.List;

public class AutoHelper {

    public static void saveAuto(Auto auto, Integer administradorId) {
        ServiceFacadeLocator.getInstanceFacadeAuto()
                .saveAuto(auto, administradorId);
    }

    public static List<Auto> obtenerTodos() {
        return ServiceFacadeLocator.getInstanceFacadeAuto().obtenerTodos();
    }
}