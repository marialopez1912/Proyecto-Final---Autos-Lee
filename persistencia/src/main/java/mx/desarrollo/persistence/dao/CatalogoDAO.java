package mx.desarrollo.persistence.dao;

import jakarta.persistence.EntityManager;
import mx.desarrollo.persistence.persistence.HibernateUtil;

import java.math.BigDecimal;
import java.util.List;

public class CatalogoDAO {

    public List<Object[]> autos() {
        EntityManager em = HibernateUtil.getEntityManager();
        try {
            return em.createQuery(
                    "SELECT a.vin, a.marca, a.modelo, a.anio, a.precioVenta FROM Auto a ORDER BY a.marca, a.modelo",
                    Object[].class).getResultList();
        } finally {
            em.close();
        }
    }

    public int actualizarPrecio(String vin, BigDecimal precio) {
        EntityManager em = HibernateUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            int n = em.createQuery("UPDATE Auto a SET a.precioVenta = :p WHERE a.vin = :v")
                    .setParameter("p", precio)
                    .setParameter("v", vin)
                    .executeUpdate();
            em.getTransaction().commit();
            return n;
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public List<Object[]> ventasAnuales() {
        EntityManager em = HibernateUtil.getEntityManager();
        try {
            return em.createQuery(
                    "SELECT YEAR(c.fecha), COUNT(c), SUM(c.precioFinal) FROM Compra c " +
                            "GROUP BY YEAR(c.fecha) ORDER BY YEAR(c.fecha)",
                    Object[].class).getResultList();
        } finally {
            em.close();
        }
    }
}