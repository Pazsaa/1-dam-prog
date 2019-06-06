/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejercicio9;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTextField;

/**
 *
 * @author Alberto
 */
public class MenuSecundario extends JDialog implements ActionListener, ItemListener{

    JTextField txt_1;
    
    JComboBox<String> combo;
    String[] colors = {"Azul", "Rojo", "Amarillo", "Verde"};
    
    JButton btn_add;
    
    Menu m;

    public MenuSecundario(Menu menu){
        super(menu, true);
        setLayout(new FlowLayout());
        String title;
        
        combo = new JComboBox<String>(colors);
        combo.addItemListener(this);
        this.add(combo);
        
        txt_1 = new JTextField(10);
        txt_1.addActionListener(this);
        this.add(txt_1);
        
        m = menu;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        m.title = txt_1.getText().toString();
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        String selected = (String) combo.getSelectedItem();
        
        switch(selected){
            case "Rojo":
                m.c = Color.RED;
                break;
            case "Verde":
                m.c = Color.GREEN;
                break;
            case "Azul":
                m.c = Color.BLUE;
                break;
            case "Amarillo":
                m.c = Color.YELLOW;
                break;
            default:
                break;
        }
    }
    
}
