/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import static practica1.Miembro.limiteDinero2;
import practica1.illegalAmountOfMoneyException;


/**
 *
 * @author Javier Jiménez Fernández 
 * @author Sergio Martínez Llopis
 * 
 */
public class ClasePrincipal {

    /**
     *
     * @param args
     * @throws memberAlreadyExistException
     * @throws ParseException
     * @throws illegalAmountOfMoneyException
     */
    public static void main(String[] args) throws memberAlreadyExistException, ParseException, illegalAmountOfMoneyException {
        
        int num_socio, totalSocios = 0;
        String nombre_miembro;
        int num_motos;
        float importe_total;
        ArrayList<Moto> motos = new ArrayList<Moto>();
        ArrayList<Miembro> miembros = new ArrayList<Miembro>();
        String matricula, matriculaGastos;
        String caracteristicas;
        String nombre_moto;
        String propietario;
        float precio, otrosGastos = 0,incrementoGastos;
        Moto moto_implicada;
        Miembro antiguo, nuevo;
        Date fecha;
        ArrayList<Cesion> registro = new ArrayList<>();
        String miembro_antiguo, miembro_nuevo;
        String opcion = "0";
        Scanner sc = new Scanner(System.in);
        float limite_dinero;

        System.out.println("Introduce el limite de dinero de motos por miembro : ");
        limite_dinero = sc.nextFloat();
        sc.nextLine();
        Cesion.setLimite_dinero(limite_dinero);
        Miembro.setLimite_dinero(limite_dinero);
        Miembro.setTotalSocios(totalSocios);
        
        do{
            System.out.println("1)Registrar un nuevo miembro");
            System.out.println("2)Registrar una nueva motocicleta");
            System.out.println("3)Registrar una cesión");
            System.out.println("4)Mostrar en pantalla los miembros con motos en posesión");
            System.out.println("5)Listar todas las motos");
            System.out.println("6)Mostrar las cesiones realizadas");
            System.out.println("7)Incrementar otros gastos a una moto");
            System.out.println("9)Salir del programa");
        
            opcion = sc.nextLine();
            switch(opcion){
                case "1":
                
                    Miembro miembro; 
                    System.out.print("Introduce el nombre del nuevo miembro : ");
                    nombre_miembro = (sc.nextLine());
                    System.out.print("Introduce el numero de motos del socio: ");
                    num_motos = (sc.nextInt());
                   
                    
                    do {
                        System.out.print("Introduce el importe total de las motos : ");
                    importe_total = (sc.nextFloat());
                    sc.nextLine();
                     try{   
                        miembro = new Miembro(nombre_miembro,num_motos, importe_total);
                          if (importe_total > limiteDinero2 ){
                        illegalAmountOfMoneyException e = new illegalAmountOfMoneyException("La hemos liao");
                        throw e  ;
                          }
                        }

                        catch (illegalAmountOfMoneyException e){
                           System.out.print("Introduce de nuevo el importe total de las motos  : ");
                            importe_total = (sc.nextFloat());
                            sc.nextLine();
                            
                           
                     }
                        }while(importe_total > limite_dinero);
                            Miembro.total_socios++;
                            totalSocios++;
                            miembro = new Miembro(nombre_miembro,num_motos, importe_total);
                            miembros.add(miembro);
                          
                     break;
                 
                case "2": 
                    Moto moto;
                    System.out.println("Introduce la matricula de la moto : ");
                    matricula = (sc.nextLine());
                    System.out.println("Introduce sus caracteristicas : ");
                    caracteristicas = (sc.nextLine());
                    System.out.println("Introduce el nombre : ");
                    nombre_moto = (sc.nextLine());
                    System.out.println("Introduce el nombre del propietario : ");
                    propietario = (sc.nextLine());
                    System.out.println("Introduce el precio : ");
                    precio = (sc.nextFloat());
                    sc.nextLine();
                    System.out.println("Introduce el importe de los otros gastos de la moto, como su mantenimiento : ");
                    otrosGastos = (sc.nextFloat());
                    sc.nextLine();
                    
                    moto = new Moto(matricula,caracteristicas,nombre_moto,propietario, precio, otrosGastos);
                    motos.add(moto);
                    break;
                    
                case "3":
                    Cesion cesion;
                    Moto motillo = null;
                    matricula = (sc.nextLine());
                    caracteristicas = (sc.nextLine());
                    nombre_moto = (sc.nextLine());
                    propietario = (sc.nextLine());
                    precio = (sc.nextFloat());
                    System.out.println("Introduce el importe de los otros gastos de la moto, como su mantenimiento : ");
                    otrosGastos = (sc.nextFloat());
                    sc.nextLine();
                    motillo = new Moto (matricula,caracteristicas,nombre_moto,propietario,precio,otrosGastos);

                    Miembro nuevecillo; 
                    num_socio = (sc.nextInt());
                    nombre_miembro = (sc.nextLine());
                    num_motos = (sc.nextInt());
                    importe_total = (sc.nextFloat());
                    nuevecillo = new Miembro( nombre_miembro,num_motos, importe_total);

                     Miembro viejecillo; 
                    num_socio = (sc.nextInt());
                    nombre_miembro = (sc.nextLine());
                    num_motos = (sc.nextInt());
                    importe_total = (sc.nextFloat());
                    viejecillo = new Miembro( nombre_miembro,num_motos, importe_total);


                    String fechaComoTexto = sc.nextLine();
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    fecha = sdf.parse(fechaComoTexto);

                     cesion = new Cesion(motillo,viejecillo,nuevecillo,fecha);
                     registro.add(cesion);
                    
                case "4": 
                    Miembro auxiliar;
                    for( int i = 0 ; i < miembros.size(); i++) {auxiliar = miembros.get(i);
                        if(auxiliar.getNum_motos() > 0)
                            System.out.print( miembros.get(i).getNombre()+ " ");
                            System.out.println( miembros.get(i).getNum_socio());
                    }
                    break;
                    
                case "5":  
                    Moto la_moto;
                    for( int i = 0 ; i < motos.size(); i++) {
                        la_moto = motos.get(i);
                        System.out.println("-------------------------------------");
                        System.out.println("Matricula : " + la_moto.matricula);
                        System.out.println("Nombre moto :" + la_moto.nombre);
                        System.out.println("Precio : " + la_moto.precio);
                        System.out.println("Caracteristicas : " + la_moto.caracteristicas);
                        System.out.println("Propietario : " + la_moto.propietario);
                        System.out.println("Otros gastos : " + la_moto.otrosGastos);
                        System.out.println("-------------------------------------");
                    }
                    break;
                    
                case "6":
                    Cesion auxiliar1;
                    for( int i = 0 ; i < registro.size(); i++) { auxiliar1 = registro.get(i);
                    System.out.println("la moto :"+auxiliar1.moto_implicada.nombre +"anterior propietario"+auxiliar1.antiguo
                            +"nuevo propietario : "+ auxiliar1.nuevo+"con fecha "+auxiliar1.fecha);
                    }
                    break;
                
                case "7":
                    System.out.println("Indique la matricula de la moto que quire incrementar los gastos :  ");
                    matriculaGastos = sc.nextLine();
                    System.out.println("Indique el incremento de gastos en esta moto : ");
                    incrementoGastos = sc.nextFloat();
                    sc.nextLine();
                    
                    for (int i=0; i < motos.size(); i++){
                        if (matriculaGastos.equals(motos.get(i).getMatricula())){
                            motos.get(i).añadirMasGastos(incrementoGastos);
                            
                        }
                    }
                    break;
                    
                    
                case "9": System.exit(0);                   
            }
            
        }while (opcion != "9");

    }
    protected String string;
    private float limite_dinero;

    /**
     * Get the value of string
     *
     * @return the value of string
     */
    public String getString() {
        return string;
    }

    /**
     * Set the value of string
     *
     * @param string new value of string
     */
    public void setString(String string) {
        this.string = string;
    }
 
}