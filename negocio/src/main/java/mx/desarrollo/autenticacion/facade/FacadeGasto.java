package mx.desarrollo.estadisticas.facade;

import mx.desarrollo.estadisticas.delegate.DelegateGasto;
import mx.desarrollo.estadisticas.dto.TotalCategoria;
import java.util.List;

public class FacadeGasto {
    private final DelegateGasto delegate = new DelegateGasto();

    public List<TotalCategoria> totales(String tipo) {
        return delegate.totales(tipo);
    }
}