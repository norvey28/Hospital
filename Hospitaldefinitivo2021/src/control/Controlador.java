/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.*;
import modelo.Conexion;
import vista.*;

/**
 * Clase que Controla la logica del progrma y los procesos de la vista desde la
 * interfaz de usuario
 *
 * @author dadxc
 */
public class Controlador implements ActionListener {

    Registros objR;
    VentanaPrincipal frmPrincipal;
    VentanaRegistrar frmRegistrar;
    VentanaExamenes frmExamenes;
    VentanaConsultar frmConsultar;
    ArrayList<Examen> examenes;
    Hospitalizacion auxH;
    Laboratorios auxL;
    Conexion con;
    long total;
    HistoriaClinicaDAO conexionbd;
    ArrayList<HistoriaClinica> ListaHC;

    /**
     * Controlador básico, inicialización de las ventanas, variables y
     * actionListener
     *
     * @throws java.io.IOException control de excepciones
     */
    public Controlador() throws IOException {
        this.objR = new Registros();
        this.frmPrincipal = new VentanaPrincipal();
        this.frmRegistrar = new VentanaRegistrar();
        this.frmExamenes = new VentanaExamenes();
        this.frmConsultar = new VentanaConsultar();
        this.con = new Conexion();
        frmPrincipal.getPndEscritorio().add(frmRegistrar);
        frmPrincipal.getPndEscritorio().add(frmExamenes);
        frmPrincipal.getPndEscritorio().add(frmConsultar);
        this.frmPrincipal.getOpcmRegistrarPaciente().addActionListener(this);
        this.frmPrincipal.getOpcmRegistrarServicio().addActionListener(this);
        this.frmPrincipal.getOpcmConsultar().addActionListener(this);
        this.frmPrincipal.getOpcmSalir().addActionListener(this);
        this.frmRegistrar.getBtnRegistrar().addActionListener(this);
        this.frmExamenes.getBtnAgregar().addActionListener(this);
        this.frmExamenes.getBtnGrupo().add(frmExamenes.getBtnSangre());
        this.frmExamenes.getBtnGrupo().add(frmExamenes.getBtnOrina());
        this.frmExamenes.getBtnGrupo().add(frmExamenes.getBtnOptometria());
        this.frmExamenes.getBtnGrupo().add(frmExamenes.getBtnOdontologia());
        this.frmExamenes.getBtnGrupo().add(frmExamenes.getBtnCorprologico());
        examenes = new ArrayList<Examen>();
        auxH = new Hospitalizacion();
        auxL = new Laboratorios();
        this.total = 0;
        this.conexionbd = new HistoriaClinicaDAO();
        this.ListaHC = new ArrayList();
    }

    /**
     * Método que inicia y establece el titulo de la ventana Principal
     */
    public void iniciar() {
        frmPrincipal.setTitle("Hospital");
        frmPrincipal.setVisible(true);
    }

    /**
     * Método para el control de acciones del formulario
     *
     * @param e actionEventa para detercatr eventos en las vistas
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.frmPrincipal.getOpcmSalir()) {
            int j = JOptionPane.showConfirmDialog(frmPrincipal, "Realmente desea salir de Aplicación?", "Confirmar salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (j == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
        /*****************************************************************************/
        if (frmPrincipal.getOpcmRegistrarPaciente() == e.getSource()) {
            iniciarVentana(frmRegistrar.getComponents());
            abrirVentana(frmRegistrar, "Registro Alquiler", frmPrincipal.getPndEscritorio());
        }
        /*****************************************************************************/
        if (frmRegistrar.getBtnRegistrar() == e.getSource()) {
            HistoriaClinica objHC = new HistoriaClinica();
            Paciente objP = new Paciente();
            objP.setIdentificacion(frmRegistrar.getTxtIdentificacion().getText());
            objP.setNombre(frmRegistrar.getTxtNombre().getText());
            objP.setDireccion(frmRegistrar.getTxtDireccion().getText());
            objP.setTelefono(frmRegistrar.getTxtTelefono().getText());

            if (frmRegistrar.getCmbAfiliacion().getSelectedItem() == "Sisben") {
                objP.setObjAfiliacion(new Sisben());
            } else {
                if (frmRegistrar.getCmbAfiliacion().getSelectedItem() == "EPS Tipo A") {
                    objP.setObjAfiliacion(new EpsA());
                } else {
                    if (frmRegistrar.getCmbAfiliacion().getSelectedItem() == "EPS Tipo B") {
                        objP.setObjAfiliacion(new EpsB());
                    } else {
                        objP.setObjAfiliacion(new EpsC());
                    }
                }
            }
            objHC.setPaciente(objP);
            objHC.setNroHistoria(numHistoria());
            objHC.setFecha(new Fecha());
            System.out.println(objHC.toString());
            ListaHC.add(objHC);
            frmRegistrar.setVisible(false);
        }
        
        if (frmPrincipal.getOpcmRegistrarServicio() == e.getSource()) {
            iniciarVentana(frmRegistrar.getComponents());
            abrirVentana(frmRegistrar, "Registro Servicio", frmPrincipal.getPndEscritorio());
        }
        

    }

    public String numHistoria() {

        String rtrn = "";
        int aux;

        if (ListaHC.size() == 0) {
            rtrn = "00001";
        } else {
            aux = Integer.parseInt(ListaHC.get(ListaHC.size() - 1).getNroHistoria());
            aux++;
            String num = String.valueOf(aux);
            //System.out.println("longitud "+ Integer.toString(aux).length());
            switch(Integer.toString(aux).length()){
                case 1:{
                    rtrn = "0000" + num ;
                    //System.out.println("0000"+num);
                }
                case 2:{
                    rtrn = "000" + num ;
                }
                case 3:{
                    rtrn = "00" + num ;
                }
                case 4:{
                    rtrn = "0" + num ;
                }
                case 5:{
                    rtrn = ""+ aux ;
                }
            }
            
        }
        return rtrn;
    }

    /**
     * Metodo encargado de resetear los controles de una ventana, de modo que
     * queden limpios los campos que sean de tipo JRadioButton, JTextField,
     * JTextArea, en el caso que se encuentren estos controles en el parametro
     * que recibe este metodo, en el cual se encuentran la totalidad de los
     * controles que estan en un formulario o ventana
     *
     * @param controles controles que se desean limpiar
     */
    public void iniciarVentana(Component[] controles) {
        for (Component control : controles) {
            if (control instanceof JRadioButton) {
                ((JRadioButton) control).setSelected(false);
            } else if (control instanceof JTextField) {
                ((JTextField) control).setText("");
            } else if (control instanceof JTextArea) {
                ((JTextArea) control).setText("");
            } else if (control instanceof Container) {
                iniciarVentana(((Container) control).getComponents());
            } else if (control instanceof JPanel) {
                iniciarVentana(((JPanel) control).getComponents());
            } else if (control instanceof JTabbedPane) {
                int totalTabs = ((JTabbedPane) control).getComponentCount();
                for (int i = 0; i < totalTabs; i++) {
                    Component tab = ((JTabbedPane) control).getComponent(i);
                    if (tab instanceof JPanel) {
                        iniciarVentana(((JPanel) tab).getComponents());
                    }
                }
            }
        }
    }

    /**
     * Abre un JInternalFrame dentro de un JDesktopPane, para lo cual recibe los
     * datos de la ventana a abrir, el titulo a asignar y el JDesktopPane en el
     * que se abrirá
     *
     * @param ventana JInternalFrame a abrir
     * @param titulo Titilo a asignar a la ventana a abrir
     * @param escritorio JDeskTopPane en el que se abrirá la ventana
     */
    public void abrirVentana(JInternalFrame ventana, String titulo, JDesktopPane escritorio) {
        if (ventana.isVisible()) {
            ventana.toFront();
            ventana.getFocusOwner();
            try {
                ventana.setSelected(true);
            } catch (PropertyVetoException ex) {
                JOptionPane.showMessageDialog(null, "Error al abrir ventana" + ex.toString());
            }
        } else {
            ventana.setTitle(titulo);
            Dimension desktopSize = frmPrincipal.getSize();
            Dimension FrameSize = ventana.getSize();
            ventana.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
            if (!escritorio.isAncestorOf(ventana)) {
                escritorio.add(ventana);
                ventana.setVisible(true);
            } else {
                escritorio.setSelectedFrame(ventana);
                ventana.setVisible(true);
            }
        }
    }

}
