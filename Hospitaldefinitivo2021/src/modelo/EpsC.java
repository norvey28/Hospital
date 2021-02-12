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
public class EpsC extends Afiliacion{
    public EpsC(String tipo, int medicinaG, int vacunacion, int laboratorios, int hospitalizacion) {
        super(tipo, medicinaG, vacunacion, laboratorios, hospitalizacion);
    }

    public EpsC() {
        super("EPS Tipo C", 15000, 20000, 100, 70000);
    }
}
