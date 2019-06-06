/**
 *
 * @author Alberto
 */

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Menu extends JFrame implements ActionListener{
    JTextField txt_r;
    JTextField txt_g;
    JTextField txt_b;
    
    JTextField txt_img;
    
    JButton btn_color;
    
    JLabel lbl_r;
    JLabel lbl_g;
    JLabel lbl_b;
    JLabel lbl_img;
    JLabel lbl_imgin;
    
    ImageIcon img;
    
    public Menu(){
        super("Ejercicio 5");
        this.setLayout(new FlowLayout());
        
        lbl_r = new JLabel("Rojo");
        add(lbl_r);
        
        txt_r = new JTextField(9);
        txt_r.addActionListener(this);
        txt_r.setToolTipText("Valor para color rojo (0-255)");
        add(txt_r);
        
        lbl_g = new JLabel("Verde");
        add(lbl_g);
        
        txt_g = new JTextField(9);
        txt_g.addActionListener(this);
        txt_g.setToolTipText("Valor para color verde (0-255)");
        add(txt_g);
        
        lbl_b = new JLabel("Azul");
        add(lbl_b);
        
        txt_b = new JTextField(9);
        txt_b.addActionListener(this);
        txt_b.setToolTipText("Valor para color azul (0-255)");
        add(txt_b);
        
        btn_color = new JButton("Color");
        btn_color.addActionListener(this);
        btn_color.setToolTipText("Cambia el color según los valores introducidos");
        add(btn_color);
        
        lbl_imgin = new JLabel("Imagen");
        add(lbl_imgin);
        
        txt_img = new JTextField(30);
        txt_img.addActionListener(this);
        txt_img.setToolTipText("Ruta de la imagen que se quiere mostrar");
        add(txt_img);
        
        lbl_img = new JLabel("");
        add(lbl_img);
        lbl_img.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == txt_img){
            String img_src = txt_img.getText();
            img = new ImageIcon(img_src);
            lbl_img.setIcon(img);
            lbl_img.setVisible(true);
            this.pack();
        }
        else{
            try{
                int r = Integer.parseInt(txt_r.getText());
                int g = Integer.parseInt(txt_g.getText());
                int b = Integer.parseInt(txt_b.getText());
                
                if((ae.getModifiers() & ActionEvent.CTRL_MASK) == ActionEvent.CTRL_MASK){
                    btn_color.setForeground(new Color(r,g,b));
                }
                else if(ae.getSource() == btn_color){
                    btn_color.setBackground(new Color(r,g,b));                  
                }
                if(ae.getSource() == txt_b){
                    btn_color.setBackground(new Color(r,g,b));
                }
            }
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Solo se admiten valores numéricos.");
            }
            catch(IllegalArgumentException e){
                JOptionPane.showMessageDialog(null, "Numeros fuera de límites, se aceptan valores entre 0 y 255");
            }
        }
    }
}
