package mx.desarrollo.autenticacion.integration;


import mx.desarrollo.autenticacion.facade.FacadeAdministrador;
import mx.desarrollo.autenticacion.facade.FacadeAuto;
import mx.desarrollo.autenticacion.facade.FacadeUsuario;

public class ServiceFacadeLocator {

    private static FacadeAdministrador facadeAdministrador;
    private static FacadeUsuario facadeUsuario;
    private static FacadeAuto facadeAuto;

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

    public static FacadeAuto getInstanceFacadeAuto() {
        if (facadeAuto == null) {
            facadeAuto = new FacadeAuto();
            return facadeAuto;
        } else {
            return facadeAuto;
        }
    }
}