/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Norvey
 */
public class ExOdontologia extends Examen{
    
    public ExOdontologia(String Cod, String nombre, String descripcion, double valor) {
        super(Cod, nombre, descripcion, valor);
    }

    public ExOdontologia() {
        super("105","Odontologia"," ",50000);
    }    
}
