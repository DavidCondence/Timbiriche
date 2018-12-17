/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz.Panel;

import Interfaz.Cliente;
import Negocio.Player; 
import java.awt.Color; 
import javax.swing.JLabel; 
public class Tablero extends javax.swing.JPanel {
private int padding; 
private static Tablero instanciaUnica = new Tablero();
public static Player player = new Player();
public static Cliente cg; 
    public Tablero(){ 
    } 
    public Tablero(Cliente cg) {
        initComponents();    
        inicializaTablero();    
        this.cg = cg;
    }
     public static Tablero obtieneInstancia() { 
        return instanciaUnica;
    } 
    JLabel imagenPunto;
    private void inicializaTablero(){ 
        int TamanoCuadro = 15;
        int anchoBtn = TamanoCuadro;
        int TamanoLinea = 60; 
        int coordenadaX = 0, coordenadaY = 0;
        for (int y = 0; y < 5; y++) { 
            coordenadaX = 0;
            for (int x = 1; x < 5; x++) { 
                imagenPunto = new JLabel(); 
                imagenPunto.setBackground(Color.BLACK);
                imagenPunto.setOpaque(true);
                imagenPunto.setBounds(coordenadaX, coordenadaY, TamanoCuadro, TamanoCuadro);
                cg.tablero.add(imagenPunto);
                coordenadaX += TamanoCuadro;
                Boton btn = new Boton();
                btn.setBackground(Color.LIGHT_GRAY);
                btn.setBounds(coordenadaX, coordenadaY, TamanoLinea, anchoBtn); 
                cg.tablero.add(btn);
                coordenadaX += TamanoLinea; 
            }
            imagenPunto = new JLabel(); 
            imagenPunto.setBackground(Color.BLACK);
            imagenPunto.setOpaque(true);
            imagenPunto.setBounds(coordenadaX, coordenadaY, TamanoCuadro, TamanoCuadro);
            cg.tablero.add(imagenPunto);
            coordenadaY += (TamanoLinea + TamanoCuadro); 
        } 
        coordenadaX = 0;
        coordenadaY = TamanoCuadro;
        for (int y = 1; y < 5; y++) {
            coordenadaX=0;
            for (int x = 0; x < 5; x++) {
                Boton btnvertical = new Boton(); 
                btnvertical.setForeground(Color.LIGHT_GRAY);
                btnvertical.setBounds(coordenadaX, coordenadaY, anchoBtn, TamanoLinea);
                cg.tablero.add(btnvertical);

                coordenadaX+=(TamanoLinea + TamanoCuadro);
            }
            coordenadaY += (TamanoLinea + TamanoCuadro);
        }
        cg.tablero.revalidate();
        cg.tablero.repaint();
    } 
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
