package mx.desarrollo.autenticacion.delegate;

import mx.desarrollo.entity.*;
import mx.desarrollo.persistence.integration.ServiceLocator;

public class DelegateAuto {
    public void saveAuto(Auto auto){
        Administrador admin = ServiceLocator.getInstanceAdministradorDAO().find(1).orElseThrow();
        auto.setAdministradorIdAdministrador(admin);
        ServiceLocator.getInstanceAutoDAO().save(auto);
    }

}