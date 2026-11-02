package helper;

import mx.desarrollo.autenticacion.integration.ServiceFacadeLocator;
import mx.desarrollo.entity.Usuario;
import mx.desarrollo.entity.Administrador;

import java.io.Serializable;

public class LoginHelper implements Serializable {

    public Usuario Login(String correo, String password) {
        return ServiceFacadeLocator.getInstanceFacadeUsuario()
                .login(password, correo);
    }

    public Administrador loginAdministrador(String identificador, String password) {
        return ServiceFacadeLocator.getInstanceFacadeAdministrador()
                .login(identificador, password);
    }
}
