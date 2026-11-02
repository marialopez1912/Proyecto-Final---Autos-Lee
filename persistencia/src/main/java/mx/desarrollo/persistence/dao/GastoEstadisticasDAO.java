package mx.desarrollo.persistence.dao;

import jakarta.persistence.EntityManager;
import java.util.List;

public class GastoEstadisticasDAO {
    private final EntityManager em;

    public GastoEstadisticasDAO(EntityManager em) {
        this.em = em;
    }

    public List<Object[]> totalesPorTipo() {
        return em.createQuery(
                "SELECT g.tipo, SUM(g.monto) FROM Gasto g GROUP BY g.tipo",
                Object[].class).getResultList();
    }

    public List<Object[]> totalesPorMarca() {
        return em.createQuery(
                "SELECT a.marca, SUM(g.monto) FROM Gasto g JOIN g.auto a GROUP BY a.marca",
                Object[].class).getResultList();
    }
}