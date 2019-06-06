/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alberto
 */

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Tragaperras extends JFrame implements ActionListener {
    String path = "C:\\Users\\Alberto\\Desktop\\PROGRAMMING\\Boletines JAVA\\Tema 7\\Ejercicio6\\images\\";
    float money = 10;
    int timer_entries = 0;
    
    JLabel lbl_left;
    JLabel lbl_mid;
    JLabel lbl_right;
    
    JLabel lbl_money;
    
    JLabel lbl_result;
    
    JButton btn_play;
    
    ImageIcon img = new ImageIcon("C:\\Users\\Alberto\\Desktop\\PROGRAMMING\\Boletines JAVA\\Tema 7\\Ejercicio6\\images\\question.png");
    
    Timer timer;
    
    public Tragaperras(){
        super("Superminitragaperras");
        this.setLayout(new FlowLayout());
             
        lbl_left = new JLabel();
        lbl_left.setIcon(img);
        lbl_left.setVisible(true);
        add(lbl_left);
        
        lbl_mid = new JLabel();
        lbl_mid.setIcon(img);
        lbl_mid.setVisible(true);
        add(lbl_mid);
        
        lbl_right = new JLabel();
        lbl_right.setIcon(img);
        lbl_right.setVisible(true);
        add(lbl_right);
        
        lbl_result = new JLabel();
        lbl_result.setVisible(false);
        add(lbl_result);
        
        btn_play = new JButton("PLAY!");
        btn_play.addActionListener(this);
        add(btn_play);
        
        lbl_money = new JLabel(money + "€");
        lbl_money.setVisible(true);
        add(lbl_money);
        
        timer = new Timer(400, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                timer_entries ++;
                if(timer_entries % 2 == 0)
                    lbl_result.setForeground(new Color(3, 160, 34));
                else
                    lbl_result.setForeground(new Color(3, 160, 139));
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == btn_play && money >= 1){
           timer.stop();
           int n1 = (int) (Math.random() * 6 + 1);
           int n2 = (int) (Math.random() * 6 + 1);
           int n3 = (int) (Math.random() * 6 + 1);
           
           lbl_left.setIcon(new ImageIcon(path + n1 + ".png"));
           lbl_mid.setIcon(new ImageIcon(path + n2 + ".png"));
           lbl_right.setIcon(new ImageIcon(path + n3 + ".png"));
           
           if(n1 == n2 && n2 == n3){
               money += 9;
               lbl_money.setText(money + "€");
               
               lbl_result.setText("GANAS 10€");
               lbl_result.setVisible(true);
               
               timer.start();
           }
           else if ( n1 == n2 || n1 == n3 || n2 == n3){
               money += .5;
               lbl_money.setText(money + "€");
               
               lbl_result.setText("GANAS 1,5€");
               lbl_result.setForeground(Color.green);
               lbl_result.setVisible(true);
               
           }
           else{
               money--;
               lbl_money.setText(money + "€");
               
               lbl_result.setText("PIERDES 1€");
               lbl_result.setForeground(Color.red);
               lbl_result.setVisible(true);
           }
       }
       else{
           lbl_result.setText("GAME OVER");
           lbl_result.setForeground(Color.red);
           lbl_result.setVisible(true);
       }
    }
}
