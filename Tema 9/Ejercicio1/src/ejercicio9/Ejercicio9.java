/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejercicio9;

import javax.swing.JFrame;

/**
 *
 * @author Alberto
 */
public class Ejercicio9 {
    public static void main(String[] args) {
        Menu menu=new Menu();
        menu.setLocationRelativeTo(null);
        menu.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        menu.setSize(420,300);
        menu.setVisible(true);
    }
}
