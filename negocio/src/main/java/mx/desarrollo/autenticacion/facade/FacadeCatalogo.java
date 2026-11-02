package mx.desarrollo.estadisticas.facade;

import mx.desarrollo.estadisticas.delegate.DelegateCatalogo;
import mx.desarrollo.estadisticas.dto.AutoResumen;
import mx.desarrollo.estadisticas.dto.VentaAnual;

import java.math.BigDecimal;
import java.util.List;

public class FacadeCatalogo {
    private final DelegateCatalogo delegate = new DelegateCatalogo();

    public List<AutoResumen> autos() { return delegate.autos(); }
    public boolean actualizarPrecio(String vin, BigDecimal precio) { return delegate.actualizarPrecio(vin, precio); }
    public List<VentaAnual> ventasAnuales() { return delegate.ventasAnuales(); }
}