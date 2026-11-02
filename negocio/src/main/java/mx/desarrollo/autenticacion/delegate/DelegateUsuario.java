
package mx.desarrollo.autenticacion.delegate;

import mx.desarrollo.entity.Usuario;
import mx.desarrollo.persistence.integration.ServiceLocator;

public class DelegateUsuario {

    public Usuario login(String password, String identificador) {

        Usuario usuario = ServiceLocator
                .getInstanceUsuarioDAO()
                .buscarPorCorreoOUsuario(identificador);

        if (usuario != null &&
                usuario.getContrasenia() != null &&
                usuario.getContrasenia().equals(password)) {
            return usuario;
        }

        return null;
    }

    public void saveUsario(Usuario usuario) {
        ServiceLocator.getInstanceUsuarioDAO().save(usuario);
    }
}
