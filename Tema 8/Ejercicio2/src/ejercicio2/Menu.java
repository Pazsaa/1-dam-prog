/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejercicio2;
import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Alberto
 */
public class Menu extends JFrame implements ActionListener{
   
   JLabel lbl_file;
   JLabel lbl_dir;
    
   JTextField txt_file;
   JTextField txt_dir;
   
   JButton btn_copy;
   JButton btn_del;
   
   public Menu(){
      super("Copy/Del");
      this.setLayout(new FlowLayout());
      
      
      lbl_file = new JLabel("Archivo: ");
      lbl_file.setVisible(true);
      add(lbl_file);
      
      txt_file = new JTextField(30);
      add(txt_file);
      
      lbl_dir = new JLabel("Directorio: ");
      lbl_dir.setVisible(true);
      add(lbl_dir);
      
      txt_dir = new JTextField(30);
      add(txt_dir);
      
      btn_copy = new JButton("Copiar");
      btn_copy.addActionListener(this);
      add(btn_copy);
      
      btn_del = new JButton("Borrar");
      btn_del.addActionListener(this);
      add(btn_del);
   }

   public static boolean copy(File o, File d){
       try(Scanner reader = new Scanner(o)){
           String line;
           while(reader.hasNext()){
               line = reader.nextLine();
               try(PrintWriter pw = new PrintWriter(new FileWriter(d, true))){
                   pw.println(line);
               }
           }
       }catch(IOException e){
           JOptionPane.showMessageDialog(null, e.getMessage());
       }
       return true;
   }
   
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == btn_copy){
            File origin = new File(txt_file.getText());
            File dest = new File(txt_dir.getText());
            
            if(!origin.isFile())
                JOptionPane.showMessageDialog(null, "El campo archivo debe contener la ruta de un archivo existente.");
            else if(!dest.isDirectory())
                JOptionPane.showMessageDialog(null, "El campo directorio debe contener la ruta de un directorio existente.");
            else{
                dest = new File(txt_dir.getText() + "\\" + origin.getName());
                
                try{
                    dest.createNewFile();
                    copy(origin, dest);
                    JOptionPane.showMessageDialog(null, "Archivo copiado satisfactoriamente");
                }catch(IOException e){
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
        }
        else if(ae.getSource() == btn_del){
            File f = new File(txt_file.getText());
            int res = JOptionPane.showConfirmDialog(null,"¿Seguro que quieres borrar el archivo?", "Si", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(res == JOptionPane.YES_OPTION){
                f.delete();
                JOptionPane.showMessageDialog(null, "Archivo borrado satisfactoriamente");
            }
        }
    }
}
