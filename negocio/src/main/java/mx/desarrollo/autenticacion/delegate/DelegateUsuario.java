
package mx.desarrollo.autenticacion.delegate;

import mx.desarrollo.entity.Usuario;
import mx.desarrollo.persistence.integration.ServiceLocator;

import java.util.List;

public class DelegateUsuario {

    public Usuario login(String password, String identificador) {

        System.out.println("=== PRUEBA LOGIN USUARIO ===");
        System.out.println("Identificador recibido: " + identificador);

        Usuario usuario = ServiceLocator
                .getInstanceUsuarioDAO()
                .buscarPorCorreoOUsuario(identificador);

        System.out.println("¿Usuario encontrado?: " + (usuario != null));

        if (usuario != null) {
            System.out.println("ID encontrado: " + usuario.getId());
            System.out.println("¿Contraseña coincide?: " +
                    usuario.getContrasenia().equals(password));
        }

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

    public List<Usuario> obtenerTodos() {
        return ServiceLocator
                .getInstanceUsuarioDAO()
                .obtenerTodos();
    }
}
