package mx.desarrollo.estadisticas.delegate;

import mx.desarrollo.estadisticas.dto.TotalCategoria;
import mx.desarrollo.persistence.dao.GastoEstadisticasDAO;
import mx.desarrollo.persistence.persistence.HibernateUtil;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DelegateGasto {

    /** tipo = "marca" agrupa por marca; cualquier otro valor agrupa por tipo de gasto */
    public List<TotalCategoria> totales(String tipo) {
        GastoEstadisticasDAO dao = new GastoEstadisticasDAO(HibernateUtil.getEntityManager());
        List<Object[]> filas = "marca".equals(tipo) ? dao.totalesPorMarca() : dao.totalesPorTipo();

        List<TotalCategoria> resultado = new ArrayList<>();
        for (Object[] f : filas) {
            resultado.add(new TotalCategoria(String.valueOf(f[0]), new BigDecimal(f[1].toString())));
        }
        return resultado;
    }
}