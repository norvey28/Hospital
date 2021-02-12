/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author dadxc
 */
public class HistoriaClinica {
    private String NroHistoria;
    private Fecha fecha;
    private Paciente paciente;
    private ArrayList<Servicio> ListaS ;

    /**
     *Constructor parametrico
     * @param NroHistoria numero de la historia clinica
     * @param fecha fecha de la historia clinica
     * @param paciente datos del paciente de la historia clinica
     * @param servicio datos del servicio de la historia clinica
     */
    public HistoriaClinica(String NroHistoria, Fecha fecha, Paciente paciente, Servicio servicio) {
        this.NroHistoria = NroHistoria;
        this.fecha = fecha;
        this.paciente = paciente;
        this.ListaS = new ArrayList();
    }
    
    /**
     *Constructor basco
     */
    public HistoriaClinica() {
        this.NroHistoria = "";
        this.fecha = new Fecha();
        this.paciente = new Paciente();
        this.ListaS = new ArrayList();
    }

    /**
     *retonra el numero de la historia clinica
     * @return String
     */
    public String getNroHistoria() {
        return NroHistoria;
    }

  
    /**
     *retorna la fecha de la historia clinica en un objeto tipo fecha
     * @return Fecha
     */
    public Fecha getFecha() {
        return fecha;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public ArrayList<Servicio> getListaS() {
        return ListaS;
    }

    public void setListaS(ArrayList<Servicio> ListaS) {
        this.ListaS = ListaS;
    }

    public void setNroHistoria(String NroHistoria) {
        this.NroHistoria = NroHistoria;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }
    

  
    /**
     *
     * @return String
     */
    @Override
    public String toString() {
        String m;
        m = "HistoriaClinica" + "\nNumero Historia:" + NroHistoria + "\nfecha:" + fecha.toString() + "\nDatos Paciente=" + paciente.toString() ;
        if(ListaS.size()==0){
            m += " No se han registrado Servicios";
        }else{
            m += "\nDatos Servicio:" + ListaS.toString();
        }
        return m;
    }
    
    public double valorHospitalizacion(Hospitalizacion hospitalizacion){
        double dias= 0;
        double diasaux= 0;
        double aux=0;
        double costo=0;
        dias = (hospitalizacion.getSalida().getAa()*365)+(hospitalizacion.getSalida().getMm()*30)+(hospitalizacion.getSalida().getDd());
        diasaux = (hospitalizacion.getIngreso().getAa()*365)+(hospitalizacion.getIngreso().getMm()*30)+(hospitalizacion.getIngreso().getDd());
        aux = dias - diasaux;
         if(paciente.getObjAfiliacion().getTipo().equalsIgnoreCase("EPS Tipo A")) {
                    costo = aux*30000;
                } else if (paciente.getObjAfiliacion().getTipo().equalsIgnoreCase("EPS Tipo B")){
                    costo = aux*40000;
                }else if (paciente.getObjAfiliacion().getTipo().equalsIgnoreCase("EPS Tipo B")){
                    costo = aux*70000;
                }else {
                    costo = aux*20000;
                }
            
       return costo;
}
}
    
        
    