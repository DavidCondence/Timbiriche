/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Negocio.Movimiento;
import static datos.Server.movimientos;

/**
 *
 * @author Admin
 */
public class prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        inicializaTablero();  
        for (int i = 0; i < movimientos.length; i++) {
            if (movimientos[i] != null) { 
                System.out.println(movimientos[i].getX()+" : "+movimientos[i].getY());
            } 
        } 
    }
    public static void inicializaTablero(){ 
        System.out.println("inicializaTablero");
        int tamImagen = 6;
        int anchoBtn = tamImagen;
        int largoBtn = 20; 
        int coorx = 0, coory = 0;
        int contador=1; 
        for (int y = 0; y < 10; y++) {
            coorx = 0;
            for (int x = 1; x < 10; x++) {  
                coorx += tamImagen; 
                movimientos[contador] = new Movimiento(coorx,coory,'v'); 
                coorx += largoBtn; 
                contador++;
            } 
            coory += (largoBtn + tamImagen); 
            contador++;
        } 
        coorx = 0;
        coory = tamImagen; 
        for (int y = 1; y < 10; y++) {
            coorx=0;
            for (int x = 0; x < 10; x++) {  
                movimientos[contador] = new Movimiento(coorx,coory,'h');  
                coorx+=(largoBtn + tamImagen);
                contador++;
            }
            coory += (largoBtn + tamImagen);
            contador++;
        }  
        
    }
}
