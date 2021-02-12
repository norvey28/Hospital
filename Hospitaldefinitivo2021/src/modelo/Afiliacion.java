/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.swing.JOptionPane;

/**
 *
 * @author Norvey
 */
public abstract class Afiliacion {
    
    String tipo;
    int medicinaG,vacunacion,laboratorios,hospitalizacion;

    public Afiliacion(String tipo, int medicinaG, int vacunacion, int laboratorios, int hospitalizacion) {
        this.tipo = tipo;
        this.medicinaG = medicinaG;
        this.vacunacion = vacunacion;
        this.laboratorios = laboratorios;
        this.hospitalizacion = hospitalizacion;
    }
    
    public Afiliacion() {
        this.tipo = "";
        this.medicinaG = 0;
        this.vacunacion = 0;
        this.laboratorios = 0;
        this.hospitalizacion = 0;
    }
    
    
    
    public int costoServicio(int cod){
        
        int costo=0;
        
        switch(cod){
            case 1:{
                costo = this.getMedicinaG();break;
            }
            case 2:{
                costo = this.getVacunacion();break;
            }
            case 3:{
                costo = this.getLaboratorios();break;
            }
            case 4:{
                costo = this.getHospitalizacion();break;
            }
            default:{
                costo = 0;
                JOptionPane.showMessageDialog(null, "Opción Invalida");
            }
        }
        return costo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getMedicinaG() {
        return medicinaG;
    }

    public void setMedicinaG(int medicinaG) {
        this.medicinaG = medicinaG;
    }

    public int getVacunacion() {
        return vacunacion;
    }

    public void setVacunacion(int vacunacion) {
        this.vacunacion = vacunacion;
    }

    public int getLaboratorios() {
        return laboratorios;
    }

    public void setLaboratorios(int laboratorios) {
        this.laboratorios = laboratorios;
    }

    public int getHospitalizacion() {
        return hospitalizacion;
    }

    public void setHospitalizacion(int hospitalizacion) {
        this.hospitalizacion = hospitalizacion;
    }
    
}
