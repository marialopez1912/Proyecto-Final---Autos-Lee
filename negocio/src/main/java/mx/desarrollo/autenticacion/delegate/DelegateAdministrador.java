package mx.desarrollo.autenticacion.delegate;

import mx.desarrollo.entity.Administrador;
import mx.desarrollo.persistence.integration.ServiceLocator;

public class DelegateAdministrador {
    public void saveAdministrador(Administrador administrador){
        ServiceLocator.getInstanceAdministradorDAO().save(administrador);
    }

}