package helper;

import mx.desarrollo.autenticacion.integration.ServiceFacadeLocator;
import mx.desarrollo.entity.Administrador;
import mx.desarrollo.entity.Usuario;

import java.io.Serializable;

public class LoginHelper implements Serializable {

    /**
     * Login de usuarios normales (tabla usuario).
     */
    public Usuario Login(String correo, String password) {
        return ServiceFacadeLocator.getInstanceFacadeUsuario().login(password, correo);
    }

    /**
     * Login de administradores (tabla administrador).
     */
    public Administrador LoginAdministrador(String correo, String password) {
        return ServiceFacadeLocator.getInstancefacadeAdministrador().login(password, correo);
    }

}