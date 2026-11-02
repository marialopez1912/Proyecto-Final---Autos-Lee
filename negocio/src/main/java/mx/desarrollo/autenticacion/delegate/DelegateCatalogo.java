package mx.desarrollo.estadisticas.delegate;

import mx.desarrollo.estadisticas.dto.AutoResumen;
import mx.desarrollo.estadisticas.dto.VentaAnual;
import mx.desarrollo.persistence.dao.CatalogoDAO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DelegateCatalogo {
    private final CatalogoDAO dao = new CatalogoDAO();

    public List<AutoResumen> autos() {
        List<AutoResumen> lista = new ArrayList<>();
        for (Object[] f : dao.autos()) {
            Integer anio = f[3] == null ? null : ((Number) f[3]).intValue();
            lista.add(new AutoResumen((String) f[0], (String) f[1], (String) f[2], anio, (BigDecimal) f[4]));
        }
        return lista;
    }

    public boolean actualizarPrecio(String vin, BigDecimal precio) {
        return dao.actualizarPrecio(vin, precio) > 0;
    }

    public List<VentaAnual> ventasAnuales() {
        List<VentaAnual> lista = new ArrayList<>();
        for (Object[] f : dao.ventasAnuales()) {
            lista.add(new VentaAnual(((Number) f[0]).intValue(), ((Number) f[1]).longValue(),
                    new BigDecimal(f[2].toString())));
        }
        return lista;
    }
}