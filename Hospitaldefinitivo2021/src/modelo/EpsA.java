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
public class EpsA extends Afiliacion{
    public EpsA(String tipo, int medicinaG, int vacunacion, int laboratorios, int hospitalizacion) {
        super(tipo, medicinaG, vacunacion, laboratorios, hospitalizacion);
    }

    public EpsA() {
        super("EPS Tipo A", 5000, 5000, 10, 30000);
    }
}
