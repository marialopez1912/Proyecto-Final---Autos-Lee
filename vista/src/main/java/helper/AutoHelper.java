/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;


import mx.desarrollo.entity.Auto;
import mx.desarrollo.autenticacion.integration.ServiceFacadeLocator;

public class AutoHelper{

    public static void saveAuto(Auto auto) {
        ServiceFacadeLocator.getInstanceFacadeAuto().saveAuto(auto);
    }

}
