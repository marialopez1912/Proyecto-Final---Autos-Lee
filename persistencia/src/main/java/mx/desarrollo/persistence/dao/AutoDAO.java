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

    public List<Auto> obtenerDisponibles(){
        return entityManager
                .createQuery("SELECT a FROM Auto a WHERE a.disponible = true", Auto.class)
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

    public void darDeBajaAuto(String VIN){
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            Auto au = buscarPorVIN(VIN);

            if(au == null){
                throw new IllegalStateException("No se ha encontrado el auto");
            }else{
                if (au.getDisponible() == false) {
                    throw new IllegalStateException("El auto esta dado de baja o se ha vendido");
                }else{
                    au.setDisponible(false);

                }
                transaction.commit();
            }


        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }

    public Auto buscarPorVIN(String VIN){
        List<Auto> resultados = entityManager.createQuery(
                        "SELECT a FROM Auto a " +
                                "WHERE LOWER(a.vin) = LOWER(:dato) ",
                        Auto.class)
                .setParameter("dato", VIN)
                .getResultList();

        return resultados.isEmpty() ? null : resultados.get(0);
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}