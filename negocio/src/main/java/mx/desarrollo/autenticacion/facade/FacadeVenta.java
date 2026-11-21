package mx.desarrollo.autenticacion.facade;


import mx.desarrollo.autenticacion.delegate.DelegateVenta;
import mx.desarrollo.estadisticas.dto.VentaReporte;

import java.util.List;

public class FacadeVenta {
    private final DelegateVenta delegate = new DelegateVenta();

    public List<VentaReporte> listar() {
        return delegate.listar();
    }

    public List<VentaReporte> listarFiltrado(String marca, String modelo) {
        return delegate.listarFiltrado(marca, modelo);
    }

    public List<String> marcas() {
        return delegate.marcas();
    }

    public List<String> modelos(String marca) {
        return delegate.modelos(marca);
    }
}