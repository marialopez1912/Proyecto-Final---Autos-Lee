package mx.desarrollo.persistence.integration;

import jakarta.persistence.EntityManager;
import mx.desarrollo.persistence.dao.AdministradorDAO;
import mx.desarrollo.persistence.dao.UsuarioDAO;
import mx.desarrollo.persistence.persistence.HibernateUtil;

/**
 * Cada llamada devuelve un DAO nuevo con su propio EntityManager.
 * Ya no se guardan DAOs en variables static: un EntityManager compartido
 * entre sesiones y consultas causa errores como "Not a navigable ResultSet"
 * y además devuelve datos viejos (cache de primer nivel).
 */
public class ServiceLocator {

    private static EntityManager getEntityManager() {
        return HibernateUtil.getEntityManager();
    }

    public static AdministradorDAO getInstanceAdministradorDAO() {
        return new AdministradorDAO(getEntityManager());
    }

    public static UsuarioDAO getInstanceUsuarioDAO() {
        return new UsuarioDAO(getEntityManager());
    }

}