package mx.desarrollo.autenticacion.delegate;

import mx.desarrollo.estadisticas.dto.MargenAuto;
import mx.desarrollo.persistence.dao.MargenDAO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DelegateMargen {
    private final MargenDAO dao = new MargenDAO();

    public List<MargenAuto> todos() {
        Map<String, BigDecimal> gastos = new HashMap<>();
        for (Object[] f : dao.gastosPorAuto()) {
            gastos.put((String) f[0], new BigDecimal(f[1].toString()));
        }
        List<MargenAuto> lista = new ArrayList<>();
        for (Object[] f : dao.autos()) {
            String vin = (String) f[0];
            lista.add(new MargenAuto(vin, f[1] + " " + f[2] + " " + f[3],
                    (BigDecimal) f[4], (BigDecimal) f[5], gastos.getOrDefault(vin, BigDecimal.ZERO)));
        }
        return lista;
    }
}