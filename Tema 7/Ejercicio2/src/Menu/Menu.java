package Menu;

import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Alberto Paz
 */
public class Menu extends JFrame implements ActionListener, ItemListener{
    public JTextField text;
    public JButton btn;
    public JCheckBox ch;
    public String texto;
    
    public Menu(){
        super("Ejercicio apuntes 2");
        this.setLayout(null);
        
        text = new JTextField("Feed me text...");
        text.setSize(text.getPreferredSize());
        text.setLocation(100,100);
        text.addActionListener(this);
        this.add(text);
        
        btn = new JButton("GO!");
        btn.setSize(text.getPreferredSize());
        btn.setLocation(100, 117);
        btn.addActionListener(this);
        this.add(btn);
        
        ch = new JCheckBox("Invertir");
        ch.setSize(ch.getPreferredSize());
        ch.setLocation(100, 150);
        ch.addItemListener(this);
        this.add(ch);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        int res = JOptionPane.showConfirmDialog(null,"Cambiar el titulo a \"" + text.getText() + "\"?",
                "??", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        if(res == JOptionPane.YES_OPTION){
            this.setTitle(text.getText());
        }
    }
    
    @Override
    public void itemStateChanged(ItemEvent ie){
        if(ch.isSelected()){
            String old = text.getText().trim();
            String reves = "";
            for(int i = old.length() - 1; i >= 0; i--){
                reves += old.charAt(i);
            }
            
            System.out.println(reves);
            
            int res = JOptionPane.showConfirmDialog(null,"Cambiar el titulo a \"" + reves + "\"?",
                "??", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        
            if(res == JOptionPane.YES_OPTION){
                this.setTitle(reves);
            }
        }
    }
} 
