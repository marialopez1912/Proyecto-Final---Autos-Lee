/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.persistence.integration;

import jakarta.persistence.EntityManager;
import mx.desarrollo.persistence.dao.UsuarioDAO;
import mx.desarrollo.persistence.dao.AdministradorDAO;
import mx.desarrollo.persistence.persistence.HibernateUtil;


/**
 *
 * @author total
 */
public class ServiceLocator {

    private static AdministradorDAO administradorDAO;
    private static UsuarioDAO usuarioDAO;

    private static EntityManager getEntityManager(){
        return HibernateUtil.getEntityManager();
    }

    /**
     * se crea la instancia para alumno DAO si esta no existe
     */
    public static AdministradorDAO getInstanceAdministradorDAO(){
        if(administradorDAO == null){
            administradorDAO = new AdministradorDAO(getEntityManager());
            return administradorDAO;
        } else{
            return administradorDAO;
        }
    }
    /**
     * se crea la instancia de usuarioDAO si esta no existe
     */
    public static UsuarioDAO getInstanceUsuarioDAO(){
        if(usuarioDAO == null){
            usuarioDAO = new UsuarioDAO(getEntityManager());
            return usuarioDAO;
        } else{
            return usuarioDAO;
        }
    }

}