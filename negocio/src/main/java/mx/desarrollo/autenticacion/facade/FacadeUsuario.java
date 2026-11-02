package mx.desarrollo.autenticacion.facade;

import mx.desarrollo.autenticacion.delegate.DelegateUsuario;
import mx.desarrollo.entity.Usuario;

import java.util.List;

public class FacadeUsuario {

    private final DelegateUsuario delegateUsuario;

    public FacadeUsuario() {

        this.delegateUsuario = new DelegateUsuario();
    }

    public Usuario login(String password, String correo){

        return delegateUsuario.login(password, correo);
    }

    public void saveUsario(Usuario usuario){

        delegateUsuario.saveUsario(usuario);
    }

    public List<Usuario> obtenerTodos() {
        return delegateUsuario.obtenerTodos();
    }

}