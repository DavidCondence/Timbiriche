/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz.Panel;

import Interfaz.Cliente;
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
Cliente cg;
private int coorx = 0, coory = 0;
private static int identificador=1;
private int id; 
    public Boton(){ 
        super(); 
        addActionListener(this); 
        setContentAreaFilled(false);
        setBorderPainted(false);
        this.id =identificador++;
        setOpaque(true);   
    } 
 
    public int getId(){
        return this.id;
    }
    @Override
    public void actionPerformed(ActionEvent ae) { 
        this.vista = Tablero.obtieneInstancia();  
        setBackground(Color.black); 
        
        JButton source = (JButton)ae.getSource();  
        
        
      
        System.out.println(source.getX());
        System.out.println(source.getY());
        System.out.println(vista.player);
        
        setOpaque(true);   
    } 
}
