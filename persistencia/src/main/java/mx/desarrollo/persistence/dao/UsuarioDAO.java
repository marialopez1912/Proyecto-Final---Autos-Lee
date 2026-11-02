package mx.desarrollo.persistence.dao;

import jakarta.persistence.EntityManager;
import mx.desarrollo.entity.Usuario;
import mx.desarrollo.persistence.persistence.*;

import java.util.List;

public class UsuarioDAO extends AbstractDAO<Usuario> {
    private final EntityManager entityManager;

    public UsuarioDAO(EntityManager em) {
        super(Usuario.class);
        this.entityManager = em;
    }

    public List<Usuario> obtenerTodos(){
        return entityManager
                .createQuery("SELECT u FROM Usuario u", Usuario.class)
                .getResultList();
    }

    public Usuario buscarPorCorreoOUsuario(String identificador) {
        List<Usuario> resultados = entityManager.createQuery(
                        "SELECT u FROM Usuario u " +
                                "WHERE LOWER(u.correoElectronico) = LOWER(:dato) " +
                                "OR LOWER(u.usuario) = LOWER(:dato)",
                        Usuario.class)
                .setParameter("dato", identificador)
                .getResultList();

        return resultados.isEmpty() ? null : resultados.get(0);
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}
