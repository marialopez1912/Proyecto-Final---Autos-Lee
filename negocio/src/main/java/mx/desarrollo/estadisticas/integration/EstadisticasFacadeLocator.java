package mx.desarrollo.estadisticas.integration;

import mx.desarrollo.autenticacion.facade.FacadeCatalogo;
import mx.desarrollo.autenticacion.facade.FacadeGasto;
import mx.desarrollo.autenticacion.facade.FacadeMargen;
import mx.desarrollo.autenticacion.facade.FacadeVenta;

public class EstadisticasFacadeLocator {
    private static FacadeGasto facadeGasto;
    private static FacadeVenta facadeVenta;
    private static FacadeCatalogo facadeCatalogo;
    private static FacadeMargen facadeMargen;

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

    public static FacadeMargen getInstanceFacadeMargen() {
        if (facadeMargen == null) facadeMargen = new FacadeMargen();
        return facadeMargen;
    }
}