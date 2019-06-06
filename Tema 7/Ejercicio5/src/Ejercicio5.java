/**
 *
 * @author Alberto
 */

import javax.swing.JFrame;

public class Ejercicio5 {
    public static void main(String[] args){
        Menu menu = new Menu();
        
        menu.setLocationRelativeTo(null);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setSize(550, 300);
        menu.setVisible(true);
    }
}
