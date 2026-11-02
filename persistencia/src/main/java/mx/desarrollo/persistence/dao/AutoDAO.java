package mx.desarrollo.persistence.dao;

import jakarta.persistence.EntityManager;
import mx.desarrollo.persistence.integration.*;
import mx.desarrollo.entity.*;
import mx.desarrollo.persistence.persistence.AbstractDAO;

import java.util.List;

public class AutoDAO extends AbstractDAO<Auto> {
    private final EntityManager entityManager;

    public AutoDAO(EntityManager em) {
        super(Auto.class);
        this.entityManager = em;
    }

    public List<Auto> obtenerTodos(){
        return entityManager
                .createQuery("SELECT a FROM Auto a", Auto.class)
                .getResultList();
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}
