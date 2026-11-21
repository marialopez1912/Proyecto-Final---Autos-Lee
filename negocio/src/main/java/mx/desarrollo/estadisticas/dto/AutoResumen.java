package mx.desarrollo.estadisticas.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class AutoResumen implements Serializable {
    private final String vin, marca, modelo;
    private final Integer anio;
    private final BigDecimal precio;

    public AutoResumen(String vin, String marca, String modelo, Integer anio, BigDecimal precio) {
        this.vin = vin; this.marca = marca; this.modelo = modelo; this.anio = anio; this.precio = precio;
    }
    public String getVin() { return vin; }
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public Integer getAnio() { return anio; }
    public BigDecimal getPrecio() { return precio; }
}