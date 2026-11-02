package helper;

import mx.desarrollo.estadisticas.dto.AutoResumen;
import mx.desarrollo.estadisticas.dto.TotalCategoria;
import mx.desarrollo.estadisticas.dto.VentaAnual;
import mx.desarrollo.estadisticas.dto.VentaReporte;
import mx.desarrollo.estadisticas.integration.EstadisticasFacadeLocator;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class EstadisticasHelper implements Serializable {

    public List<TotalCategoria> totalesGastos(String tipo) {
        return EstadisticasFacadeLocator.getInstanceFacadeGasto().totales(tipo);
    }

    public List<VentaReporte> ventas() {
        return EstadisticasFacadeLocator.getInstanceFacadeVenta().listar();
    }

    public List<AutoResumen> autos() {
        return EstadisticasFacadeLocator.getInstanceFacadeCatalogo().autos();
    }

    public boolean actualizarPrecio(String vin, BigDecimal precio) {
        return EstadisticasFacadeLocator.getInstanceFacadeCatalogo().actualizarPrecio(vin, precio);
    }

    public List<VentaAnual> ventasAnuales() {
        return EstadisticasFacadeLocator.getInstanceFacadeCatalogo().ventasAnuales();
    }
}