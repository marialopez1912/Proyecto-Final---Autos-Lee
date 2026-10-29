package mx.desarrollo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "administrador", schema = "autos_lee")
public class Administrador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Administrador", nullable = false)
    private Integer id;

    @Size(max = 45)
    @NotNull
    @Column(name = "Nombre", nullable = false, length = 45)
    private String nombre;

    @Size(max = 45)
    @NotNull
    @Column(name = "Apellido_Paterno", nullable = false, length = 45)
    private String apellidoPaterno;

    @Size(max = 45)
    @Column(name = "Apellido_Materno", length = 45)
    private String apellidoMaterno;

    @Size(max = 45)
    @NotNull
    @Column(name = "Correo_Electronico", nullable = false, length = 45)
    private String correoElectronico;

    @Size(max = 45)
    @NotNull
    @Column(name = "Numero_Telefonico", nullable = false, length = 45)
    private String numeroTelefonico;

    @Size(max = 255)
    @NotNull
    @Column(name = "Usuario", nullable = false)
    private String usuario;

    @Size(max = 255)
    @NotNull
    @Column(name = "Contrasenia", nullable = false)
    private String contrasenia;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getNumeroTelefonico() {
        return numeroTelefonico;
    }

    public void setNumeroTelefonico(String numeroTelefonico) {
        this.numeroTelefonico = numeroTelefonico;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

}