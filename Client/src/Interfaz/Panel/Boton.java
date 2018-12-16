/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz.Panel;

import Negocio.Player;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class Boton extends JButton implements ActionListener{
String mensaje;
Tablero vista;
Player owner;
private static int identificador=1;
private int id;
    public Boton(){ 
        super(); 
        addActionListener(this); 
        setContentAreaFilled(false);
        setBorderPainted(false);
        this.id =identificador++;
        setOpaque(true);
        setBackground(Color.yellow);  

    }
    public int getId(){
        return this.id;
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        this.vista = Tablero.obtieneInstancia();  
        setBackground(Color.black); 
        owner = vista.cg.player;
        System.out.println(owner);
        setOpaque(true);   
    } 
}
