package mx.desarrollo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Usuario", nullable = false)
    private java.lang.Integer id;

    @Size(max = 45)
    @NotNull
    @Column(name = "Nombre", nullable = false, length = 45)
    private java.lang.String nombre;

    @Size(max = 45)
    @NotNull
    @Column(name = "Apellido_Paterno", nullable = false, length = 45)
    private java.lang.String apellidoPaterno;

    @Size(max = 45)
    @Column(name = "Apellido_Materno", length = 45)
    private java.lang.String apellidoMaterno;

    @Size(max = 45)
    @NotNull
    @Column(name = "Correo_Electronico", nullable = false, length = 45)
    private java.lang.String correoElectronico;

    @Size(max = 255)
    @NotNull
    @Column(name = "Usuario", nullable = false)
    private java.lang.String usuario;

    @Size(max = 255)
    @NotNull
    @Column(name = "Contrasenia", nullable = false)
    private java.lang.String contrasenia;

    public java.lang.Integer getId() {
        return id;
    }

    public void setId(java.lang.Integer id) {
        this.id = id;
    }

    public java.lang.String getNombre() {
        return nombre;
    }

    public void setNombre(java.lang.String nombre) {
        this.nombre = nombre;
    }

    public java.lang.String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(java.lang.String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public java.lang.String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(java.lang.String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public java.lang.String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(java.lang.String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public java.lang.String getUsuario() {
        return usuario;
    }

    public void setUsuario(java.lang.String usuario) {
        this.usuario = usuario;
    }

    public java.lang.String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(java.lang.String contrasenia) {
        this.contrasenia = contrasenia;
    }

}