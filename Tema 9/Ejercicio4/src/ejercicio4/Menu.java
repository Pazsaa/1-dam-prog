/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejercicio4;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Alberto
 */
public class Menu extends JFrame implements ActionListener, ItemListener {

    JTextField txf_num_1, txf_num_2;
    
    JLabel lbl_operator, lbl_result, lbl_error;
    String operator  = "+";
    int result = 0;
    
    JRadioButton rbtn_add, rbtn_sub, rbtn_mult, rbtn_div;
    ButtonGroup bg_group;
    
    JButton btn_calculate;
    
    String path = "C:\\Users\\Alberto\\Desktop\\PROGRAMMING\\Boletines JAVA\\Tema 9\\prueba.data";
   
    public Menu(){
        super("Calculadora");
        this.setLayout(null);
        
        txf_num_1 = new JTextField();
        txf_num_1.setSize(100, 30);
        txf_num_1.setLocation(20, 20);
        this.add(txf_num_1);
        
        txf_num_2 = new JTextField();
        txf_num_2.setSize(100, 30);
        txf_num_2.setLocation(140, 20);
        this.add(txf_num_2);
        
        lbl_operator = new JLabel("+");
        lbl_operator.setSize(150, 20);
        lbl_operator.setLocation(123, 23);
        this.add(lbl_operator);
        
        lbl_result = new JLabel(" = ");
        lbl_result.setSize(120, 20);
        lbl_result.setLocation(240, 23);
        this.add(lbl_result);
        
        lbl_error = new JLabel("");
        lbl_error.setSize(120, 20);
        lbl_error.setLocation(20, 170);
        lbl_error.setForeground(Color.RED);
        lbl_error.setVisible(false);
        this.add(lbl_error);
        
        rbtn_add = new JRadioButton("suma");
        rbtn_add.setSize(100, 20);
        rbtn_add.setLocation(105, 50);
        rbtn_add.setSelected(true);
        rbtn_add.addItemListener(this);
        this.add(rbtn_add);
        
        rbtn_sub = new JRadioButton("resta");
        rbtn_sub.setSize(100, 20);
        rbtn_sub.setLocation(105, 70);
        rbtn_sub.setSelected(false);
        rbtn_sub.addItemListener(this);
        this.add(rbtn_sub);
        
        rbtn_mult = new JRadioButton("multiplicacion");
        rbtn_mult.setSize(100, 20);
        rbtn_mult.setLocation(105, 90);
        rbtn_mult.setSelected(false);
        rbtn_mult.addItemListener(this);
        this.add(rbtn_mult);
        
        rbtn_div = new JRadioButton("division");
        rbtn_div.setSize(100, 20);
        rbtn_div.setLocation(105, 110);
        rbtn_div.setSelected(false);
        rbtn_div.addItemListener(this);
        this.add(rbtn_div);
        
        btn_calculate = new JButton("Operar");
        btn_calculate.setSize(225, 25);
        btn_calculate.setLocation(20, 140);
        btn_calculate.addActionListener(this);
        this.add(btn_calculate);
        
        bg_group = new ButtonGroup();
        bg_group.add(rbtn_add);
        bg_group.add(rbtn_sub);
        bg_group.add(rbtn_mult);
        bg_group.add(rbtn_div);
        
        this.addWindowListener(new Cerrar());
        
        try(RandomAccessFile f = new RandomAccessFile(path, "r")){
            
            // Si uso numeros grandes se vuelve loco > Leer sobre binarios
            f.seek(0);
            int n1 = f.readByte();
            txf_num_1.setText("" + n1);
            
            f.seek(1);
            int n2 = f.readByte();
            txf_num_2.setText("" + n2);
            
            f.seek(2);
            int n3 = f.readByte();
            lbl_result.setText("= " + n3);
            
            f.seek(3);
            char op = f.readChar();
            lbl_operator.setText("" + op);
            
            switch(op){
                case '+':
                    rbtn_add.setSelected(true);
                    break;
                case '-':
                    rbtn_sub.setSelected(true);
                    break;
                case '*':
                    rbtn_mult.setSelected(true);
                    break;
                case '/':
                    rbtn_div.setSelected(true);
                    break;
                default:
                    break;
            }
            
        }catch(IOException ex){
            JOptionPane.showMessageDialog(null, "No se ha encontrado archivo de datos, utilizando valores por defecto...");
        }

    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            int n1 = Integer.parseInt(txf_num_1.getText());
            int n2 = Integer.parseInt(txf_num_2.getText());
            
            if(rbtn_add.isSelected())
                result = n1 + n2;
            if(rbtn_sub.isSelected())
                result = n1 - n2;
            if(rbtn_mult.isSelected())
                result = n1 * n2;
            if(rbtn_div.isSelected())
                result = n1 / n2;
            
            lbl_result.setText("= " + result);
            lbl_error.setVisible(false);
        }
        catch(NumberFormatException | ArithmeticException ex){
            lbl_error.setText(ex.getMessage());
            lbl_error.setVisible(true);
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource() == rbtn_add)
            operator = "+";
        if(e.getSource() == rbtn_sub)
            operator = "-";
        if(e.getSource() == rbtn_mult)
            operator = "*";
        if(e.getSource() == rbtn_div)
            operator = "/";
        
        lbl_operator.setText(operator);
    }
    
    
    private class Cerrar extends WindowAdapter{
        @Override
        public void windowClosing(WindowEvent e){
            try(RandomAccessFile f = new RandomAccessFile(path, "rw")){
                f.setLength(0);
                
                f.writeByte(Integer.parseInt(txf_num_1.getText()));
                f.writeByte(Integer.parseInt(txf_num_2.getText()));
                f.writeByte(result);
                f.writeChar(lbl_operator.getText().charAt(0));
                
                e.getWindow().dispose();
            }catch(IOException | NumberFormatException ex){
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }
}
