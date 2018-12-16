/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz.Panel;

import Interfaz.Cliente;
import Negocio.Movimiento; 
import Negocio.Player; 
import java.awt.Color; 
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
public class Tablero extends javax.swing.JPanel {
private int padding;
    /**
     * Creates new form Tablero
     */
private static Tablero instanciaUnica = new Tablero();
public static Player player = new Player();
  Movimiento[] movimientos;
 public Cliente cg; 
    public Tablero(){

    } 
    public Tablero(Movimiento[] movimientos) {
        initComponents();    
        generarTablero(movimientos);    
        this.player = player;
    }
     public static Tablero obtieneInstancia() {
      
        return instanciaUnica;
    } 
    JLabel imagenPunto;
  
    private void generarTablero(Movimiento[] movimientos){
        ImageIcon icon = new ImageIcon("dot.jpg");
        int tamImagen = 6;
        int anchoBtn = tamImagen;
        int largoBtn = 20; 
        int coorx = 0, coory = 0;
        int contador=0;
        Player playervacio = new Player(); 
        System.out.println("Vertical: ");
        for (int y = 0; y < 20; y++) {
            coorx = 0;
            for (int x = 1; x < 20; x++) { 
                imagenPunto = new JLabel(icon); 
                imagenPunto.setBounds(coorx, coory, tamImagen, tamImagen);
                cg.tablero.add(imagenPunto);
                coorx += tamImagen;
                Boton btn = new Boton(); 
                btn.setBounds(movimientos[contador].getX(), movimientos[contador].getY(), largoBtn, anchoBtn); 
                  
                cg.tablero.add(btn);
                coorx += largoBtn; 
                contador++;
            }
            imagenPunto = new JLabel(icon); 
            imagenPunto.setBounds(movimientos[contador].getX(), movimientos[contador].getY(), tamImagen, tamImagen);
            cg.tablero.add(imagenPunto);
            coory += (largoBtn + tamImagen); 
            contador++;
        } 
        coorx = 0;
        coory = tamImagen;
        System.out.println("Horizontal: ");
        for (int y = 1; y < 20; y++) {
            coorx=0;
            for (int x = 0; x < 20; x++) {
                Boton btnvertical = new Boton();
 
                btnvertical.setForeground(Color.DARK_GRAY);
                btnvertical.setBounds(movimientos[contador].getX(), movimientos[contador].getY(), anchoBtn, largoBtn);
                cg.tablero.add(btnvertical);

                coorx+=(largoBtn + tamImagen);
                contador++;
            }
            coory += (largoBtn + tamImagen);
            contador++;
        }
        cg.tablero.revalidate();
        cg.tablero.repaint(); 
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
