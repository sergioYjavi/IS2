/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import java.util.ArrayList;
import  java.lang.Exception;
import static practica1.Cesion.limiteDinero2;

/**
 *
 * @author alumno
 */
public  class Miembro extends ClasePrincipal{

    

    static float limiteDinero2;
    int num_socio;
    String nombre;
    int num_motos;
    float importe_total = 0;
    static int total_socios;
    ArrayList<Miembro> miembros = new ArrayList<Miembro>();
    ArrayList<Moto> motos;

    public Miembro() {
    }
    
    /**
     *
     * @param num_socio
     * @param nombre
     * @param num_motos
     * @param importe_total
     * @throws memberAlreadyExistException
     */
    @SuppressWarnings("empty-statement")
    
    public Miembro(String nombre, int num_motos, float importe_total)throws memberAlreadyExistException, illegalAmountOfMoneyException {
        int i;
        Miembro auxiliar;
       for( i = 0 ; i < miembros.size(); i++) {auxiliar = miembros.get(i);
            if(auxiliar.getNum_socio() == num_socio)
            {throw new memberAlreadyExistException("Este numero de socio ya está siendo utilizado. ");}
            }
        this.nombre = nombre;
        this.num_motos = num_motos;
        if (this.importe_total < limiteDinero2 )
        {
            this.importe_total = importe_total;
        }
        else 
        {   
            throw new illegalAmountOfMoneyException
                    ("El importe total de sus motos ascenderá a mas de "+ limiteDinero2 +"euros. ");
        }
        total_socios++;
        this.motos= new ArrayList<>();
        num_socio = total_socios++;
        
    
        
    }
    
    public static void setLimite_dinero(float limite_dinero) {
         limiteDinero2 = limite_dinero;
        }
    
    public static void setTotalSocios(int totalSocios) {
         total_socios = totalSocios;
    }
    /**
     *
     * @return
     */
    public int getNum_socio() {
        return num_socio;
    }

    /**
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @return
     */
    public int getNum_motos() {
        return num_motos;
    }

    /**
     *
     * @return
     */
    public float getImporte_total() {
        return importe_total;
    }

    /**
     *
     * @return
     */
    public ArrayList<Moto> getMotos() {
        return motos;
    }

    /**
     *
     * @param num_socio
     */
    public void setNum_socio(int num_socio) {
        this.num_socio = num_socio;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @param num_motos
     */
    public void setNum_motos(int num_motos) {
        this.num_motos = num_motos;
    }

    /**
     *
     * @param importe_total
     */
    public void setImporte_total(float importe_total) {
        this.importe_total = importe_total;
    }

    /**
     *
     * @param motos
     */
    public void setMotos(ArrayList<Moto> motos) {
        this.motos = motos;
    }
    
    
    
    
    
    
}
