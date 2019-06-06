/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejercicio2;
import javax.swing.JFrame;

/**
 *
 * @author Alberto
 */
public class Ejercicio2 {
    public static void main(String[] args){
        Menu menu = new Menu();
        
        menu.setLocationRelativeTo(null);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setSize(340, 340);
        menu.setVisible(true);
    }
}
