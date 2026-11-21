package mx.desarrollo.autenticacion.facade;

import mx.desarrollo.autenticacion.delegate.DelegateGasto;
import mx.desarrollo.estadisticas.dto.TotalCategoria;
import java.util.List;

public class FacadeGasto {
    private final DelegateGasto delegate = new DelegateGasto();

    public List<TotalCategoria> totales(String tipo) {
        return delegate.totales(tipo);
    }
}