    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import static practica1.Miembro.limiteDinero2;

/**
 *
 * @author media
 */
public class illegalAmountOfMoneyException extends Exception {

    public illegalAmountOfMoneyException(String menuda_excepcion) {
     System.out.println("El importe total de sus motos ascenderá a mas de el limite de euros. ");
    }
    
}
