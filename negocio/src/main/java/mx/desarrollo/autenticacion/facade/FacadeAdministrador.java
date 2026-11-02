package mx.desarrollo.autenticacion.facade;

import mx.desarrollo.autenticacion.delegate.DelegateAdministrador;
import mx.desarrollo.entity.Administrador;

import java.util.List;

public class FacadeAdministrador {

    private final DelegateAdministrador delegateAdministrador;

    public FacadeAdministrador() {
        this.delegateAdministrador = new DelegateAdministrador();
    }

    public void guardarAdministrador(Administrador administrador) {
        delegateAdministrador.saveAdministrador(administrador);
    }

    public Administrador login(String identificador, String password) {
        return delegateAdministrador.login(identificador, password);
    }

    public Administrador buscarPorCorreoOUsuario(String identificador) {
        return delegateAdministrador.buscarPorCorreoOUsuario(identificador);
    }

    public List<Administrador> obtenerTodos() {
        return delegateAdministrador.obtenerTodos();
    }
}