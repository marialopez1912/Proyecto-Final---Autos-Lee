package ui;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import mx.desarrollo.autenticacion.integration.ServiceFacadeLocator;
import mx.desarrollo.entity.Administrador;

import java.util.List;

@Named("administradoresUI")
@RequestScoped
public class AdministradoresBean {

    private List<Administrador> administradores;

    @PostConstruct
    public void init() {
        administradores = ServiceFacadeLocator
                .getInstancefacadeAdministrador()
                .obtenerTodos();
    }

    public List<Administrador> getAdministradores() {
        return administradores;
    }
}