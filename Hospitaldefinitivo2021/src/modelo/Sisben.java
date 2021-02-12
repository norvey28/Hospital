/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author dadxc
 */
public class Sisben extends Afiliacion{

    public Sisben(String tipo, int medicinaG, int vacunacion, int laboratorios, int hospitalizacion) {
        super(tipo, medicinaG, vacunacion, laboratorios, hospitalizacion);
    }

    public Sisben() {
        super("Sisben", 0, 0, 0, 20000);
    }

}
