package helper;

import mx.desarrollo.autenticacion.integration.ServiceFacadeLocator;
import mx.desarrollo.entity.Administrador;
import mx.desarrollo.entity.Usuario;

import java.io.Serializable;

public class LoginHelper implements Serializable {

    public Usuario Login(String identificador, String password) {
        return ServiceFacadeLocator.getInstanceFacadeUsuario()
                .login(password, identificador);
    }

    public Administrador loginAdministrador(String identificador, String password) {
        return ServiceFacadeLocator.getInstanceFacadeAdministrador()
                .login(identificador, password);
    }
}