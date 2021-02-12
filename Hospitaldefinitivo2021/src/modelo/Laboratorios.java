/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 * Clase de la entidad Laboratorios
 * @author dadxc
 */
public class Laboratorios extends Servicio{
    private ArrayList<Examen> examenes;

    
    public Laboratorios(ArrayList<Examen> examenes, String Codigo, String Nombre, String Descripcion) {
        super(Codigo, Nombre, Descripcion);
        this.examenes = examenes;
    }

    public Laboratorios() {
        super("3","Laboratorio"," ");
        examenes = new ArrayList();
    }

    /**
     * Método para obtener la lista de examenes del paciente
     * @return ArrayList
     */
    public ArrayList<Examen> getExamenes() {
        return examenes;
    }

    /**
     * Método para modificar la lista de examenes del paciente
     * @param examenes lista de examenes modificada
     */
    public void setExamenes(ArrayList<Examen> examenes) {
        this.examenes = examenes;
    }
/**
     * Método para obtener la lista de examenes del paciente, en formato string de texto
     * @return String
     */
    @Override
    public String toString() {
        String msj = "";
        for (int i = 0; i < examenes.size(); i++) {
            msj+=examenes.get(i).toString();
        }
        return msj;
    }
    
    
}
