package ejercicio1apuntes;
import javax.swing.*;

public class Ejercicio1Apuntes{
    public static void main(String[] args){
        Formulario formulario = new Formulario();
        
        formulario.setLocationRelativeTo(null);
        
        formulario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        formulario.setSize(300, 300);
        formulario.setVisible(true);
        
    }
}