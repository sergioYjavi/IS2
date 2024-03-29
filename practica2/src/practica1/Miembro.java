
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import java.util.ArrayList;
import  java.lang.Exception;
import java.util.Date;
import java.util.Scanner;
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
    static int total_id;
    Date fecha = new Date();
    Scanner sc = new Scanner(System.in);
    ArrayList<Miembro> miembros = new ArrayList<Miembro>();
    ArrayList<Moto> motos;
    int totalCesiones;

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
        //System.out.println("total miembros = "+ total_socios);
        Miembro auxiliar;
        for( i = 0 ; i < miembros.size(); i++) {
            auxiliar = miembros.get(i);
            if(auxiliar.getNum_socio() == num_socio)
            {
                throw new memberAlreadyExistException("Este numero de socio ya está siendo utilizado. ");}
            }
        this.nombre = nombre;
        this.num_motos = num_motos;
        if (this.importe_total < limiteDinero2 )
        {
            this.importe_total = importe_total;
                //total_socios++;
        }
        
        /*
        else 
        {   
            throw new illegalAmountOfMoneyException
                    ("El importe total de sus motos ascenderá a mas de "+ limiteDinero2 +"euros. ");
        }
        */
            
        this.motos= new ArrayList<>();
        
        num_socio = total_id;
 
    }
    
    /**
     *
     * @param idMiembro
     * @throws illegalAmountOfMoneyException
     */
    public void eliminarMiembro(int idMiembro) throws illegalAmountOfMoneyException{
        if (num_motos > 0){
            System.out.println( "Tienes que ceder la moto a alguien."); 
            for (int i = 0 ; i < num_motos; i++){ 
                System.out.println( "La id del nuevo miembro :"); 
                int b = sc.nextInt(); 
                //Cesion a = new Cesion(motos.get(i),miembros.get(idMiembro) , miembros.get(b), fecha ); 
                
            } 
        } 
        total_socios--; 
        System.out.println("Se ha eliminado el miembro exitosamente"); 
    };
    
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

    public int getTotalCesiones() {
        return totalCesiones;
    }

    public void setTotalCesiones(int totalCesiones) {
        this.totalCesiones = totalCesiones;
    }
    
    
}
