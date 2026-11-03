package helper;

import mx.desarrollo.entity.Auto;
import mx.desarrollo.autenticacion.integration.ServiceFacadeLocator;

public class AutoHelper {

    public static void saveAuto(Auto auto, Integer administradorId) {
        ServiceFacadeLocator.getInstanceFacadeAuto()
                .saveAuto(auto, administradorId);
    }
}