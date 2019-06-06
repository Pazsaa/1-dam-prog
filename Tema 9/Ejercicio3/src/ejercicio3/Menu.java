/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejercicio3;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.Timer;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Alberto
 */
public class Menu extends JFrame implements ActionListener, ListSelectionListener, ItemListener{
    
    JButton btn_add, btn_rem, btn_move_1, btn_move_2;
    
    JTextField txf_text;
    
    JLabel lbl_1, lbl_2, lbl_3;
    int added_elements = 0;
    
    JComboBox<String> cb_combo;
    
    JList<String> lst_list;
    DefaultListModel<String> lst_model = new DefaultListModel<String>();
    
    Timer timer;
    int iddle = 0;
    
    public Menu(){
        super("Ejercicio 3");
        this.setLayout(null);
        
        btn_add = new JButton("Añadir");
        btn_add.setSize(110, 25);
        btn_add.setLocation(20, 20);
        btn_add.addActionListener(this);
        btn_add.setToolTipText("Añade un elemento a la lista.");
        this.add(btn_add);
        
        btn_rem = new JButton("Eliminar");
        btn_rem.setSize(110, 25);
        btn_rem.setLocation(20, 60);
        btn_rem.addActionListener(this);
        btn_rem.addMouseListener(new MouseHandler());
        btn_rem.addMouseMotionListener(new MouseHandler());
        btn_rem.setToolTipText("Elimina los valores seleccionados de la lista");
        this.add(btn_rem);
        
        btn_move_1 = new JButton("Mover L-C");
        btn_move_1.setSize(110, 25);
        btn_move_1.setLocation(20, 100);
        btn_move_1.addActionListener(this);
        btn_move_1.setToolTipText("Mueve la seleccion de la lista a la combobox");
        this.add(btn_move_1);
        
        btn_move_2 = new JButton("Mover C-L");
        btn_move_2.setSize(110, 25);
        btn_move_2.setLocation(20, 140);
        btn_move_2.addActionListener(this);
        btn_move_2.setToolTipText("Mueve la selección de la combobox a la lista");
        this.add(btn_move_2);
        
        txf_text = new JTextField();
        txf_text.setSize(110, 25);
        txf_text.setLocation(180, 85);
        txf_text.setToolTipText("Introduce un elemento a añadir...");
        this.add(txf_text);
        
        lst_list = new JList(lst_model);
        lst_list.setSize(110, 150);
        lst_list.setLocation(320, 20);
        lst_list.addListSelectionListener(this);
        lst_list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        lst_list.setToolTipText("eh...");
        this.add(lst_list);
        
        cb_combo = new JComboBox<String>();
        cb_combo.setSize(110, 25);
        cb_combo.setLocation(520, 20);
        cb_combo.addActionListener(this);
        cb_combo.addItemListener(this);
        this.add(cb_combo);
        
        lbl_1 = new JLabel("Elementos: ");
        lbl_1.setSize(250, 20);
        lbl_1.setLocation(20, 220);
        this.add(lbl_1);
        
        lbl_2 = new JLabel();
        this.add(lbl_2);
        
        lbl_3 = new JLabel("Indices: ");
        lbl_3.setSize(250, 20);
        lbl_3.setLocation(320, 220);
        this.add(lbl_3);
     
        timer = new Timer(1000, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                iddle++;
                if(iddle == 60){
                    lst_model.removeAllElements();
                    cb_combo.removeAllItems();
                    
                    txf_text.setText("");
                    
                    lbl_1.setText("Elementos :");
                    lbl_3.setText("Indices: ");
                    
                    iddle = 0;
                }
            }
        });
        timer.start();
        
        this.addWindowListener(new Cerrar());
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btn_add){
            if(!txf_text.getText().trim().equals("")){
                added_elements++;
                lst_model.addElement(txf_text.getText());
                lbl_1.setText("Elementos: " + added_elements);
            }
        }
        
        if(e.getSource() == btn_rem){
            int [] indexes = lst_list.getSelectedIndices();
            for(int i = indexes.length - 1; i >= 0; i--){
                added_elements--;
                lst_model.removeElementAt(i);
                lbl_1.setText("Elementos " + added_elements);
            }
        }
        
        if(e.getSource() == btn_move_1){
            int [] indexes = lst_list.getSelectedIndices();
            List<String> vals = lst_list.getSelectedValuesList();
            
            for(int i = indexes.length - 1; i >= 0; i--){
                added_elements--;
                lbl_1.setText("Elementos " + added_elements);
                lst_model.removeElementAt(indexes[i]);
            }
            cb_combo.setModel(new DefaultComboBoxModel(vals.toArray()));
        }
        
        if(e.getSource() == btn_move_2){
            Object obj = cb_combo.getSelectedItem();
            cb_combo.removeItem(obj);
            lst_model.addElement(obj.toString());
            
            added_elements++;
            lbl_1.setText("Elementos " + added_elements);
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if(e.getSource() == lst_list){
            String selected = "";
            int[] indexes = lst_list.getSelectedIndices();
            for(Integer i: indexes){
                selected += i + " -- ";
            }
            lbl_3.setText("Indices: " + selected);
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource() == cb_combo){
            cb_combo.setToolTipText("Seleccionado ínidice" + cb_combo.getSelectedIndex());
        }
    }
    
    private class MouseHandler extends MouseAdapter{
        @Override
        public void mouseEntered(MouseEvent e){
            btn_rem.setBackground(Color.RED);
        }
        
        @Override
        public void mouseExited(MouseEvent e){
            btn_rem.setBackground(null);
        }
    }
    
    private class Cerrar extends WindowAdapter{
        @Override
        public void windowClosing(WindowEvent e){
            int res = JOptionPane.showConfirmDialog(null, "¿Seguro que quieres salir?", null,
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            
            if(res == JOptionPane.OK_OPTION)
                e.getWindow().dispose();
        }
    }
}
