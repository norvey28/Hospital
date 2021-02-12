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
public class EpsB extends Afiliacion{
    public EpsB(String tipo, int medicinaG, int vacunacion, int laboratorios, int hospitalizacion) {
        super(tipo, medicinaG, vacunacion, laboratorios, hospitalizacion);
    }

    public EpsB() {
        super("EPS Tipo B", 10000, 10000, 50, 40000);
    }
}
