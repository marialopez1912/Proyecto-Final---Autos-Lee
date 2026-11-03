package mx.desarrollo.autenticacion.facade;

import mx.desarrollo.autenticacion.delegate.DelegateAuto;
import mx.desarrollo.entity.Auto;

import java.util.List;

public class FacadeAuto {

    private final DelegateAuto delegateAuto;

    public FacadeAuto() {
        this.delegateAuto = new DelegateAuto();
    }

    public void saveAuto(Auto auto, Integer administradorId) {
        delegateAuto.saveAuto(auto, administradorId);
    }

    public List<Auto> obtenerTodos() {
        return delegateAuto.obtenerTodos();
    }
}