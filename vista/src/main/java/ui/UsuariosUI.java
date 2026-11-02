
package ui;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import mx.desarrollo.entity.Usuario;
import mx.desarrollo.autenticacion.integration.ServiceFacadeLocator;

import java.util.List;

@Named("usuariosUI")
@RequestScoped
public class UsuariosUI {

    private List<Usuario> usuarios;

    @PostConstruct
    public void init() {
        usuarios = ServiceFacadeLocator
                .getInstanceFacadeUsuario()
                .obtenerTodos();
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }
}
