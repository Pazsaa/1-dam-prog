
import javax.swing.JFrame;

/**
 *
 * @author Alberto Paz
 */
public class Ejercicio3 {
    public static void main(String[] args){
        Menu menu = new Menu();

        menu.setLocationRelativeTo(null);

        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setSize(300, 300);
        menu.setVisible(true);
    }    
}
