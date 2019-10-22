/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

/**
 *
 * @author alumno
 */
public class Moto extends ClasePrincipal{
    String matricula;
    String caracteristicas;
    String nombre;
    String propietario;
    float precio;
    float otrosGastos;
    

    /**
     *
     * @param matricula
     * @param caracteristicas
     * @param nombre
     * @param propietario
     * @param precio
     */
    public Moto(String matricula, String caracteristicas, String nombre, String propietario, float precio,float otrosGastos) {
        this.matricula = matricula;
        this.caracteristicas = caracteristicas;
        this.nombre = nombre;
        this.propietario = propietario;
        this.precio = precio;
        this.otrosGastos = otrosGastos;
    }

    /**
     *
     * @return
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     *
     * @return
     */
    public String getCaracteristicas() {
        return caracteristicas;
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
    public String getPropietario() {
        return propietario;
    }

    /**
     *
     * @return
     */
    public float getPrecio() {
        return precio;
    }

    /**
     *
     * @param matricula
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     *
     * @param caracteristicas
     */
    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
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
     * @param propietario
     */
    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    /**
     *
     * @param precio
     */
    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public float getOtrosGastos() {
        return otrosGastos;
    }

    public void setOtrosGastos(float otrosGastos) {
        this.otrosGastos = otrosGastos;
    }
    
    public void añadirMasGastos(float incrementoGastos){
        this.otrosGastos = otrosGastos + incrementoGastos;
    }
  
}
