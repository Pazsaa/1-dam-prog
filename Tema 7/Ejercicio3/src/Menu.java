import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alberto Paz
 */
public class Menu extends JFrame implements ActionListener{
    public JTextField txt_1;
    public JTextField txt_2;
    public JLabel lbl;
    public JButton btn_sum;
    public JButton btn_div;
    public JButton btn_sqr;
    
    public Menu(){
        super("Calculadora");
        this.setLayout(new FlowLayout());
        
        txt_1 = new JTextField(9);
        this.add(txt_1);
        
        txt_2 = new JTextField(9);
        this.add(txt_2);
        
        lbl=new JLabel("= ");
        this.add(lbl);
        
        btn_sum = new JButton("Suma");
        btn_sum.setToolTipText("Suma ambos numeros.");
        btn_sum.addActionListener(this);
        this.add(btn_sum);
        
        btn_div = new JButton("Division");
        btn_div.setToolTipText("Divide ambos numeros");
        btn_div.addActionListener(this);
        this.add(btn_div);
        
        btn_sqr = new JButton("Raíz");
        btn_sqr.setToolTipText("Raiz del primer numero");
        btn_sqr.addActionListener(this);
        this.add(btn_sqr);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        int n1, n2;
        int res = 0;

        try {
            if (e.getSource() == btn_sum) {
                n1 = Integer.parseInt(txt_1.getText());
                n2 = Integer.parseInt(txt_2.getText());
                res = n1 + n2;
                lbl.setForeground(Color.black);
                lbl.setText(" = " + res);
            }

            if (e.getSource() == btn_div) {
                n1 = Integer.parseInt(txt_1.getText());
                n2 = Integer.parseInt(txt_2.getText());
                if (n2 == 0) {
                    lbl.setForeground(Color.red);
                    lbl.setText("Error, división entre 0");
                } else {
                    lbl.setForeground(Color.black);
                    float res4 = (float) n1 / n2;
                    lbl.setText(String.format(" = " + "%.3f", res4));
                }

            }

            if (e.getSource() == btn_sqr) {
                n1 = Integer.parseInt(txt_1.getText());
                if (n1 <= 0) {
                    lbl.setForeground(Color.red);
                    lbl.setText("Error,número incorrecto, introduzca de nuevo");
                } else {
                    lbl.setForeground(Color.black);
                    double res3 = Math.sqrt(n1);
                    lbl.setText(String.format(" = " + "%.3f", res3));
                }

            }

        } catch (NumberFormatException ex) {
            lbl.setForeground(Color.red);
            lbl.setText("Error");
        }
    }
}
