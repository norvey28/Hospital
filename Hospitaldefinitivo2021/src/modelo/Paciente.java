/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author dadxc
 */
public class Paciente {

    /**
     *identificacion del paciente
     */
    protected String identificacion,

    /**
     *nombre del paciente
     */
    nombre,

    /**
     *direccion del paciente
     */
    direccion,

    /**
     *telefono del paciente
     */
    telefono;
    
    Afiliacion objAfiliacion ;

    /**
     *Constructor parametrico
     * @param identificacion identificacion del paciente
     * @param nombre nombre del paciente
     * @param direccion direccion del paciente
     * @param telefono telefono del paciente
     */
    public Paciente(String identificacion, String nombre, String direccion, String telefono, Afiliacion afiliacion) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.objAfiliacion = afiliacion;
    }
    
    /**
     *Constructor basico
     */
    public Paciente() {
        this.identificacion = "";
        this.nombre = "";
        this.direccion = "";
        this.telefono = "";
        this.objAfiliacion = new Sisben("Error",0,0,0,0);
    }

    /**
     *Retorna la identificacion del paciente
     * @return String
     */
    public String getIdentificacion() {
        return identificacion;
    }

    
    /**
     *retorna el nombre del paciente
     * @return String
     */
    public String getNombre() {
        return nombre;
    }

    public Afiliacion getObjAfiliacion() {
        return objAfiliacion;
    }

    public void setObjAfiliacion(Afiliacion objAfiliacion) {
        this.objAfiliacion = objAfiliacion;
    }

   
    /**
     *retorna la direccion del paciente
     * @return String
     */
    public String getDireccion() {
        return direccion;
    }

    
    
    /**
     *Retorna el telefono del paciente
     * @return String
     */
    public String getTelefono() {
        return telefono;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
   

    /**
     *
     * @return String
     */
    @Override
    public String toString() {
        return nombre +";"+identificacion+";"+direccion +";"+telefono;
    }
    
   
}

