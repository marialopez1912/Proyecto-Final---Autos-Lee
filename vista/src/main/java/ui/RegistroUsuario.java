package ui;

import java.io.Serializable;
import java.util.regex.Pattern;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;


import mx.desarrollo.autenticacion.integration.ServiceFacadeLocator;
import mx.desarrollo.entity.Usuario;

@Named("registroUsuario")
@RequestScoped
public class RegistroUsuario implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String usuario;
    private String correoElectronico;
    private String contrasenia;

    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";

    public RegistroUsuario() {
    }

    public String registrar() {
        FacesContext context = FacesContext.getCurrentInstance();

        // 1. Validaciones
        if (esVacio(nombre) || esVacio(apellidoPaterno) || esVacio(usuario) ||
                esVacio(correoElectronico) || esVacio(contrasenia)) {

            context.addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_ERROR,
                    "Campos incompletos",
                    "Por favor completa todos los campos obligatorios."
            ));
            return null;
        }

        if (!Pattern.matches(EMAIL_REGEX, correoElectronico.trim())) {
            context.addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_ERROR,
                    "Correo no válido",
                    "Ingresa una dirección de correo válida."
            ));
            return null;
        }
        try {
            Usuario nuevoUsuario = new Usuario();
            nuevoUsuario.setNombre(this.nombre.trim());
            nuevoUsuario.setApellidoPaterno(this.apellidoPaterno.trim());
            nuevoUsuario.setApellidoMaterno(this.apellidoMaterno != null ? this.apellidoMaterno.trim() : "");
            nuevoUsuario.setUsuario(this.usuario.trim());
            nuevoUsuario.setCorreoElectronico(this.correoElectronico.trim());
            nuevoUsuario.setContrasenia(this.contrasenia);

            ServiceFacadeLocator.getInstanceFacadeUsuario().saveUsuario(nuevoUsuario);

            context.addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_INFO,
                    "Registro exitoso  ",
                    "Tu cuenta ha sido creada correctamente."
            ));
            context.getExternalContext().getFlash().setKeepMessages(true);

            return "login?faces-redirect=true";

        } catch (Exception e) {
            e.printStackTrace();
            context.addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_ERROR,
                    "Error de base de datos",
                    "No se pudo completar el registro: " + e.getMessage()
            ));
            return null;
        }
    }

    private boolean esVacio(String str) {
        return str == null || str.trim().isEmpty();
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellidoPaterno() { return apellidoPaterno; }
    public void setApellidoPaterno(String apellidoPaterno) { this.apellidoPaterno = apellidoPaterno; }
    public String getApellidoMaterno() { return apellidoMaterno; }
    public void setApellidoMaterno(String apellidoMaterno) { this.apellidoMaterno = apellidoMaterno; }
    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }
    public String getCorreoElectronico() { return correoElectronico; }
    public void setCorreoElectronico(String correoElectronico) { this.correoElectronico = correoElectronico; }
    public String getContrasenia() { return contrasenia; }
    public void setContrasenia(String contrasenia) { this.contrasenia = contrasenia; }
}