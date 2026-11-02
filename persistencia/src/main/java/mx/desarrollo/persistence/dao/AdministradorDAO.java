package mx.desarrollo.persistence.dao;

import jakarta.persistence.EntityManager;
import mx.desarrollo.entity.Administrador;
import mx.desarrollo.persistence.persistence.AbstractDAO;

import java.util.List;

public class AdministradorDAO extends AbstractDAO<Administrador> {

    private final EntityManager entityManager;

    public AdministradorDAO(EntityManager em) {
        super(Administrador.class);
        this.entityManager = em;
    }

    public List<Administrador> obtenerTodos() {
        return entityManager
                .createQuery("SELECT a FROM Administrador a", Administrador.class)
                .getResultList();
    }

    public Administrador buscarPorUsuario(String usuario) {
        List<Administrador> resultados = entityManager
                .createQuery(
                        "SELECT a FROM Administrador a WHERE a.usuario = :usuario",
                        Administrador.class)
                .setParameter("usuario", usuario)
                .getResultList();

        return resultados.isEmpty() ? null : resultados.get(0);
    }

    public Administrador buscarPorCorreoOUsuario(String identificador) {
        List<Administrador> resultados = entityManager.createQuery(
                        "SELECT a FROM Administrador a " +
                                "WHERE LOWER(a.correoElectronico) = LOWER(:dato) " +
                                "OR LOWER(a.usuario) = LOWER(:dato)",
                        Administrador.class)
                .setParameter("dato", identificador)
                .getResultList();

        return resultados.isEmpty() ? null : resultados.get(0);
    }

    public boolean esPrincipal(Integer id) {
        Long cantidad = entityManager.createQuery(
                        "SELECT COUNT(a) FROM Administrador a " +
                                "WHERE a.id = :id AND a.esPrincipal = true",
                        Long.class)
                .setParameter("id", id)
                .getSingleResult();

        return cantidad > 0;
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}
