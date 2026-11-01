package mx.desarrollo.persistence.dao;

import jakarta.persistence.EntityManager;
import java.util.List;

public class CompraEstadisticasDAO {
    private final EntityManager em;

    public CompraEstadisticasDAO(EntityManager em) {
        this.em = em;
    }

    public List<Object[]> listarVentas() {
        return em.createQuery(
                "SELECT c.fecha, a.marca, a.modelo, a.anio, c.precioFinal " +
                        "FROM Compra c JOIN c.auto a ORDER BY c.fecha DESC",
                Object[].class).getResultList();
    }
}