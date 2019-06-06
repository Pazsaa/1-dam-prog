/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejercicio4;
import javax.swing.JFrame;

/**
 *
 * @author Alberto
 */
public class Ejercicio4 {
    public static void main(String[] args){
        Menu menu = new Menu();
        menu.setSize(300, 250);
        menu.setLocationRelativeTo(null);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setVisible(true);
    }
}
