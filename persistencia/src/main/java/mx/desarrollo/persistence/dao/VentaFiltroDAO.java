package mx.desarrollo.persistence.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import mx.desarrollo.persistence.persistence.HibernateUtil;

import java.util.List;

public class VentaFiltroDAO {

    public List<String> marcas() {
        EntityManager em = HibernateUtil.getEntityManager();
        try {
            return em.createQuery("SELECT DISTINCT a.marca FROM Auto a ORDER BY a.marca", String.class).getResultList();
        } finally {
            em.close();
        }
    }

    public List<String> modelos(String marca) {
        EntityManager em = HibernateUtil.getEntityManager();
        try {
            boolean hayMarca = marca != null && !marca.isBlank();
            TypedQuery<String> q = em.createQuery("SELECT DISTINCT a.modelo FROM Auto a "
                    + (hayMarca ? "WHERE a.marca = :marca " : "") + "ORDER BY a.modelo", String.class);
            if (hayMarca) q.setParameter("marca", marca);
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public List<Object[]> ventas(String marca, String modelo) {
        EntityManager em = HibernateUtil.getEntityManager();
        try {
            boolean hayMarca = marca != null && !marca.isBlank();
            boolean hayModelo = modelo != null && !modelo.isBlank();
            StringBuilder jpql = new StringBuilder(
                    "SELECT c.fecha, a.marca, a.modelo, a.anio, c.precioFinal FROM Compra c JOIN c.auto a WHERE 1 = 1");
            if (hayMarca) jpql.append(" AND a.marca = :marca");
            if (hayModelo) jpql.append(" AND a.modelo = :modelo");
            jpql.append(" ORDER BY c.fecha DESC");
            TypedQuery<Object[]> q = em.createQuery(jpql.toString(), Object[].class);
            if (hayMarca) q.setParameter("marca", marca);
            if (hayModelo) q.setParameter("modelo", modelo);
            return q.getResultList();
        } finally {
            em.close();
        }
    }
}