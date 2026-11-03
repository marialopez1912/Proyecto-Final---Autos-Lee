package mx.desarrollo.autenticacion.delegate;

import mx.desarrollo.entity.Auto;
import mx.desarrollo.persistence.integration.ServiceLocator;

import java.util.List;

public class DelegateAuto {

    public void saveAuto(Auto auto, Integer administradorId) {

        ServiceLocator.getInstanceAutoDAO()
                .guardarAuto(auto, administradorId);
    }

    public List<Auto> obtenerTodos() {
        return ServiceLocator.getInstanceAutoDAO().obtenerTodos();
    }
}