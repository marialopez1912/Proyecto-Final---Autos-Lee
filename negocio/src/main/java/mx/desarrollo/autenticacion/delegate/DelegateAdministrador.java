package mx.desarrollo.autenticacion.delegate;

import mx.desarrollo.entity.Administrador;
import mx.desarrollo.persistence.integration.ServiceLocator;

import java.util.List;

public class DelegateAdministrador {

    /**
     * Busca un administrador por correo y contraseña.
     * Si no lo encuentra, regresa un Administrador vacío (id == null),
     * igual que hace DelegateUsuario.
     */
    public Administrador login(String password, String correo) {
        Administrador administrador = new Administrador();
        if (password == null || correo == null) {
            return administrador;
        }

        List<Administrador> administradores = ServiceLocator.getInstanceAdministradorDAO().findAll();

        for (Administrador ad : administradores) {
            if (ad.getContrasenia() != null
                    && ad.getCorreoElectronico() != null
                    && ad.getContrasenia().trim().equalsIgnoreCase(password.trim())
                    && ad.getCorreoElectronico().trim().equalsIgnoreCase(correo.trim())) {
                administrador = ad;
            }
        }
        return administrador;
    }

    public void saveAdministrador(Administrador administrador) {
        ServiceLocator.getInstanceAdministradorDAO().save(administrador);
    }

}