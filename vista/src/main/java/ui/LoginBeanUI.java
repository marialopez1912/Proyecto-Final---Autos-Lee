package ui;

import helper.LoginHelper;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

import mx.desarrollo.entity.Usuario;
import mx.desarrollo.entity.Administrador;

import java.io.IOException;
import java.io.Serializable;

@Named("loginUI")
@SessionScoped
public class LoginBeanUI implements Serializable {

    private LoginHelper loginHelper;
    private Usuario usuario;
    private Administrador administrador;

    public LoginBeanUI() {
        loginHelper = new LoginHelper();
    }

    @PostConstruct
    public void init() {
        usuario = new Usuario();
        administrador = null;
    }

    public void login() throws IOException {

        String identificador = usuario.getCorreoElectronico();
        String password = usuario.getContrasenia();

        Administrador admin = loginHelper.loginAdministrador(
                identificador, password);

        if (admin != null) {
            administrador = admin;

            FacesContext.getCurrentInstance().getExternalContext().redirect(
                    FacesContext.getCurrentInstance().getExternalContext()
                            .getRequestContextPath() + "/panel.xhtml");

            return;
        }
        Usuario us = loginHelper.Login(identificador, password);

        if (us != null) {
            usuario = us;

            FacesContext.getCurrentInstance().getExternalContext().redirect(
                    FacesContext.getCurrentInstance().getExternalContext()
                            .getRequestContextPath() + "/index.xhtml");

        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(
                            FacesMessage.SEVERITY_WARN,
                            "Usuario o contraseña incorrecta",
                            "Intente de nuevo"));
        }
    }    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }
}