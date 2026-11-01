
package mx.desarrollo.autenticacion.delegate;

import mx.desarrollo.entity.Administrador;
import mx.desarrollo.persistence.integration.ServiceLocator;

public class DelegateAdministrador {

    public Administrador login(String identificador, String password) {

        Administrador administrador = ServiceLocator
                .getInstanceAdministradorDAO()
                .buscarPorCorreoOUsuario(identificador);

        if (administrador != null &&
                administrador.getContrasenia() != null &&
                administrador.getContrasenia().equals(password)) {
            return administrador;
        }

        return null;
    }

    public Administrador buscarPorCorreoOUsuario(String identificador) {
        return ServiceLocator.getInstanceAdministradorDAO()
                .buscarPorCorreoOUsuario(identificador);
    }

    public void saveAdministrador(Administrador administrador) {
        ServiceLocator.getInstanceAdministradorDAO().save(administrador);
    }
}
