package mx.desarrollo.autenticacion.facade;

import mx.desarrollo.autenticacion.delegate.DelegateAdministrador;
import mx.desarrollo.entity.Administrador;

public class FacadeAdministrador {

    private final DelegateAdministrador delegateAdministrador;

    public FacadeAdministrador() {
        this.delegateAdministrador = new DelegateAdministrador();
    }

    public Administrador login(String password, String correo) {
        return delegateAdministrador.login(password, correo);
    }

    public void guardarAdministrador(Administrador administrador) {
        delegateAdministrador.saveAdministrador(administrador);
    }

}