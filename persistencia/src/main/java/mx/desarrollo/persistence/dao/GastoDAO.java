package mx.desarrollo.persistence.dao;

import jakarta.persistence.EntityManager;
import mx.desarrollo.entity.Gasto;
import mx.desarrollo.persistence.persistence.AbstractDAO;

import java.util.List;

public class GastoDAO extends AbstractDAO<Gasto> {
    private final EntityManager entityManager;

    public GastoDAO(EntityManager em) {
        super(Gasto.class);
        this.entityManager = em;
    }

    public List<Gasto> obtenerTodos() {
        return entityManager
                .createQuery("SELECT a FROM Gasto a", Gasto.class)
                .getResultList();
    }

    public List<Gasto> obtenerPorAuto(Integer idAuto){
        return entityManager
                .createQuery("SELECT a FROM Gasto a WHERE a.id.autoIdAutoSistema = :idAuto", Gasto.class)
                .setParameter("idAuto", idAuto).getResultList();
    }

    public void guardar(Integer idAuto, String descripcion, String tipo, Integer monto){
        execute(em -> {
            /*for(String texto : elementos){
                GastoId id = new GastoId();
                id.setGasto(texto);
                id.setIdGasto(idAuto);

                Gasto nuevo = new Gasto();
                nuevo.setId(id);
                em.persist(nuevo);
            }*/
            return null;
        });
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}

