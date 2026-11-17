package mx.desarrollo.persistence.integration;

import jakarta.persistence.EntityManager;
import mx.desarrollo.persistence.dao.*;
import mx.desarrollo.persistence.persistence.HibernateUtil;

public class ServiceLocator {

    private static AdministradorDAO administradorDAO;
    private static UsuarioDAO usuarioDAO;
    private static AutoDAO autoDAO;
    private static AutoEquipamientoDAO autoEquipamientoDAO;
    private static AutoSeguridadDAO autoSeguridadDAO;

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

    public static AutoEquipamientoDAO getInstanceAutoEquipamientoDAO(){
        if (autoEquipamientoDAO == null){
            autoEquipamientoDAO = new AutoEquipamientoDAO(getEntityManager());

        }
        return autoEquipamientoDAO;
    }
/*
    public static AutoSeguridadDAO getInst{
        if(autoSeguridadDAO == null){
            autoSeguridadDAO == new AutoSeguridadDAO((getEntityManager());
        }
        return autoSeguridadDAO;
    }*/
}
