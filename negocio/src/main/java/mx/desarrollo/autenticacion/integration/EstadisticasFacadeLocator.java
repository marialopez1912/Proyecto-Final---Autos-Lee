package mx.desarrollo.estadisticas.integration;

import mx.desarrollo.estadisticas.facade.FacadeCatalogo;
import mx.desarrollo.estadisticas.facade.FacadeGasto;
import mx.desarrollo.estadisticas.facade.FacadeVenta;

public class EstadisticasFacadeLocator {
    private static FacadeGasto facadeGasto;
    private static FacadeVenta facadeVenta;
    private static FacadeCatalogo facadeCatalogo;

    public static FacadeGasto getInstanceFacadeGasto() {
        if (facadeGasto == null) facadeGasto = new FacadeGasto();
        return facadeGasto;
    }

    public static FacadeVenta getInstanceFacadeVenta() {
        if (facadeVenta == null) facadeVenta = new FacadeVenta();
        return facadeVenta;
    }

    public static FacadeCatalogo getInstanceFacadeCatalogo() {
        if (facadeCatalogo == null) facadeCatalogo = new FacadeCatalogo();
        return facadeCatalogo;
    }
}