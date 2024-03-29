/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import java.util.ArrayList;
import java.util.Date;
import  java.lang.Exception;
/**
 *
 * @author alumno
 */
public class Cesion extends ClasePrincipal {

    
    Moto moto_implicada;
    Miembro antiguo, nuevo;
    Date fecha;
    ArrayList<Cesion> registro = new ArrayList<>();
    static float limiteDinero2 = 6000;


    /**
     *
     * @param moto_implicada
     * @param antiguo
     * @param nuevo
     * @param fecha
     * @throws illegalAmountOfMoneyException
     */
    public Cesion(Moto moto_implicada, Miembro antiguo, Miembro nuevo, Date fecha) throws illegalAmountOfMoneyException {
        this.moto_implicada = moto_implicada;
        this.antiguo = antiguo;
        this.nuevo = nuevo;
        this.fecha = fecha;
        /*
        if (nuevo.getImporte_total()+ moto_implicada.getPrecio() > limiteDinero2){
            
            throw new illegalAmountOfMoneyException
                    ("El importe total de sus motos ascenderá a mas de "+ limiteDinero2 +"euros. ");
        }
        else 
        */
            nuevo.setImporte_total(nuevo.getImporte_total()+ moto_implicada.getPrecio());
            antiguo.setImporte_total(antiguo.getImporte_total()- moto_implicada.getPrecio());
            nuevo.totalCesiones++;
    }

    
    Cesion(Moto motillo, Miembro viejecillo, Miembro nuevecillo, String fecha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public static void setLimite_dinero(float limite_dinero) {
            limiteDinero2 = limite_dinero;
        }
    /**
     *
     * @return
     */
    public Moto getMoto_implicada() {
        return moto_implicada;
    }

    /**
     *
     * @return
     */
    public Miembro getAntiguo() {
        return antiguo;
    }

    /**
     *
     * @return
     */
    public Miembro getNuevo() {
        return nuevo;
    }

    /**
     *
     * @return
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     *
     * @return
     */
    public ArrayList<Cesion> getRegistro() {
        return registro;
    }

    /**
     *
     * @param moto_implicada
     */
    public void setMoto_implicada(Moto moto_implicada) {
        this.moto_implicada = moto_implicada;
    }

    /**
     *
     * @param antiguo
     */
    public void setAntiguo(Miembro antiguo) {
        this.antiguo = antiguo;
    }

    /**
     *
     * @param nuevo
     */
    public void setNuevo(Miembro nuevo) {
        this.nuevo = nuevo;
    }

    /**
     *
     * @param fecha
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     *
     * @param registro
     */
    public void setRegistro(ArrayList<Cesion> registro) {
        this.registro = registro;
    }
    
    
}
