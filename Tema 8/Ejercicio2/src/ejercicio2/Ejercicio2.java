package ejercicio2;

import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alberto
 */
public class Ejercicio2 {
    public static void main(String[] args){
        Menu menu = new Menu();
    
        menu.setLocationRelativeTo(null);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setSize(350, 200);
        menu.setVisible(true);
    }
       
}
