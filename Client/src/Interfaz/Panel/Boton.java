/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz.Panel;

import Interfaz.Cliente;
import Negocio.GameEvent;
import Negocio.Movimientos;
import Negocio.Player;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class Boton extends JButton implements ActionListener{
String mensaje; 
Player owner; 
Cliente cg = new Cliente();
private int coorx = 0, coory = 0;
private static int identificador=1;
Movimientos movmiento;
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
        setBackground(Color.black); 
        
        JButton source = (JButton)ae.getSource();  
        
        movmiento = new Movimientos(source.getX(),source.getY(), cg.player); 
        GameEvent newEvent = new GameEvent(15,movmiento); 
        cg.enviarMovimienot(cg.getClient().username); 
         
      /**
        System.out.println(source.getX());
        System.out.println(source.getY());
        System.out.println(vista.player);
        */
        setOpaque(true);   
    } 
}
