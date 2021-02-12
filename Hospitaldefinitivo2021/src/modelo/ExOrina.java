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
public class ExOrina extends Examen{

        public ExOrina(String Cod, String nombre, String descripcion, double valor) {
        super(Cod, nombre, descripcion, valor);
    }

    public ExOrina() {
        super("102","Orina"," ",10000);
    }
    
    
}
