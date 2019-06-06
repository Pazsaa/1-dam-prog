package ejercicio3;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Alberto
 */
public class Menu extends JFrame implements ActionListener{
    JButton btn_selectf;
    JTextArea txt_area;
    JLabel lbl_img;
    ImageIcon img;
    
    public Menu(){
        super("JFileChooser");
        this.setLayout(new FlowLayout());
        
        txt_area = new JTextArea(30, 30);
        txt_area.setEditable(false);
        txt_area.setVisible(true);
        this.add(new JScrollPane(txt_area));
        
        btn_selectf = new JButton("Abrir archivo");
        btn_selectf.addActionListener(this);
        this.add(btn_selectf);
                       
        lbl_img = new JLabel("");
        lbl_img.setVisible(false);
        this.add(lbl_img);    
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
    
    public static String readBytes(File f) throws FileNotFoundException, IOException{
        String text = "";
        FileInputStream fs = new FileInputStream(f);
        
        int len;
        byte data[] = new byte[16];
        
        do{
            len = fs.read(data);
            for(int i = 0; i < len; i++){
                text += String.format("%02x ", data[i]);
            }
        }while(len != -1);
        return text;
    }
    
   
    @Override
    public void actionPerformed(ActionEvent e) {
        int res;
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Imágenes y texto", "txt", "jpg", "png", "gif");
        JFileChooser fc = new JFileChooser();
        fc.addChoosableFileFilter(filter);
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        res = fc.showOpenDialog(this);
        
        if(res == JFileChooser.APPROVE_OPTION && fc.getSelectedFile().isFile()){
            String source = fc.getSelectedFile().getPath();
            String file_name = fc.getSelectedFile().getName();
            String extension = file_name.substring(file_name.lastIndexOf(".") + 1);
                       
            switch(extension){
                case "txt":
                    String text = readText(new File(source));
                    txt_area.setText(text);
                                        
                    lbl_img.setVisible(false);
                    break;
                case "png":
                case "jpg":
                case "gif":
                case "jpeg":
                    img = new ImageIcon(source);
                    lbl_img.setIcon(img);
                    lbl_img.setVisible(true);
                    break;                  
                default:
                    String perms = fc.getSelectedFile().canRead() ? "r": "";
                    perms += fc.getSelectedFile().canWrite() ? "w" : "";
                    perms += fc.getSelectedFile().canExecute() ? "x" : "";
                    
                    String info ="<html><body>" +
                                file_name + "<br>"
                                + source  + "<br>"
                                + fc.getSelectedFile().length() + "<br>"
                                + perms 
                                + "</body></html>";
                    
                    try {
                        String bytes = readBytes(new File(source));
                        txt_area.setText(bytes);
                    } catch (IOException ex) {
                       JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                  
                    lbl_img.setIcon(null);
                    lbl_img.setText(info);
                    lbl_img.setVisible(true);
                    break;
            }       
        }
        else if(res == JFileChooser.APPROVE_OPTION){
            String dir = fc.getSelectedFile().getPath();
            File f = new File(dir);
            
            String texto = "";
            
            for (String list : f.list()) {
                texto += new File(dir + "\\" + list).isFile() ? list + "\n" : list + "  D\n";
            }
            
            txt_area.setText(texto);
        }
       
    }
}
