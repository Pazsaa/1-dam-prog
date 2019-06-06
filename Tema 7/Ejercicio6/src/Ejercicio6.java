/**
 *
 * @author Alberto
 */

import javax.swing.JFrame;

public class Ejercicio6 {
    public static void main(String [] args){
        Tragaperras tp = new Tragaperras();
        
        tp.setLocationRelativeTo(null);
        tp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tp.setSize(150, 150);
        tp.setVisible(true);
    }
}
