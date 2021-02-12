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
public class ExCoprologico extends Examen{
    
    public ExCoprologico(String Cod, String nombre, String descripcion, double valor) {
        super(Cod, nombre, descripcion, valor);
    }

    public ExCoprologico() {
        super("103","Coprologico"," ",15000);
    }    
    
}
