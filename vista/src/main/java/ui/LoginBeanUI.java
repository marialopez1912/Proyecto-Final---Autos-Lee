package ui;

import helper.LoginHelper;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import mx.desarrollo.entity.Usuario;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

@Named("loginUI")
@SessionScoped
public class LoginBeanUI implements Serializable {

    // TODO: reemplazar por la consulta a la tabla Administrador
    private static final List<String> CORREOS_ADMIN = List.of("admin@autoslee.com");

    private LoginHelper loginHelper;
    private Usuario usuario;
    private boolean admin;

    public LoginBeanUI() {
        loginHelper = new LoginHelper();
    }

    @PostConstruct
    public void init() {
        usuario = new Usuario();
    }

    public void login() throws IOException {
        Usuario us = loginHelper.Login(usuario.getCorreoElectronico(), usuario.getContrasenia());
        if (us != null && us.getId() != null) {
            usuario = us;
            admin = esAdministrador(us);
            String destino = admin ? "/inicio.xhtml" : "/usuario.xhtml";
            FacesContext.getCurrentInstance().getExternalContext().redirect(
                    FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath() + destino);
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_WARN, "Usuario o contraseña incorrecta:", "Intente de nuevo"));
        }
    }

    private boolean esAdministrador(Usuario us) {
        String correo = us.getCorreoElectronico();
        return correo != null && CORREOS_ADMIN.stream().anyMatch(c -> c.equalsIgnoreCase(correo));
    }

    /** Para las páginas de admin: null si es admin, o la redirección que corresponda. */
    public String validarAdmin() {
        if (usuario == null || usuario.getId() == null) return "login?faces-redirect=true";
        if (!admin) return "usuario?faces-redirect=true";
        return null;
    }

    /** Para las páginas de usuario: solo exige sesión. */
    public String validarSesion() {
        if (usuario == null || usuario.getId() == null) return "login?faces-redirect=true";
        return null;
    }

    public boolean isAdmin() { return admin; }
    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
}