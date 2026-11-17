package mx.desarrollo.persistence.dao;

import jakarta.persistence.EntityManager;
import mx.desarrollo.entity.AutoEquipamiento;
import mx.desarrollo.entity.AutoEquipamientoId;
import mx.desarrollo.persistence.persistence.AbstractDAO;

import java.util.List;

public class AutoEquipamientoDAO extends AbstractDAO<AutoEquipamiento> {
    private final EntityManager entityManager;

    public AutoEquipamientoDAO(EntityManager em) {
        super(AutoEquipamiento.class);
        this.entityManager = em;
    }

    public List<AutoEquipamiento> obtenerTodos() {
        return entityManager
                .createQuery("SELECT a FROM AutoEquipamiento a", AutoEquipamiento.class)
                .getResultList();
    }

    public List<AutoEquipamiento> obtenerPorAuto(Integer idAuto){
        return entityManager
                .createQuery("SELECT a FROM AutoEquipamiento a WHERE a.id.autoIdAutoSistema = :idAuto", AutoEquipamiento.class)
                .setParameter("idAuto", idAuto).getResultList();
    }

    public void guardar(Integer idAuto, List<String> elementos){
        execute(em -> {
            for(String texto : elementos){
                AutoEquipamientoId id = new AutoEquipamientoId();
                id.setEquipamiento(texto);
                id.setAutoIdAutoSistema(idAuto);

                AutoEquipamiento nuevo = new AutoEquipamiento();
                nuevo.setId(id);
                em.persist(nuevo);
            }
            return null;
        });
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}
