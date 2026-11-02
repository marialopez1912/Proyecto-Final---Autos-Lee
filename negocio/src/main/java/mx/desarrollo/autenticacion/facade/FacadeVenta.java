package mx.desarrollo.estadisticas.facade;

import mx.desarrollo.estadisticas.delegate.DelegateVenta;
import mx.desarrollo.estadisticas.dto.VentaReporte;
import java.util.List;

public class FacadeVenta {
    private final DelegateVenta delegate = new DelegateVenta();

    public List<VentaReporte> listar() {
        return delegate.listar();
    }
}