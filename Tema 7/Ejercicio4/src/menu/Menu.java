/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;


import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Timer;

/**
 *
 * @author apazgarcia
 */
public class Menu extends JFrame implements ActionListener {
    JTextField txt_1; 
    JTextField txt_2; 
    JTextField txt_3; 
    
    JButton play;
    
    JLabel lbl;
    JLabel timer;
    
    Timer temporizador;    
    private int min;
    private int sec;
    
    public Menu(){
        super("Tragaperras");
        this.setLayout(new FlowLayout());
        
        txt_1 = new JTextField(3);
        txt_1.addActionListener(this);
        txt_1.setEditable(false);
        add(txt_1);

        txt_2 = new JTextField(3);
        txt_2.addActionListener(this);
        txt_2.setEditable(false);
        add(txt_2);

        txt_3 = new JTextField(3);
        txt_3.addActionListener(this);
        txt_3.setEditable(false);
        add(txt_3);
        
        play = new JButton("PLAY");
        play.setToolTipText("HIT ME TO PLAY");
        play.addActionListener(this);
        add(play);
        
        lbl = new JLabel("Etiqueta");
        add(lbl);

        timer = new JLabel("00:00");
        add(timer);
        
        sec = 0;
        temporizador = new Timer(1000, new ActionListener() {
        @Override
            public void actionPerformed(ActionEvent ae) {
                String display = "";
                sec++;
                if (sec == 60) {
                    sec = 0;
                    min = min + 1;
                }
                display = String.format("%02d:%02d", min, sec);
                timer.setText(display);
            }
        });
        temporizador.start();
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        temporizador.start();
        if (ae.getSource() == play) {

            int num1 = (int) (Math.random() * 6 + 1);
            int num2 = (int) (Math.random() * 6 + 1);
            int num3 = (int) (Math.random() * 6 + 1);

            txt_1.setText("" + num1);
            txt_2.setText("" + num2);
            txt_3.setText("" + num3);
            if (num1 == num2 && num2 == num3) {
                lbl.setText("Lul winner");

            } else {
                lbl.setText("¡Mec!");
            }

        }
    }
}
