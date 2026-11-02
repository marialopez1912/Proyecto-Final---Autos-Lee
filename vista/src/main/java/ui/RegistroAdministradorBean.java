package ui;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import mx.desarrollo.entity.Administrador;
import mx.desarrollo.autenticacion.integration.ServiceFacadeLocator;

@Named("registroAdminUI")
@RequestScoped
public class RegistroAdministradorBean {

    private Administrador administrador;
    private String confirmarContrasenia;

    @PostConstruct
    public void init() {
        administrador = new Administrador();
        confirmarContrasenia = "";
    }

    public void registrar() {

        FacesContext context = FacesContext.getCurrentInstance();

        Administrador existenteUsuario = ServiceFacadeLocator
                .getInstanceFacadeAdministrador()
                .buscarPorCorreoOUsuario(administrador.getUsuario());

        if (existenteUsuario != null) {
            context.addMessage(null,
                    new FacesMessage(
                            FacesMessage.SEVERITY_ERROR,
                            "Error",
                            "Ese nombre de usuario ya está registrado."));
            return;
        }

        Administrador existenteCorreo = ServiceFacadeLocator
                .getInstanceFacadeAdministrador()
                .buscarPorCorreoOUsuario(administrador.getCorreoElectronico());

        if (existenteCorreo != null) {
            context.addMessage(null,
                    new FacesMessage(
                            FacesMessage.SEVERITY_ERROR,
                            "Error",
                            "Ese correo electrónico ya está registrado."));
            return;
        }


        try {
            ServiceFacadeLocator
                    .getInstanceFacadeAdministrador()
                    .guardarAdministrador(administrador);

            context.addMessage(null,
                    new FacesMessage(
                            FacesMessage.SEVERITY_INFO,
                            "Registro exitoso",
                            "El administrador se registró correctamente."));

            administrador = new Administrador();
            confirmarContrasenia = "";

        } catch (Exception e) {
            context.addMessage(null,
                    new FacesMessage(
                            FacesMessage.SEVERITY_ERROR,
                            "Error",
                            "No fue posible registrar al administrador."));
        }
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public String getConfirmarContrasenia() {
        return confirmarContrasenia;
    }

    public void setConfirmarContrasenia(String confirmarContrasenia) {
        this.confirmarContrasenia = confirmarContrasenia;
    }
}