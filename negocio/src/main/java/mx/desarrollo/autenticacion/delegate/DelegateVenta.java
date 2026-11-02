package mx.desarrollo.estadisticas.delegate;

import mx.desarrollo.estadisticas.dto.VentaReporte;
import mx.desarrollo.persistence.dao.CompraEstadisticasDAO;
import mx.desarrollo.persistence.persistence.HibernateUtil;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DelegateVenta {

    public List<VentaReporte> listar() {
        CompraEstadisticasDAO dao = new CompraEstadisticasDAO(HibernateUtil.getEntityManager());
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        List<VentaReporte> resultado = new ArrayList<>();
        for (Object[] f : dao.listarVentas()) {
            String vehiculo = f[1] + " " + f[2] + " " + f[3];
            String fecha = ((LocalDate) f[0]).format(formato);
            resultado.add(new VentaReporte(vehiculo, fecha, (BigDecimal) f[4]));
        }
        return resultado;
    }
}