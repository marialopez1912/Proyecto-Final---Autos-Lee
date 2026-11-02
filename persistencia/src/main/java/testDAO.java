import mx.desarrollo.persistence.dao.*;
import mx.desarrollo.entity.*;
import mx.desarrollo.persistence.persistence.HibernateUtil;


public class testDAO {

    public static void main(String[] args) {
        AdministradorDAO administradorDAO = new AdministradorDAO(HibernateUtil.getEntityManager());
        AutoDAO autoDAO = new AutoDAO(HibernateUtil.getEntityManager());


        for (Administrador administrador : administradorDAO.findAll()) {
            System.out.println(administrador + "|| id [" + administrador.getId()+ "]"
                + "|| nombre [" + administrador.getNombre() + "]");
        }
/*
        for(Auto auto : autoDAO.findAll()){
            System.out.println(auto + "|| id [" + auto.getId()+ "]");
        }*/
    }
}