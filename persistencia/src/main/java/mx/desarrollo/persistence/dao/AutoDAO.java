package mx.desarrollo.persistence.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import mx.desarrollo.entity.*;
import mx.desarrollo.persistence.persistence.AbstractDAO;

import java.util.List;

public class AutoDAO extends AbstractDAO<Auto> {

    private final EntityManager entityManager;

    public AutoDAO(EntityManager em) {
        super(Auto.class);
        this.entityManager = em;
    }

    public List<Auto> obtenerTodos() {
        return entityManager
                .createQuery("SELECT a FROM Auto a", Auto.class)
                .getResultList();
    }

    public void guardarAuto(Auto auto, Integer administradorId) {

        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            Administrador admin = entityManager.find(
                    Administrador.class,
                    administradorId
            );

            if (admin == null) {
                throw new IllegalStateException("No se encontró el administrador");
            }

            auto.setAdministradorIdAdministrador(admin);

            if (auto.getId() == null) {
                auto.setId(new AutoId());
            }

            auto.getId().setAdministradorIdAdministrador(administradorId);

            entityManager.persist(auto);

            transaction.commit();

        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}