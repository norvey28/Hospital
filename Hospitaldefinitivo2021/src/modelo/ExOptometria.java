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
public class ExOptometria extends Examen{
    
    public ExOptometria(String Cod, String nombre, String descripcion, double valor) {
        super(Cod, nombre, descripcion, valor);
    }

    public ExOptometria() {
        super("104","Optometria"," ",35000);
    }    
}
