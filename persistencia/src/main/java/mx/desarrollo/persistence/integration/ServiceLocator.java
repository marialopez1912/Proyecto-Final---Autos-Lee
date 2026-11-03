package mx.desarrollo.persistence.integration;

import jakarta.persistence.EntityManager;
import mx.desarrollo.persistence.dao.UsuarioDAO;
import mx.desarrollo.persistence.dao.AdministradorDAO;
import mx.desarrollo.persistence.dao.AutoDAO;
import mx.desarrollo.persistence.persistence.HibernateUtil;

public class ServiceLocator {

    private static AdministradorDAO administradorDAO;
    private static UsuarioDAO usuarioDAO;
    private static AutoDAO autoDAO;

    private static EntityManager getEntityManager(){
        return HibernateUtil.getEntityManager();
    }

    public static AdministradorDAO getInstanceAdministradorDAO(){
        if(administradorDAO == null){
            administradorDAO = new AdministradorDAO(getEntityManager());
        }
        return administradorDAO;
    }

    public static UsuarioDAO getInstanceUsuarioDAO(){
        if(usuarioDAO == null){
            usuarioDAO = new UsuarioDAO(getEntityManager());
        }
        return usuarioDAO;
    }

    public static AutoDAO getInstanceAutoDAO(){
        if(autoDAO == null){
            autoDAO = new AutoDAO(getEntityManager());
        }
        return autoDAO;
    }
}
