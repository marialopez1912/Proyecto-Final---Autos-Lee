package helper;

import mx.desarrollo.estadisticas.dto.TotalCategoria;
import mx.desarrollo.estadisticas.dto.VentaReporte;
import mx.desarrollo.estadisticas.integration.EstadisticasFacadeLocator;

import java.io.Serializable;
import java.util.List;

public class EstadisticasHelper implements Serializable {

    public List<TotalCategoria> totalesGastos(String tipo) {
        return EstadisticasFacadeLocator.getInstanceFacadeGasto().totales(tipo);
    }

    public List<VentaReporte> ventas() {
        return EstadisticasFacadeLocator.getInstanceFacadeVenta().listar();
    }
}