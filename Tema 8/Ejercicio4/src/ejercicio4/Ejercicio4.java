package ejercicio4;

import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFrame;

/**
 *
 * @author Alberto
 */
public class Ejercicio4 {
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException{
        Menu menu = new Menu();
        menu.setLocationRelativeTo(null);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setSize(750, 600);
        menu.setVisible(true);
    }
}
