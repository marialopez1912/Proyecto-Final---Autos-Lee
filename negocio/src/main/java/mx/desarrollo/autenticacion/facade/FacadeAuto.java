package mx.desarrollo.autenticacion.facade;

import mx.desarrollo.autenticacion.delegate.DelegateAuto;
import mx.desarrollo.entity.Auto;

public class FacadeAuto {

    private final DelegateAuto delegateAuto;

    public FacadeAuto() {
        this.delegateAuto = new DelegateAuto();
    }

    public void saveAuto(Auto auto, Integer administradorId) {
        delegateAuto.saveAuto(auto, administradorId);
    }
}