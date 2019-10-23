/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import java.io.InputStreamReader;
import java.lang.reflect.Array;
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
        ArrayList<Integer> masCesiones = new ArrayList<Integer>();
        String matricula, matriculaGastos;
        String caracteristicas;
        String nombre_moto;
        float precio, otrosGastos = 0,incrementoGastos;
        Moto moto_implicada;
        Miembro antiguo, nuevo;
        Date fechaActual = new Date();
        ArrayList<Cesion> registro = new ArrayList<>();
        String miembro_antiguo, miembro_nuevo;
        String opcion = "0";
        Scanner sc = new Scanner(System.in);
        float limite_dinero;
        String propietario;
        int totalCesiones;

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
            System.out.println("8)Eliminar miembro");
            System.out.println("9)Miembros con mas cesiones");
            System.out.println("10)Salir del programa");
        
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
                            Miembro.total_id++;
                            totalSocios++;
                            miembro = new Miembro(nombre_miembro,num_motos, importe_total);
                            miembros.add(miembro);
                            
                    System.out.println( "Indica los datos de las motos del miembro : "); 
                    for (int i = 0; i < num_motos; i++){
                        Moto moto;
                        System.out.println("Introduce la matricula de la moto : ");
                        matricula = (sc.nextLine());
                        System.out.println("Introduce sus caracteristicas : ");
                        caracteristicas = (sc.nextLine());
                        System.out.println("Introduce el nombre : ");
                        nombre_moto = (sc.nextLine());
                        propietario = nombre_miembro;
                        System.out.println("Introduce el precio : ");
                        precio = (sc.nextFloat());
                        sc.nextLine();
                        System.out.println("Introduce el importe de los otros gastos de la moto, como su mantenimiento : ");
                        otrosGastos = (sc.nextFloat());
                        sc.nextLine();

                        moto = new Moto(matricula,caracteristicas,nombre_moto,propietario, precio, otrosGastos);
                        motos.add(moto);
                        miembro.motos.add(moto);
                    }
                          
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
                    propietario = sc.nextLine();
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
                    Miembro miembrillo = null;
                    String prop = null;
                    Miembro nuevecillo = null;
                    boolean encontrado = false;
   
                    System.out.println("Introduce la matricula : ");
                    matricula = (sc.nextLine());
                    for (int i = 0; i < motos.size();i++){
                        if (motos.get(i).getMatricula() == null ? matricula == null : motos.get(i).getMatricula().equals(matricula)){
                            prop = motos.get(i).getPropietario(); //Nombre miembro antiguo
                            motillo = motos.get(i);
                            System.out.println("...........moto encontarada ");
                        }
                    }
                    for (int i = 0; i < miembros.size();i++){
                        if (miembros.get(i).getNombre() == null ? prop == null : miembros.get(i).getNombre().equals(prop)){
                            miembrillo = miembros.get(i);   //objeto miembro antiguo
                        }
                    }
                    
                    System.out.println("Dime el ID del nuevo propietario de la moto : ");
                    int nuevoProp = sc.nextInt();
                    
                    for (int i = 0; i < miembros.size();i++){
                        if (miembros.get(i).getNum_socio()== nuevoProp){
                            nuevecillo = miembros.get(i);
                            encontrado = true;
                        }
                    }
                    if(encontrado == false){
                        System.out.println( "ERROR : no se ha encontrado el miembro destinatario.");
                    }
                    
                    DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
                    
                    cesion = new Cesion(motillo,miembrillo,nuevecillo,fechaActual);
                    registro.add(cesion);
                    sc.nextLine();
                    
                    break;
                    
                case "4": 
                    Miembro auxiliar;
                    for( int i = 0 ; i < miembros.size(); i++) {auxiliar = miembros.get(i);
                        if (miembros.get(i) != null) {
                            if(auxiliar.getNum_motos() > 0){
                                System.out.print( miembros.get(i).getNombre()+ " ");
                                System.out.println( miembros.get(i).getNum_socio());
                            }
                        }
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
                    for( int i = 0 ; i < registro.size(); i++) { 
                         auxiliar1 = registro.get(i);
                         System.out.println("la moto :" + auxiliar1.moto_implicada.getNombre() );
                         System.out.println("Anterior propietario : " + auxiliar1.getAntiguo().getNombre());
                         System.out.println("nuevo propietario : " + auxiliar1.getNuevo().getNombre());
                         System.out.println("con fecha: " + auxiliar1.getFecha());
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
                    
                case "8":
                    System.out.println("Dame el id del miembro a eliminar ( el excluidito de turno )");
                    int variable = sc.nextInt();
                    sc.nextLine();
                    for( int i = 0 ; i < miembros.size(); i++)
                    {
                        if (miembros.get(i).getNum_socio() == variable){
                            //miembros.get(i).eliminarMiembro(variable-1);
                        } 
                    }
                    miembros.remove(variable-1);
                    miembros.add(variable-1,null);
                    
                    break;
                    
                case "9":
                    System.out.println("Los miembros con más cesiones són : ");
                    totalCesiones = miembros.get(0).getTotalCesiones();
                    masCesiones.add(0);
                    System.out.println("cesiones de 0 "+ totalCesiones);
                    System.out.println("nombre del 0 "+ miembros.get(0).getNombre());
                    
                    for (int i = 1; i < miembros.size(); i++){
                        if (miembros.get(i).getTotalCesiones() < totalCesiones){  
                            System.out.println("TIENE MENOS CECIOSNES");
                        }
                        else if(miembros.get(i).getTotalCesiones() == totalCesiones){
                            System.out.println("TIENE IGUAL CECIOSNES");
                            masCesiones.add(i);
                        }
                        else if (miembros.get(i).getTotalCesiones() > totalCesiones){
                            masCesiones.clear();
                            totalCesiones = miembros.get(i).getTotalCesiones();
                            masCesiones.add(i);
                            System.out.println("TIENE MAS CECIOSNES");
                        } 
                    }
                    
                    Miembro auxiliar2;
                    for( int i = 0 ; i < miembros.size(); i++) {auxiliar2 = miembros.get(i);
                        if (miembros.get(i) != null) {
                            if(auxiliar2.getNum_motos() > 0){
                                System.out.print( miembros.get(i).getNombre()+ " ");
                                System.out.println( miembros.get(i).getNum_socio());
                            }
                        }
                    }

                    break;
                    
                case "10": System.exit(0);                   
            }
            
        }while (opcion != "10");

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