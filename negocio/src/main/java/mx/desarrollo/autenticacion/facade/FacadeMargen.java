package mx.desarrollo.autenticacion.facade;

import mx.desarrollo.autenticacion.delegate.DelegateMargen;
import mx.desarrollo.estadisticas.dto.MargenAuto;

import java.util.List;

public class FacadeMargen {
    private final DelegateMargen delegate = new DelegateMargen();

    public List<MargenAuto> todos() {
        return delegate.todos();
    }
}