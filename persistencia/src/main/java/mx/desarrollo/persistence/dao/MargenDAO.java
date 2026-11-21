package mx.desarrollo.persistence.dao;

import jakarta.persistence.EntityManager;
import mx.desarrollo.persistence.persistence.HibernateUtil;

import java.util.List;

public class MargenDAO {

    public List<Object[]> autos() {
        EntityManager em = HibernateUtil.getEntityManager();
        try {
            return em.createQuery("SELECT a.vin, a.marca, a.modelo, a.anio, a.precioVenta, a.precioCompra "
                    + "FROM Auto a ORDER BY a.marca, a.modelo", Object[].class).getResultList();
        } finally {
            em.close();
        }
    }

    public List<Object[]> gastosPorAuto() {
        EntityManager em = HibernateUtil.getEntityManager();
        try {
            return em.createQuery("SELECT g.auto.vin, SUM(g.monto) FROM Gasto g GROUP BY g.auto.vin",
                    Object[].class).getResultList();
        } finally {
            em.close();
        }
    }
}