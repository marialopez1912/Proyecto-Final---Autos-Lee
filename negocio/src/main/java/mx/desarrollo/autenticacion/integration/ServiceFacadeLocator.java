package mx.desarrollo.autenticacion.integration;


import mx.desarrollo.autenticacion.facade.FacadeAdministrador;
import mx.desarrollo.autenticacion.facade.FacadeUsuario;

public class ServiceFacadeLocator {

    private static FacadeAdministrador facadeAdministrador;
    private static FacadeUsuario facadeUsuario;

    public static FacadeAdministrador getInstancefacadeAdministrador() {
        if (facadeAdministrador == null) {
            facadeAdministrador = new FacadeAdministrador();
            return facadeAdministrador;
        } else {
            return facadeAdministrador;
        }
    }

    public static FacadeUsuario getInstanceFacadeUsuario() {
        if (facadeUsuario == null) {
            facadeUsuario = new FacadeUsuario();
            return facadeUsuario;
        } else {
            return facadeUsuario;
        }
    }
}