package ui;

import helper.LoginHelper;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import mx.desarrollo.entity.Administrador;
import mx.desarrollo.entity.Usuario;

import java.io.IOException;
import java.io.Serializable;

@Named("loginUI")
@SessionScoped
public class LoginBeanUI implements Serializable {

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
        String correo = usuario.getCorreoElectronico();
        String contrasenia = usuario.getContrasenia();

        // 1) Primero buscamos en la tabla usuario
        Usuario us = loginHelper.Login(correo, contrasenia);
        if (us != null && us.getId() != null) {
            usuario = us;
            admin = false;
            redirigir("/usuario.xhtml");
            return;
        }

        // 2) Si no está, buscamos en la tabla administrador
        Administrador ad = loginHelper.LoginAdministrador(correo, contrasenia);
        if (ad != null && ad.getId() != null) {
            usuario = convertirAUsuario(ad);
            admin = true;
            redirigir("/inicio.xhtml");
            return;
        }

        // 3) No está en ninguna
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                FacesMessage.SEVERITY_WARN, "Usuario o contraseña incorrecta:", "Intente de nuevo"));
    }

    /**
     * Copia los datos del administrador a un Usuario para que el resto del
     * sistema (validarAdmin, validarSesion, pantallas) siga funcionando igual.
     */
    private Usuario convertirAUsuario(Administrador ad) {
        Usuario u = new Usuario();
        u.setId(ad.getId());
        u.setNombre(ad.getNombre());
        u.setApellidoPaterno(ad.getApellidoPaterno());
        u.setApellidoMaterno(ad.getApellidoMaterno());
        u.setCorreoElectronico(ad.getCorreoElectronico());
        u.setUsuario(ad.getUsuario());
        u.setContrasenia(ad.getContrasenia());
        return u;
    }

    private void redirigir(String destino) throws IOException {
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.getExternalContext().redirect(ctx.getExternalContext().getRequestContextPath() + destino);
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