package ejercicio5;

/**
 *
 * @author Alberto
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Menu extends JFrame implements ActionListener{
    JButton btn_selectf;
    JButton btn_create;
    JTextArea txt_area;
    
    JTextField txt_result_1;
    JTextField txt_result_2;
    JTextField txt_result_3;
    
    public Menu(){
        super("Read CSV");
        this.setLayout(new FlowLayout());
        
        txt_area = new JTextArea(30,30);
        txt_area.setEditable(false);
        txt_area.setVisible(true);
        add(new JScrollPane(txt_area));
        
        txt_result_1 = new JTextField(9);
        txt_result_1.setEditable(false);
        add(txt_result_1);
        
        txt_result_2 = new JTextField(9);
        txt_result_2.setEditable(false);
        add(txt_result_2);
        
        txt_result_3 = new JTextField(9);
        txt_result_3.setEditable(false);
        add(txt_result_3);
        
        btn_selectf = new JButton("Abrir archivo");
        btn_selectf.addActionListener(this);
        add(btn_selectf);
        
        btn_create = new JButton("Crear archivo");
        btn_create.addActionListener(this);
        add(btn_create);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btn_selectf){
            int res;
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Texto", "txt");
            JFileChooser fc = new JFileChooser();
            fc.addChoosableFileFilter(filter);
            fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
            res = fc.showOpenDialog(this);
            
            if(res == JFileChooser.APPROVE_OPTION){
                String file_name = fc.getSelectedFile().getName();
                String file_ext  = file_name.substring(file_name.lastIndexOf(".") + 1);
                
                if(!"txt".equals(file_ext))
                    JOptionPane.showMessageDialog(null, "El archivo debe ser un txt!");
                else{
                    txt_area.setText(readText(new File(fc.getSelectedFile().getPath())));
                    txt_result_1.setText("" + columnAvg(new File(fc.getSelectedFile().getPath()), 0));
                    txt_result_2.setText("" + columnAvg(new File(fc.getSelectedFile().getPath()), 1));
                    txt_result_3.setText("" + columnAvg(new File(fc.getSelectedFile().getPath()), 2));
                }
            }
        }
        
    if(e.getSource() == btn_create){
            System.out.println("hey");
            String lines = JOptionPane.showInputDialog(null, "Numero de lineas:");
            File f = new File("C:\\Users\\Alberto\\Desktop\\PROGRAMMING\\Boletines JAVA\\Tema 8\\random.txt");
            try {
                f.createNewFile();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
            
            try(PrintWriter pw = new PrintWriter(new FileWriter(f))){
                for(int i = 0; i < Integer.parseInt(lines); i++){

                    pw.println((int)(Math.random() * 10 + 100) + "," + (Math.random() * 0 + 1000) + "," + (Math.random() * 10 + 10000));

                }
            }catch(IOException ex){
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }

            txt_area.setText(readText(f));
            txt_result_1.setText("" + columnAvg(f, 0));
        }
       
    }
    
    public static String readText(File f){
        String text = "";
        
        try(Scanner reader = new Scanner(f)){
            while(reader.hasNext()){
                text += reader.nextLine();
                text += "\n";
            }
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return text;
    }
    
    public static int columnAvg(File f, int col_index){
        int result = 0;
        int total = 0;
        try(Scanner reader = new Scanner(f)){
            while(reader.hasNext()){
                String[] cols = reader.nextLine().split(",");
                result += Integer.parseInt(cols[col_index]);
                total++;
            }              
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
        
        return result / total;
    } 
}
