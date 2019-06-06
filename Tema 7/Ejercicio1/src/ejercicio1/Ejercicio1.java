/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1;

import javax.swing.JOptionPane;

/**
 *
 * @author apazgarcia
 */
public class Ejercicio1 {
  

    public static void main(String[] args) {
        int again;

        do {
            try {
                int n1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Primer numero: "));
                int n2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Segundo numero: "));

                int res = n1 + n2;
                JOptionPane.showMessageDialog(null, "El resultado es: " + res);
            } catch (Exception NumberFormatException) {
                JOptionPane.showMessageDialog(null, "De momento, solo sabemos sumar numeros.");
            }

            again = JOptionPane.showConfirmDialog(null, "¿Repetir?", "Si", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        } while (again == JOptionPane.YES_OPTION);

    }
}
