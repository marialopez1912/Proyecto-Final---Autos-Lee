package mx.desarrollo.persistence.dao;

import jakarta.persistence.EntityManager;
import mx.desarrollo.entity.AutoSeguridad;
import mx.desarrollo.entity.AutoSeguridadId;
import mx.desarrollo.persistence.persistence.AbstractDAO;

import java.util.List;

public class AutoSeguridadDAO extends AbstractDAO<AutoSeguridad> {
    private final EntityManager entityManager;

    public AutoSeguridadDAO(EntityManager em) {
        super(AutoSeguridad.class);
        this.entityManager = em;
    }

    public List<AutoSeguridad> obtenerTodos() {
        return entityManager
                .createQuery("SELECT a FROM AutoSeguridad a", AutoSeguridad.class)
                .getResultList();
    }

    public List<AutoSeguridad> obtenerPorAuto(Integer idAuto){
        return entityManager
                .createQuery("SELECT a FROM AutoSeguridad a WHERE a.id.autoIdAutoSistema = :idAuto", AutoSeguridad.class)
                .setParameter("idAuto", idAuto).getResultList();
    }

    public void guardar(Integer idAuto, List<String> elementos){
        execute(em -> {
            for(String texto : elementos){
                AutoSeguridadId id = new AutoSeguridadId();
                id.setSistemaSeguridad(texto);
                id.setAutoIdAutoSistema(idAuto);

                AutoSeguridad nuevo = new AutoSeguridad();
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
