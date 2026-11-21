package mx.desarrollo.autenticacion.delegate;

import mx.desarrollo.estadisticas.dto.VentaReporte;
import mx.desarrollo.persistence.dao.VentaFiltroDAO;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DelegateVenta {
    private final VentaFiltroDAO dao = new VentaFiltroDAO();

    public List<VentaReporte> listar() {
        return listarFiltrado(null, null);
    }

    public List<VentaReporte> listarFiltrado(String marca, String modelo) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        List<VentaReporte> resultado = new ArrayList<>();
        for (Object[] f : dao.ventas(marca, modelo)) {
            resultado.add(new VentaReporte(f[1] + " " + f[2] + " " + f[3],
                    ((LocalDate) f[0]).format(formato), (BigDecimal) f[4]));
        }
        return resultado;
    }

    public List<String> marcas() {
        return dao.marcas();
    }

    public List<String> modelos(String marca) {
        return dao.modelos(marca);
    }
}